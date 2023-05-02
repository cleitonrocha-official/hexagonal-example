package br.com.demo.core.port.inbound;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.errors.exceptions.AddressException;

public interface AddressCrudDomainPortInbound {

	public String create(AddressCoreDTO addressCoreDTO);
	public Optional<AddressCoreDTO> read(String id);
	public Page<AddressCoreDTO> read(Pageable pageable);
	public void update(AddressCoreDTO addressCoreDTO) throws AddressException;
	public void patch(AddressCoreDTO addressCoreDTO) throws AddressException;
	public void delete(String id) throws AddressException;
	
}
