package com.example.demolearnproject.brand;

import com.example.demolearnproject.category.Category;
import com.example.demolearnproject.category.CategoryRespository;
import com.example.demolearnproject.category.CategoryService;
import org.codehaus.groovy.tools.shell.IO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BrandController {

    @Autowired private BrandService brandService;
    @Autowired private CategoryService categoryService;

    @GetMapping("/brand")
    public String listBrands(Model model){

        List<Brand> brandList = brandService.findAllByDeletedIsNull();
        model.addAttribute("brandList",brandList);
        return "/admin/brand/index";
    }

    @GetMapping("/brand/new")
    public String newBrand(Model model){
        List<Category> listCategories = categoryService.listAll();

        model.addAttribute("brand",new Brand());
        model.addAttribute("listCategories",listCategories);

        return "/admin/brand/form";
    }

    @PostMapping("/brand/save")
    public String saveBrand(Brand brand, @RequestParam("fileImage") MultipartFile multipartFile, RedirectAttributes ra) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        brand.setLogo(fileName);

        Brand savedBrand = brandService.save(brand);

        String uploadDir = "./brand-logos/" + savedBrand.getId();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Could not save");
        }

        return "redirect:/admin/brand";
    }

    @GetMapping("/brand/edit/{id}")
    public String editBrand(@PathVariable("id") Integer id,Model model,RedirectAttributes ra) throws BrandNotFoundException {
        try {
            List<Category> categoryList = categoryService.listIsFalse();
            Brand brand = brandService.get(id);
            model.addAttribute("brand",brand);
            model.addAttribute("listCategories",categoryList);

            return "/admin/brand/form";

        }catch (BrandNotFoundException e){
            e.printStackTrace();
            ra.addFlashAttribute("message",e.getMessage());

            return "redirect:/admin/brand";

        }
    }

    @GetMapping("/brand/delete/{id}")
    public String deleteBrand(@PathVariable("id") Integer id,Model model,RedirectAttributes ra){
        try {
            brandService.remove(id);
            ra.addFlashAttribute("message","The user ID " + id + " has been deleted.");
        }catch (BrandNotFoundException e){
            e.printStackTrace();
            ra.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/admin/brand";
    }

}
