package br.com.demo.adapter.outbound.zipcode.rest.viacep.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.demo.adapter.outbound.zipcode.rest.viacep.json.ViaCepDataResponseJson;

@FeignClient(value = "ViaCepClient", url = "${via-cep.url}")
public interface ViaCepClient {

	@GetMapping(path = "{zipCode}/json")
	public ResponseEntity<ViaCepDataResponseJson> findZipCodeDataById(@PathVariable("zipCode") String zipCode ); 
	
	@GetMapping(path = "{uf}/{locality}/{streetName}json")
	public ResponseEntity<ViaCepDataResponseJson> findZipCodeDataByAddress(@PathVariable("uf") String uf,
			@PathVariable("locality") String locality,
			@PathVariable("streetName") String streetName
			
			); 
	
}
