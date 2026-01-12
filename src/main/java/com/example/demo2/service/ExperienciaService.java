package com.example.demo2.service;

import com.example.demo2.model.Experiencia;
import com.example.demo2.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> getAllExperiencias() {
        return experienciaRepository.findAll();
    }

    public Experiencia getExperienciaById(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    public Experiencia addExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public Experiencia updateExperiencia(Long id, Experiencia experiencia) {
        experiencia.setId(id);
        return experienciaRepository.save(experiencia);
    }

    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }
}
