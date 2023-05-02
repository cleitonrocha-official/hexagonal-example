package br.com.demo.adapter.outbound.address.nosql.mongo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.address.nosql.mongo.mapper.MongoAddressOutboundMapper;
import br.com.demo.adapter.outbound.address.nosql.mongo.repository.AddressModelMongoRepository;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.port.outbound.AddressReadByIdPortOutbound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MongoAddressReadByIdOutboundService implements AddressReadByIdPortOutbound {

	private AddressModelMongoRepository repository;

	private MongoAddressOutboundMapper mapper;

	@Override
	public Optional<AddressCoreDTO> execute(String addressId) {
	log.info("Trying read address with id {} ",addressId);
		
		var optAddressFound = repository.findById(addressId);
	
		log.info("result {} ", optAddressFound.isPresent());
		var mapperedAddressFound = optAddressFound.map(mapper::from);
		
		log.info("success in read address with id {} ", addressId);
		
		return mapperedAddressFound;
	}

}
