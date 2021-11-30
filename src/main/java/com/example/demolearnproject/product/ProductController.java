package com.example.demolearnproject.product;

import com.example.demolearnproject.category.Category;
import com.example.demolearnproject.category.CategoryRespository;
import com.example.demolearnproject.category.CategoryService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
@CrossOrigin()
public class ProductController {

    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryRespository categoryRespository;

    @Autowired private ProductService productService;
    @Autowired private CategoryService categoryService;


    @GetMapping("/product")
    public String listProduct(Model model){
        List<Product> productList = productService.listIsFalse();
        model.addAttribute("listProduct",productList);
        return "admin/product/index";
    }

    @GetMapping("/product/new")
    public String newProduct(Model model){
        List<Category> listCategories = categoryService.listIsFalse();
        System.out.println(listCategories);
        model.addAttribute("pageTitle","Product");
        model.addAttribute("product",new Product());
        model.addAttribute("listCategories",listCategories);

        return "admin/product/form";
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product, HttpServletRequest request, @RequestParam("fileImage") MultipartFile multipartFile,@RequestParam("detailFile") MultipartFile[] files) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setImage(fileName);
        List<String> fileNames = new ArrayList<>();

        String[] detailIDs = request.getParameterValues("detailID");
        String[] detailNames = request.getParameterValues("detailName");
        String[] detailValues = request.getParameterValues("detailValue");

        for (int i = 0; i < detailNames.length;i++){
            if (detailIDs != null && detailIDs.length > 0){
                product.setDetail(Integer.valueOf(detailIDs[i]),detailNames[i],detailValues[i]);
            }else {
                product.addDetail(detailNames[i],detailValues[i]);
            }
        }

        // read and write the file to the local folder
        Arrays.asList(files).stream().forEach(file -> {
                product.addFdetail(file.getOriginalFilename(),FilenameUtils.getExtension(file.getOriginalFilename()));
        });

        Product savedProduct = productService.save(product);


        String uploadDir = "./product-images/" + savedProduct.getId();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);

        // read and write the file to the local folder
        Arrays.asList(files).stream().forEach(file -> {
            byte[] bytes = new byte[0];
            try {
                bytes = file.getBytes();
                Files.write(Paths.get(FileUtil.folderPath+ "//" +product.getId()+ "//" + file.getOriginalFilename()), bytes);
            } catch (IOException e) {

            }
        });

        }catch (IOException e){
            throw new IOException("Could not save uploaded file: " + fileName);
        }

        return "redirect:/admin/product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) throws ProductNotFoundException{

            List<Category> listCategories = categoryService.listIsFalse();
            Product product = productService.get(id);
            model.addAttribute("product",product);
            model.addAttribute("listCategories",listCategories);

            return "admin/product/form";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id,RedirectAttributes ra){

        try {
            productService.remove(id);
            ra.addFlashAttribute("message","The brand has been removed successfully !");
        }catch (ProductNotFoundException e){
            e.printStackTrace();
            ra.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/admin/product";
    }


}
