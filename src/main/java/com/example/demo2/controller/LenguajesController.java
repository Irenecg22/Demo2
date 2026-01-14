package com.example.demo2.controller;


import com.example.demo2.model.Estudios;
import com.example.demo2.model.Experiencia;
import com.example.demo2.model.Lenguaje;
import com.example.demo2.service.EstudiosService;
import com.example.demo2.service.ExperienciaService;
import com.example.demo2.service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/lenguajes")
public class LenguajesController {

    @Autowired
    private LenguajeService lenguajeService;

    @GetMapping
    public String listExperiencias(Model model) {
        model.addAttribute("estudios", lenguajeService.getAllLenguaje());
        return "admin/lenguaje-form";
    }

    @PostMapping
    public String addLenguaje(Lenguaje lenguaje) {
        lenguajeService.addLenguaje(lenguaje);
        return "redirect:/admin/lenguaje";
    }

    @GetMapping("/edit/{id}")
    public String editLenguaje(@PathVariable Long id, Model model) {
        model.addAttribute("lenguaje",
                lenguajeService.getLenguajeById(id));
        return "admin/lenguaje-form";
    }

    @PostMapping("/update/{id}")
    public String updateLenguaje(
            @PathVariable Long id,
            Lenguaje lenguaje) {

        lenguajeService.updateLenguaje(id, lenguaje);
        return "redirect:/admin/lenguaje";
    }

    @GetMapping("/delete/{id}")
    public String deleteLenguaje(@PathVariable Long id) {
        lenguajeService.deleteLenguaje(id);
        return "redirect:/admin/lenguaje";
    }
}

