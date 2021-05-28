package br.com.demo.adapter.outbound.address.nosql.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.demo.adapter.outbound.address.nosql.mongo.model.AddressModel;

public interface AddressModelMongoRepository extends MongoRepository<AddressModel, String>{

}
