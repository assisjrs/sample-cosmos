package com.assisjrs.sample.cosmos.config;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ModelMapperIntegrationTests {
    @Autowired
    private ModelMapper mapper;

    @Test
    void deve_iniciar_o_model_mapper_no_contexto_do_spring() {
        assertThat(mapper).isNotNull();
    }
}
