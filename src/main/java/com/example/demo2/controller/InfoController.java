package com.example.demo2.controller;


import com.example.demo2.model.Estudios;
import com.example.demo2.model.Experiencia;
import com.example.demo2.model.Info;
import com.example.demo2.model.Lenguaje;
import com.example.demo2.service.EstudiosService;
import com.example.demo2.service.ExperienciaService;
import com.example.demo2.service.InfoService;
import com.example.demo2.service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping
    public String listInfo(Model model) {
        model.addAttribute("info", infoService.getAllInfo());
        return "admin/info-form";
    }

    @PostMapping
    public String addInfo(Info info) {
        infoService.addInfo(info);
        return "redirect:/admin/info";
    }

    @GetMapping("/edit/{id}")
    public String editInfo(@PathVariable Long id, Model model) {
        model.addAttribute("info",
                infoService.getInfoById(id));
        return "admin/info-form";
    }

    @PostMapping("/update/{id}")
    public String updateInfo(
            @PathVariable Long id,
            Info info) {

        infoService.updateInfo(id, info);
        return "redirect:/admin/info";
    }

    @GetMapping("/delete/{id}")
    public String deleteInfo(@PathVariable Long id) {
        infoService.deleteInfo(id);
        return "redirect:/admin/info";
    }
}

