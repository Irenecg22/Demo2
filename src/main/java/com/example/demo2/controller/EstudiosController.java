package com.example.demo2.controller;


import com.example.demo2.model.Estudios;
import com.example.demo2.model.Experiencia;
import com.example.demo2.service.EstudiosService;
import com.example.demo2.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/estudios")
public class EstudiosController {

    @Autowired
    private EstudiosService estudiosService;

    @GetMapping
    public String listExperiencias(Model model) {
        model.addAttribute("estudios", estudiosService.getAllEstudios());
        return "admin/estudios-form";
    }

    @PostMapping
    public String addEstudios(Estudios estudios) {
        estudiosService.addEstudios(estudios);
        return "redirect:/admin/estudios";
    }

    @GetMapping("/edit/{id}")
    public String editEstudios(@PathVariable Long id, Model model) {
        model.addAttribute("estudios",
                estudiosService.getEstudiosById(id));
        return "admin/estudios-form";
    }

    @PostMapping("/update/{id}")
    public String updateEstudios(
            @PathVariable Long id,
            Estudios estudios) {

        estudiosService.updateEstudios(id, estudios);
        return "redirect:/admin/estudios";
    }

    @GetMapping("/delete/{id}")
    public String deleteEstudios(@PathVariable Long id) {
        estudiosService.deleteEstudios(id);
        return "redirect:/admin/estudios";
    }
}

