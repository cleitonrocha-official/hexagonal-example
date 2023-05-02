package br.com.demo.adapter.outbound.address.nosql.mongo.service;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.address.nosql.mongo.mapper.MongoAddressOutboundMapper;
import br.com.demo.adapter.outbound.address.nosql.mongo.repository.AddressModelMongoRepository;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.port.outbound.AddressCreatePortOutbound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MongoAddressCreateOutboundService implements AddressCreatePortOutbound{

	private AddressModelMongoRepository repository;
	
	private MongoAddressOutboundMapper mapper;

	@Override
	public String execute(AddressCoreDTO addressCoreDTO) {
		
		log.info("Trying save new address");
		
		var addressModelToSave = mapper.from(addressCoreDTO);
		
		var savedAddressModel = repository.save(addressModelToSave);
		
		log.info("new address saved with success");
		
		return savedAddressModel.getId();
	}
	
	
}
