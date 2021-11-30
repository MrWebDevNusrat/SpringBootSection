package com.example.demolearnproject.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class CategoryController {

    /*@Autowired private CategoryRespository categoryRespository;*/
    @Autowired private CategoryService categoryService;

    @GetMapping("/category")
    public String indexCategory(Model model){

        List<Category> listCategories  = categoryService.listIsFalse();

        model.addAttribute("listCategories",listCategories);

        return "admin/category/index";
    }

    @GetMapping("/category/new")
    public String newCategory(Model model){
        model.addAttribute("category",new Category());

        return "admin/category/form";
    }

    @PostMapping("category/save")
    public String saveCategory(Category category)
    {
        categoryService.save(category);

        return "redirect:/admin/category";
    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) throws CategoryNotFoundException{
        try {
            Category category = categoryService.get(id);
            model.addAttribute("category",category);

            return "admin/category/form";
        }catch (CategoryNotFoundException e){
            e.printStackTrace();
            ra.addFlashAttribute("message",e.getMessage());

            return "admin/category";
        }
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id,Model model,RedirectAttributes ra){
        try {
            categoryService.remove(id);
            ra.addFlashAttribute("message","The category Id " + id + " has been deleted. ");
        }catch (CategoryNotFoundException e){
            e.printStackTrace();
            ra.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/admin/category";
    }

}
