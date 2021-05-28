package br.com.demo.core.port.outbound;


import java.util.Optional;

import br.com.demo.core.dto.AddressCoreDTO;

public interface AddressReadByIdPortOutbound {

	Optional<AddressCoreDTO> execute(String addressId);
	
}
