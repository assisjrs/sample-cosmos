package com.assisjrs.sample.cosmos.controller;

import com.assisjrs.sample.cosmos.Entity.Livro;
import com.assisjrs.sample.cosmos.service.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<LivroResponse>> listarTodos() {
        final List<Livro> livros = livroService.listarTodos();

        final List<LivroResponse> livrosResponse = new ArrayList<>();

        livros.forEach(livro -> livrosResponse.add(mapper.map(livro, LivroResponse.class)));

        return ResponseEntity.ok(livrosResponse);
    }
}
