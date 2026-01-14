package com.example.demo2.service;

import com.example.demo2.model.Experiencia;
import com.example.demo2.model.Lenguaje;
import com.example.demo2.repository.ExperienciaRepository;
import com.example.demo2.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {

    @Autowired
    private LenguajeRepository lenguajeRepository;

    public List<Lenguaje> getAllLenguaje() {
        return lenguajeRepository.findAll();
    }

    public Lenguaje getLenguajeById(Long id) {
        return lenguajeRepository.findById(id).orElse(null);
    }

    public Lenguaje addLenguaje(Lenguaje lenguaje) {
        return lenguajeRepository.save(lenguaje);
    }

    public Lenguaje updateLenguaje(Long id, Lenguaje lenguaje) {
        lenguaje.setId(id);
        return lenguajeRepository.save(lenguaje);
    }

    public void deleteExperiencia(Long id) {
        lenguajeRepository.deleteById(id);
    }
}
