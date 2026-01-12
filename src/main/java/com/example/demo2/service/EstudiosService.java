package com.example.demo2.service;

import com.example.demo2.model.Estudios;
import com.example.demo2.model.Info;
import com.example.demo2.repository.EstudioRepository;
import com.example.demo2.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiosService {
    @Autowired
    private EstudioRepository estudioRepository;

    public List<Estudios> getAllEstudios() {
        return estudioRepository.findAll();
    }

    public Estudios getEstudiosById(Long id) {
        return estudioRepository.findById(id).orElse(null);
    }

    public Estudios createEstudios(Estudios estudios) {
        return estudioRepository.save(estudios);

    }
    public Estudios addEstudios(Estudios estudios) {
        return estudioRepository.save(estudios);
    }
    public Estudios updateEstudios(Long id, Estudios estudios) {
        estudios.setId(id);
        return estudioRepository.save(estudios);
    }

    public void deleteInfo(Long id) {
        estudioRepository.deleteById(id);
    }

}
