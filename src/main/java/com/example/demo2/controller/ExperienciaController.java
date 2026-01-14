package com.example.demo2.controller;
import com.example.demo2.model.Experiencia;
import com.example.demo2.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping
    public String listExperiencias(Model model) {
        model.addAttribute("experiencias", experienciaService.getAllExperiencias());
        return "admin/experiencia-form";
    }

    @PostMapping
    public String addExperiencia(Experiencia experiencia) {
        experienciaService.addExperiencia(experiencia);
        return "redirect:/admin/experiencia";
    }

    @GetMapping("/edit/{id}")
    public String editExperiencia(@PathVariable Long id, Model model) {
        model.addAttribute("experiencia",
                experienciaService.getExperienciaById(id));
        return "admin/experiencia-form";
    }

    @PostMapping("/update/{id}")
    public String updateExperiencia(
            @PathVariable Long id,
            Experiencia experiencia) {

        experienciaService.updateExperiencia(id, experiencia);
        return "redirect:/admin/experiencia";
    }

    @GetMapping("/delete/{id}")
    public String deleteExperiencia(@PathVariable Long id) {
        experienciaService.deleteExperiencia(id);
        return "redirect:/admin/experiencia";
    }
}
