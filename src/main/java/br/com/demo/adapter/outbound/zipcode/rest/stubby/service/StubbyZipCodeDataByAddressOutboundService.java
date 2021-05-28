package br.com.demo.adapter.outbound.zipcode.rest.stubby.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.zipcode.rest.stubby.client.StubbyCepClient;
import br.com.demo.adapter.outbound.zipcode.rest.stubby.mapper.StubbyOutboundRestZipCodeMapper;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;
import br.com.demo.core.port.outbound.ZipCodeDataByAddressPortOubound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class StubbyZipCodeDataByAddressOutboundService implements ZipCodeDataByAddressPortOubound {

	private StubbyCepClient client;

	private StubbyOutboundRestZipCodeMapper mapper;



	@Override
	public Optional<ZipCodeDataCoreDTO> execute(AddressCoreDTO addressCoreDTO) {

		log.info("Tryng proccess find zip code data by address with STUBBY...");
		try {

		var responseFindGeolocate = client
				.findZipCodeDataByAddress(addressCoreDTO.getStreetName(), 
						addressCoreDTO.getCity(), addressCoreDTO.getState());

		if (responseFindGeolocate.getStatusCode().is2xxSuccessful()) {
			var bodyReponse = responseFindGeolocate.getBody();
			
			log.info("Proccess find zip code data by address with STUBBY successefull");
			return Optional
					.of(mapper.from(bodyReponse));
		}

		log.warn("Warning in proccess find zip code data by address with STUBBY , http status is {}", responseFindGeolocate.getStatusCodeValue());
		return Optional.empty();
		}catch (Exception e) {
			log.error("Proccess find zip code data by address with STUBBY failed: {}", e.getMessage());
			return Optional.empty();
		}
	}


}
