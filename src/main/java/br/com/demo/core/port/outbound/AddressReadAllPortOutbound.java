package br.com.demo.core.port.outbound;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.demo.core.dto.AddressCoreDTO;

public interface AddressReadAllPortOutbound {

	public Page<AddressCoreDTO> execute(Pageable pageable);
	
}
