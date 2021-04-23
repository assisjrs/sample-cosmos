package com.assisjrs.sample.cosmos.repository;

import com.assisjrs.sample.cosmos.Entity.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {
}
