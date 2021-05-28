package br.com.demo.adapter.outbound.address.nosql.mongo.service;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.address.nosql.mongo.bo.MongoAddressModelBO;
import br.com.demo.adapter.outbound.address.nosql.mongo.mapper.MongoAddressOutboundMapper;
import br.com.demo.adapter.outbound.address.nosql.mongo.repository.AddressModelMongoRepository;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.port.outbound.AddressPatchPortOubound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MongoAddressPatchOutboundService implements AddressPatchPortOubound {

	private AddressModelMongoRepository repository;
	
	private MongoAddressOutboundMapper mapper;

	private final MongoAddressModelBO bo = MongoAddressModelBO.getInstance();

	@Override
	public void execute(AddressCoreDTO addressFoundToPatch, AddressCoreDTO patchAddressCoreDTO) {

		log.info("Trying update patch address with id {}", patchAddressCoreDTO.getId());

		bo.patch(addressFoundToPatch, patchAddressCoreDTO);

		repository.save(mapper.from(addressFoundToPatch));

		log.info("address updated patch with sucess ");

	}

}
