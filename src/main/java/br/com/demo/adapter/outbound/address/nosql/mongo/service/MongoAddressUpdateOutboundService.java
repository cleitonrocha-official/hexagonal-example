package br.com.demo.adapter.outbound.address.nosql.mongo.service;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.address.nosql.mongo.mapper.MongoAddressOutboundMapper;
import br.com.demo.adapter.outbound.address.nosql.mongo.repository.AddressModelMongoRepository;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.port.outbound.AddressUpdatePortOutbound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MongoAddressUpdateOutboundService implements AddressUpdatePortOutbound{

	private AddressModelMongoRepository repository;

	private MongoAddressOutboundMapper mapper;
	
	@Override
	public void execute(AddressCoreDTO addressCoreDTO) {
	
		log.info("Trying update address with id {}", addressCoreDTO.getId());
		
		var addressModelToSave = mapper.from(addressCoreDTO);
		
		repository.save(addressModelToSave);
		
		log.info("new address updated with sucess");
		
	}

}
