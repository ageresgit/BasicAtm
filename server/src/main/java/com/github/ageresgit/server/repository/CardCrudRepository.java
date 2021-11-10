package com.github.ageresgit.server.repository;

import com.github.ageresgit.server.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardCrudRepository extends CrudRepository<CardEntity, String> {
}
