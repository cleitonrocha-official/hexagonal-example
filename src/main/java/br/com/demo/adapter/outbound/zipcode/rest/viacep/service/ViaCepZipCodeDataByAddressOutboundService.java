package br.com.demo.adapter.outbound.zipcode.rest.viacep.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.zipcode.rest.viacep.client.ViaCepClient;
import br.com.demo.adapter.outbound.zipcode.rest.viacep.mapper.ViaCepOuboundRestZipCodeMapper;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;
import br.com.demo.core.port.outbound.ZipCodeDataByAddressPortOubound;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
@NoArgsConstructor
public class ViaCepZipCodeDataByAddressOutboundService implements ZipCodeDataByAddressPortOubound {

	private ViaCepClient client;

	private ViaCepOuboundRestZipCodeMapper mapper;


	@Override
	public Optional<ZipCodeDataCoreDTO> execute(AddressCoreDTO addressCoreDTO) {

		log.info("Tryng proccess find zip code data by address with VIA-CEP...");
		try {

		var responseFindGeolocate = client
				.findZipCodeDataByAddress(addressCoreDTO.getState(), addressCoreDTO.getCity(), addressCoreDTO.getStreetName());

		if (responseFindGeolocate.getStatusCode().is2xxSuccessful()) {
			var bodyReponse = responseFindGeolocate.getBody();
			
			log.info("Proccess find zip code data by address with VIA-CEP successefull");
			return Optional
					.of(mapper.from(bodyReponse));
		}

		log.warn("Warning in proccess find zip code data by address with VIA-CEP , http status is {}", responseFindGeolocate.getStatusCodeValue());
		return Optional.empty();
		}catch (Exception e) {
			log.error("Proccess find zip code data by address with VIA-CEP failed: {}", e.getMessage());
			return Optional.empty();
		}
	}


}
