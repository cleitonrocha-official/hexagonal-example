package br.com.demo.core.port.outbound;

import br.com.demo.core.dto.AddressCoreDTO;

public interface AddressCreatePortOutbound {

	public String execute(AddressCoreDTO addressCoreDTO);
	
}
