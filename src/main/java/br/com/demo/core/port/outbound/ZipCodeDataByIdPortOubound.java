package br.com.demo.core.port.outbound;

import java.util.Optional;

import br.com.demo.core.dto.ZipCodeDataCoreDTO;

public interface ZipCodeDataByIdPortOubound {

	Optional<ZipCodeDataCoreDTO> execute(String zipCode);
	
}
