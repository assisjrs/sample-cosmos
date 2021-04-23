package com.assisjrs.sample.cosmos.controller;

import com.assisjrs.sample.cosmos.Entity.Livro;
import com.assisjrs.sample.cosmos.service.LivroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListarTodosControllerTests {
    @InjectMocks
    private LivroController controller;

    @Mock
    private LivroService service;

    @Mock
    private ModelMapper mapper;

    @Test
    void deveUsarServiceParaListarLivros(){
        controller.listarTodos();

        verify(service, atLeastOnce()).listarTodos();
    }

    @Test
    void deveManterOrdemDeEntradaDeLivros() {
        final List<Livro> livros = new ArrayList<>();

        final Livro livro1 = new Livro("1", "Senhor Dos aneis : A Sociedade do Anel");
        livros.add(livro1);

        final Livro livro2 = new Livro("2", "Senhor Dos aneis : As Duas Torres");
        livros.add(livro2);

        when(service.listarTodos()).thenReturn(livros);

        when(mapper.map(livro1, LivroResponse.class)).thenReturn(new LivroResponse(livro1.getId(), livro1.getTitulo()));
        when(mapper.map(livro2, LivroResponse.class)).thenReturn(new LivroResponse(livro2.getId(), livro2.getTitulo()));

        final List<LivroResponse> livrosComparacao = new ArrayList<>();

        livrosComparacao.add(new LivroResponse(livro1.getId(), livro1.getTitulo()));
        livrosComparacao.add(new LivroResponse(livro2.getId(), livro2.getTitulo()));

        final ResponseEntity<List<LivroResponse>> livrosResponse = controller.listarTodos();

        assertThat(livrosResponse.getBody()).asList().containsAll(livrosComparacao);
    }

}
