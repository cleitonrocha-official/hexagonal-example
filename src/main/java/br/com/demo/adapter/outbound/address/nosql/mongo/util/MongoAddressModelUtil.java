package br.com.demo.adapter.outbound.address.nosql.mongo.util;

import static java.util.Optional.ofNullable;

import br.com.demo.core.dto.AddressCoreDTO;

public class MongoAddressModelUtil {

	private static final MongoAddressModelUtil INSTANCE = new MongoAddressModelUtil();
	
	private MongoAddressModelUtil() {
		
	}
	
	public static MongoAddressModelUtil getInstance() {
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
