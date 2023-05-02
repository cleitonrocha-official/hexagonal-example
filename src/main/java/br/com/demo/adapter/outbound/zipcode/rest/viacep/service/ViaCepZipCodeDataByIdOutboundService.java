package br.com.demo.adapter.outbound.zipcode.rest.viacep.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.zipcode.rest.viacep.client.ViaCepClient;
import br.com.demo.adapter.outbound.zipcode.rest.viacep.mapper.ViaCepOuboundRestZipCodeMapper;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;
import br.com.demo.core.port.outbound.ZipCodeDataByIdPortOubound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ViaCepZipCodeDataByIdOutboundService implements ZipCodeDataByIdPortOubound {

	private ViaCepClient client;

	private ViaCepOuboundRestZipCodeMapper mapper;


	@Override
	public Optional<ZipCodeDataCoreDTO> execute(String zipCode) {

		log.info("Tryng process find zip code data by ID with VIA-CEP...");
		try {

		var responseFindGeolocate = client
				.findZipCodeDataById(zipCode);

		if (responseFindGeolocate.getStatusCode().is2xxSuccessful()) {
			var bodyReponse = responseFindGeolocate.getBody();
			
			log.info("Process find zip code data by ID with VIA-CEP successefull");
			return Optional
					.of(mapper.from(bodyReponse));
		}

		log.warn("Warning in process find zip code data by ID with VIA-CEP , http status is {}", responseFindGeolocate.getStatusCodeValue());
		return Optional.empty();
		}catch (Exception e) {
			log.error("Process find zip code data by ID with VIA-CEP failed: {}", e.getMessage());
			return Optional.empty();
		}
	}


}
