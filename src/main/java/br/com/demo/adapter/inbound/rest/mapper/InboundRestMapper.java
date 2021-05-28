package br.com.demo.adapter.inbound.rest.mapper;

import org.mapstruct.Mapper;

import br.com.demo.adapter.inbound.rest.request.json.CreateAddressRequestJson;
import br.com.demo.adapter.inbound.rest.request.json.PatchAddressRequestJson;
import br.com.demo.adapter.inbound.rest.request.json.UpdateAddressRequestJson;
import br.com.demo.adapter.inbound.rest.response.json.GetAddressResponseJson;
import br.com.demo.core.dto.AddressCoreDTO;

@Mapper(componentModel = "spring")
public interface InboundRestMapper {

	AddressCoreDTO from(CreateAddressRequestJson adapterDTO);
	AddressCoreDTO from(UpdateAddressRequestJson adapterDTO);
	AddressCoreDTO from(PatchAddressRequestJson adapterDTO);
	GetAddressResponseJson from(AddressCoreDTO coreDTO);
}
