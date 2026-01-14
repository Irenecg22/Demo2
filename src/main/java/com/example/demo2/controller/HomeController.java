package com.example.demo2.controller;

import com.example.demo2.service.EstudiosService;
import com.example.demo2.service.ExperienciaService;
import com.example.demo2.service.InfoService;
import com.example.demo2.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired private InfoService infoService;
    @Autowired private ExperienciaService experienciaService;
    @Autowired private EstudiosService estudiosService;
    @Autowired private ProyectoService proyectoService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("info", infoService.getAllInfo());
        model.addAttribute("experiencias", experienciaService.getAllExperiencias());
        model.addAttribute("estudios", estudiosService.getAllEstudios());
        model.addAttribute("proyectos", proyectoService.getAllProyecto());
        return "index";
    }
}