package br.com.demo.adapter.outbound.zipcode.rest.viacep.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.demo.adapter.outbound.zipcode.rest.viacep.json.ViaCepDataResponseJson;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;

@Mapper(componentModel = "spring")
public interface ViaCepOuboundRestZipCodeMapper {

	@Mapping(target = "id", source = "zipCode")
	ZipCodeDataCoreDTO from(ViaCepDataResponseJson from);

	@Mapping(target = "zipCode", source = "id")
	ViaCepDataResponseJson from(ZipCodeDataCoreDTO from);
}
