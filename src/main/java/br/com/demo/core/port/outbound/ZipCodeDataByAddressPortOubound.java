package br.com.demo.core.port.outbound;

import java.util.Optional;

import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;

public interface ZipCodeDataByAddressPortOubound {

	Optional<ZipCodeDataCoreDTO> execute(AddressCoreDTO address);
	
}
