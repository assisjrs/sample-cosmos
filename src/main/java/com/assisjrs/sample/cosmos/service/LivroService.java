package com.assisjrs.sample.cosmos.service;

import com.assisjrs.sample.cosmos.Entity.Livro;
import com.assisjrs.sample.cosmos.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }
}
