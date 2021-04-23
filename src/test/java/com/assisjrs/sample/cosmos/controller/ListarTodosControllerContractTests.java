package com.assisjrs.sample.cosmos.controller;

import com.assisjrs.sample.cosmos.Entity.Livro;
import com.assisjrs.sample.cosmos.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = DEFINED_PORT)
class ListarTodosControllerContractTests {
	@Autowired
	private WebTestClient webTestClient;

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
	void retornaStatus200() {
		webTestClient.get().uri("/livros").exchange().expectStatus().isOk();
	}

	@Test
	void retornaId() {
		webTestClient.get().uri("/livros").exchange().expectBody().jsonPath("$.[0].id").exists();
	}

	@Test
	void retornaTitulo() {
		webTestClient.get().uri("/livros").exchange().expectBody().jsonPath("$.[0].titulo").exists();
	}
}
