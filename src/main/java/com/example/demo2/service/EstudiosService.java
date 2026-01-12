package com.example.demo2.service;

import com.example.demo2.model.Estudios;
import com.example.demo2.model.Experiencia;
import com.example.demo2.repository.EstudioRepository;
import com.example.demo2.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiosService {

    @Autowired
    private EstudioRepository estudiosRepository;

    public List<Estudios> getAllExperiencias() {
        return estudiosRepository.findAll();
    }

    public Estudios getEstudiosById(Long id) {
        return estudiosRepository.findById(id).orElse(null);
    }

    public Estudios addEstudios(Estudios estudios) {
        return estudiosRepository.save(estudios);
    }

    public Estudios updateEstudios(Long id, Estudios estudios) {
        estudios.setId(id);
        return estudiosRepository.save(estudios);
    }

    public void deleteEstudios(Long id) {
        estudiosRepository.deleteById(id);
    }
}
