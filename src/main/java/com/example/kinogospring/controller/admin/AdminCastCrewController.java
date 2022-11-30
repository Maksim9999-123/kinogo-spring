package com.example.kinogospring.controller.admin;

import com.example.kinogospring.entity.CastCrew;
import com.example.kinogospring.service.GetService;
import com.example.kinogospring.service.adminservice.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/castcrew")
@RequiredArgsConstructor
public class AdminCastCrewController {

    private final AdminService<CastCrew> adminService;
    private final GetService getService;
//    @GetMapping()
//    public String adminPage(ModelMap modelMap) {
//        List<Book> books = bookService.findAll();
//        modelMap.addAttribute("books", books);
//        return "admin/admin";
//    }

    @GetMapping("/add")
    public String addCastCrewPage() {
        return "";
    }

    @PostMapping("/add")
    public String addCastCrew(@ModelAttribute CastCrew castCrew) {
        adminService.save(castCrew);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editCastCrewPage(@RequestParam("castcrewId") int id, ModelMap modelMap) {
        Optional castCrewOptional = getService.getById(id);
        if (castCrewOptional.isEmpty()) {
            return "redirect:/admin";
        }
        modelMap.addAttribute("castcrew", castCrewOptional.get());
        return "";
    }

    @PostMapping("/edit")
    public String editCastCrew(@ModelAttribute CastCrew castCrew) {
        adminService.save(castCrew);
        return "redirect:/admin";
    }

    @GetMapping("/remove/{id}")
    public String deleteCastCrew(@PathVariable("id") int id) {
        adminService.delete(id);
        return "redirect:/admin";
    }

}

