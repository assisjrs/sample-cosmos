package com.assisjrs.sample.cosmos.service;

import com.assisjrs.sample.cosmos.Entity.Livro;
import com.assisjrs.sample.cosmos.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListarTodosServiceTests {
    @InjectMocks
    private LivroService service;

    @Mock
    private LivroRepository repository;

    @Test
    void naoDeveRetonarNuloAoListarLivros() {
        final List<?> livros = service.listarTodos();

        assertThat(livros).isNotNull();
    }

    @Test
    void deveUsarRepositorioParaListarLivros() {
        service.listarTodos();

        verify(repository, atLeastOnce()).findAll();
    }

    @Test
    void deveManterOrdemDeEntradaDeLivros() {
        final List<Livro> livros = new ArrayList<>();

        final Livro livro1 = new Livro("1", "Senhor Dos aneis : A Sociedade do Anel");
        livros.add(livro1);

        final Livro livro2 = new Livro("2", "Senhor Dos aneis : As Duas Torres");
        livros.add(livro2);

        when(repository.findAll()).thenReturn(livros);

        final List<Livro> livrosComparacao = new ArrayList<>();
        livrosComparacao.add(livro1);
        livrosComparacao.add(livro2);

        final List<Livro> listarTodos = service.listarTodos();

        assertThat(listarTodos).asList()
                               .containsAll(livrosComparacao);
    }

}
