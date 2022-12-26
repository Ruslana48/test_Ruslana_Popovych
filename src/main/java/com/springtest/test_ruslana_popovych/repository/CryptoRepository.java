package com.springtest.test_ruslana_popovych.repository;

import com.springtest.test_ruslana_popovych.model.CryptoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptoRepository extends MongoRepository<CryptoModel,String> {
    List<CryptoModel>findAll();

}
