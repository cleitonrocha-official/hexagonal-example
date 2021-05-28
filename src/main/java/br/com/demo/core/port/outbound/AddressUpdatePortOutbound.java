package br.com.demo.core.port.outbound;

import br.com.demo.core.dto.AddressCoreDTO;

public interface AddressUpdatePortOutbound {

	public void execute(AddressCoreDTO addressCoreDTO);
	
}
