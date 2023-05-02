package br.com.demo.adapter.outbound.address.nosql.mongo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.address.nosql.mongo.mapper.MongoAddressOutboundMapper;
import br.com.demo.adapter.outbound.address.nosql.mongo.repository.AddressModelMongoRepository;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.port.outbound.AddressReadAllPortOutbound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Profile("!cache")
@AllArgsConstructor
@Slf4j
public class MongoAddressReadAllOutboundService implements AddressReadAllPortOutbound {

	private AddressModelMongoRepository repository;

	private MongoAddressOutboundMapper mapper;

	@Override
	public Page<AddressCoreDTO> execute(Pageable pageable) {
	
		log.info("Trying read address by pageable options");
		
		var allAddressFound = repository.findAll(pageable);
	
		var mapperedAllAddressFound = allAddressFound.map(mapper::from);
		
		log.info("success in read address by pageable options");
		
		return mapperedAllAddressFound;
	}

}
