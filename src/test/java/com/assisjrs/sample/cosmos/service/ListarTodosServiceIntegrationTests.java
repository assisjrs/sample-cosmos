package com.assisjrs.sample.cosmos.service;

import com.assisjrs.sample.cosmos.Entity.Livro;
import com.assisjrs.sample.cosmos.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ListarTodosServiceIntegrationTests {
    @Autowired
    private LivroService service;

    @Autowired
    private LivroRepository repository;

    @BeforeEach
    void antesDeCadaTeste() {
        final Livro livro1 = new Livro("1", "Senhor Dos aneis : A Sociedade do Anel");
        repository.save(livro1);

        final Livro livro2 = new Livro("2", "Senhor Dos aneis : As Duas Torres");
        repository.save(livro2);
    }

    @Test
    void deveRetornarListaDeLivrosDoBanco() {
        final List<Livro> livros = service.listarTodos();

        assertThat(livros).isNotEmpty();
    }

    @Test
    void deveConterSegundoLivroDaLista() {
        final List<Livro> livros = service.listarTodos();

        assertThat(livros.get(1)).isEqualTo(new Livro("2", "Senhor Dos aneis : As Duas Torres"));
    }
}
