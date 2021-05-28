package br.com.demo.adapter.outbound.zipcode.rest.stubby.mapper;

import static org.apache.commons.lang3.StringUtils.split;

import org.springframework.stereotype.Component;

import br.com.demo.core.dto.ZipCodeDataCoreDTO;

@Component
public class StubbyOutboundRestZipCodeMapper {

	private static final String SPLIT_SEPARATOR = ";";
	
	private static final int CEP = 0;
	private static final int STREET_NAME = 1;
	private static final int COMPLEMENT = 2;
	private static final int NEIGHBORHOOD = 3;
	private static final int CITY = 4;
	private static final int UF = 5;
	
	public ZipCodeDataCoreDTO from(String message) {
		
		var splitedMessage = split(message, SPLIT_SEPARATOR);
		
		return ZipCodeDataCoreDTO.builder()
				.id(splitedMessage[CEP])
				.streetName(splitedMessage[STREET_NAME])
				.complement(splitedMessage[COMPLEMENT].isBlank()?null:splitedMessage[COMPLEMENT])
				.neighborhood(splitedMessage[NEIGHBORHOOD])
				.locality(splitedMessage[CITY])
				.uf(splitedMessage[UF])
				.build();
	}
	
}
