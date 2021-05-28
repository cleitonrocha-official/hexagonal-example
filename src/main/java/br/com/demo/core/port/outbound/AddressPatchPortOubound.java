package br.com.demo.core.port.outbound;

import br.com.demo.core.dto.AddressCoreDTO;

public interface AddressPatchPortOubound {

	public void execute(AddressCoreDTO addressFoundToPatch,AddressCoreDTO patchAddressCoreDTO);
	
}
