package br.com.demo.adapter.outbound.address.nosql.mongo.mapper;

import org.mapstruct.Mapper;

import br.com.demo.adapter.outbound.address.nosql.mongo.model.AddressModel;
import br.com.demo.core.dto.AddressCoreDTO;

@Mapper(componentModel = "spring")
public interface MongoAddressOutboundMapper {

	AddressModel from(AddressCoreDTO coreDTO);
	AddressCoreDTO from(AddressModel adapterDTO);
}
