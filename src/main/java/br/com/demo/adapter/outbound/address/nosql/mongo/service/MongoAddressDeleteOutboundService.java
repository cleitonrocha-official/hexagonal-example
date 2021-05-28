package br.com.demo.adapter.outbound.address.nosql.mongo.service;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.address.nosql.mongo.repository.AddressModelMongoRepository;
import br.com.demo.core.port.outbound.AddressDeletePortOubound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MongoAddressDeleteOutboundService implements AddressDeletePortOubound{

	private AddressModelMongoRepository repository;
	
	@Override
	public void execute(String addressId) {
		
		log.info("Trying delete address with id {}", addressId);
		
		repository.deleteById(addressId);
		
		log.info("deleted address with id {}", addressId);
		
	}

}
