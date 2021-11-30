package com.example.demolearnproject.user;

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
public class UserController {

//    @Autowired private UserRepository userRepository;
    @Autowired private UserService userService;
    @Autowired private RoleService roleService;
//    @Autowired private RoleRepository roleRepository;

    @GetMapping("user")
    public String listUsers(Model model){
        List<User> listUser = userService.listIsFalse();
        model.addAttribute("listUser",listUser);

        return "admin/user/index";
    }

    @GetMapping("user/new")
    public String newUser(Model model){
        List<Role> listRoles = roleService.listAll();
        model.addAttribute("user",new User());
        model.addAttribute("listRoles",listRoles);

        return "admin/user/form";
    }

    @PostMapping("user/save")
    public String saveUser(User user,@RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setPhotos(fileName);

        userService.save(user);

        String uploadDir = "user-photos/" + user.getId();

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

//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "redirect:/admin/user";
    }

    @GetMapping("user/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){

        try {
            List<Role> listRoles = roleService.listAll();
            User user = userService.get(id);
            model.addAttribute("user",user);
            model.addAttribute("listRoles",listRoles);

            return "admin/user/form";
        }catch (UserNotFoundException e){
            e.printStackTrace();
            ra.addFlashAttribute("message",e.getMessage());
            return "reditrect:/admin/user";
        }

    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,RedirectAttributes ra){
        try {
            userService.delete(id);
            ra.addFlashAttribute("message","The user ID " + id + " has been deleted. ");
        }catch (UserNotFoundException e){
            e.printStackTrace();
            ra.addFlashAttribute("message",e.getMessage());
        }

        return "redirect:/admin/user";
    }

}
