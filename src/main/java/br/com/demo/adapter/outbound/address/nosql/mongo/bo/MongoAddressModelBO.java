package br.com.demo.adapter.outbound.address.nosql.mongo.bo;

import static java.util.Optional.ofNullable;

import br.com.demo.core.dto.AddressCoreDTO;

public class MongoAddressModelBO {

	private static final MongoAddressModelBO INSTANCE = new MongoAddressModelBO();
	
	private MongoAddressModelBO() {
		
	}
	
	public static MongoAddressModelBO getInstance() {
		return INSTANCE;
	}

	public void patch(AddressCoreDTO addressFoundToPatch, AddressCoreDTO patchAddressCoreDTO) {
		
		ofNullable(patchAddressCoreDTO.getCity()).ifPresent(addressFoundToPatch::setCity);
		ofNullable(patchAddressCoreDTO.getComplement()).ifPresent(addressFoundToPatch::setComplement);
		ofNullable(patchAddressCoreDTO.getNumber()).ifPresent(addressFoundToPatch::setNumber);
		ofNullable(patchAddressCoreDTO.getState()).ifPresent(addressFoundToPatch::setState);
		ofNullable(patchAddressCoreDTO.getStreetName()).ifPresent(addressFoundToPatch::setStreetName);
		ofNullable(patchAddressCoreDTO.getZipcode()).ifPresent(addressFoundToPatch::setZipcode);
		
	}
	
}
