package com.example.demo2.controller;

import com.example.demo2.model.Lenguaje;
import com.example.demo2.model.Proyecto;
import com.example.demo2.service.LenguajeService;
import com.example.demo2.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public String listProyecto(Model model) {
        model.addAttribute("proyecto", proyectoService.getAllProyecto());
        return "admin/proyecto-form";
    }

    @PostMapping
    public String addProyecto(Proyecto proyecto) {
        proyectoService.addProyecto(proyecto);
        return "redirect:/admin/proyecto";
    }

    @GetMapping("/edit/{id}")
    public String editProyecto(@PathVariable Long id, Model model) {
        model.addAttribute("proyecto",
                proyectoService.getProyectoById(id));
        return "admin/proyecto-form";
    }

    @PostMapping("/update/{id}")
    public String updateProyecto(
            @PathVariable Long id,
            Proyecto proyecto) {

        proyectoService.updateProyecto(id, proyecto);
        return "redirect:/admin/proyecto";
    }

    @GetMapping("/delete/{id}")
    public String deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
        return "redirect:/admin/proyecto";
    }
}

