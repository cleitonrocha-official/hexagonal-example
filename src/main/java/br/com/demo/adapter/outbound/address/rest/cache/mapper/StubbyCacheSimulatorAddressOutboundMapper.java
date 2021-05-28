package br.com.demo.adapter.outbound.address.rest.cache.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.demo.adapter.outbound.address.rest.cache.json.StubbyCacheSimulatorDataResponseJson;
import br.com.demo.core.dto.AddressCoreDTO;

@Mapper(componentModel = "spring")
public interface StubbyCacheSimulatorAddressOutboundMapper {

	@Mapping(target = "streetName", source = "street")
	@Mapping(target = "complement", source = "add")
	@Mapping(target = "city", source = "local")
	@Mapping(target = "state", source = "uf")
	@Mapping(target = "zipcode", source = "cep")
	AddressCoreDTO from(StubbyCacheSimulatorDataResponseJson stubbyCacheSimulatorResponseJson);
}
