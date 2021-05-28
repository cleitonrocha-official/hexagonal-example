package br.com.demo.adapter.outbound.zipcode.rest.stubby.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "StubbyCepClient", url = "${stubby.url}")
public interface StubbyCepClient {

	@GetMapping(path = "cep/{zipCode}")
	public ResponseEntity<String> findZipCodeDataById(@PathVariable("zipCode") String zipCode ); 
	
	@GetMapping(path = "/cep/rua/{streetName}/cidade/{city}/uf/{uf}")
	public ResponseEntity<String> findZipCodeDataByAddress(
			@PathVariable("streetName") String streetName,
			@PathVariable("uf") String uf,
			@PathVariable("city") String locality); 
	
}
