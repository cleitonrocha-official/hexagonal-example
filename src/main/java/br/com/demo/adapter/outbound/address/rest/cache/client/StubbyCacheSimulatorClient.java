package br.com.demo.adapter.outbound.address.rest.cache.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.demo.adapter.outbound.address.rest.cache.json.StubbyCacheSimulatorDataResponseJson;

@FeignClient(value = "StubbyCacheSimulatorClient", url = "${stubby.url}")
public interface StubbyCacheSimulatorClient {

	@GetMapping(path = "address")
	public ResponseEntity<List<StubbyCacheSimulatorDataResponseJson>> allAddress(); 
	

	
}
