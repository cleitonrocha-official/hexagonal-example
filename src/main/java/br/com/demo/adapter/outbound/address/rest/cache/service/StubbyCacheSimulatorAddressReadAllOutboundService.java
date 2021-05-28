package br.com.demo.adapter.outbound.address.rest.cache.service;

import static java.util.stream.Collectors.toList;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.demo.adapter.outbound.address.rest.cache.client.StubbyCacheSimulatorClient;
import br.com.demo.adapter.outbound.address.rest.cache.mapper.StubbyCacheSimulatorAddressOutboundMapper;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.port.outbound.AddressReadAllPortOutbound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Profile("cache")
@Slf4j
public class StubbyCacheSimulatorAddressReadAllOutboundService implements AddressReadAllPortOutbound {

	private StubbyCacheSimulatorClient client;

	private StubbyCacheSimulatorAddressOutboundMapper mapper;

	@Override
	public Page<AddressCoreDTO> execute(Pageable pageable) {
	
		log.info("Trying read address by pageable options -- STUBBY CACHEABLE SIMULATOR");
		
	
		var allAddressFound = client.allAddress();
	
		if (allAddressFound.getStatusCode().is2xxSuccessful()) {
			var bodyReponse = allAddressFound.getBody();
			
			log.info("Proccess find zip code data by address with -- STUBBY CACHEABLE SIMULATOR");
			
			return new PageImpl<>(bodyReponse.stream()
					.map(mapper::from)
					.collect(toList()));
			
			
		}
		
		
		log.info("sucess in read address by pageable options");
		
		return Page.empty();
	}

}
