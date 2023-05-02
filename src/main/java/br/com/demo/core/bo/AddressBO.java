package br.com.demo.core.bo;

import java.util.Optional;

import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;
import br.com.demo.core.errors.exceptions.AddressException;

/*
 * Basicamente um BO é um objeto que implementa a lógica de negócios
 *  e/ou dados de negócio, pensa numa classe Pedido, ela é um BO, 
 *  ele pode ter tais métodos : 
 *  calcularPedido, fecharPedido, abrirPedido (esses métodos implementam a lógica de negócios)
 */
public class AddressBO {

	private static final AddressBO INSTANCE = new AddressBO();

	private AddressBO() {

	}

	public static AddressBO getInstance() {
		return INSTANCE;
	}
	
	/*
	 * Regra isolada do BO para validar se oobjeto Address não possui complemento
	 */
	private boolean notContainsComplement(AddressCoreDTO addressCoreDTO) {
		return addressCoreDTO.getComplement() == null;
	}


	/*
	 * Valida se o objeto Address possui CEP
	 */
	public boolean containZipCodeValid(AddressCoreDTO addressCoreDTO) {
		return addressCoreDTO.getZipcode() != null;
	}


	/*
	 * Valida se pode fazer alteração do objeto Address
	 */
	public AddressCoreDTO canChangeThisAddressValidation(Optional<AddressCoreDTO> optAddressCoreDTO)
			throws AddressException {
		return optAddressCoreDTO.orElseThrow(AddressException::notFoundRegisterToChangerValues);
		
	
	}
	
	/*
	 * Faz o processo de atualização o objeto Address
	 */
	public void update(AddressCoreDTO addressCoreDTO, Optional<ZipCodeDataCoreDTO> zipCodeDataCoreDTO) {

		zipCodeDataCoreDTO.ifPresent(zipCode -> {

			if (notContainsComplement(addressCoreDTO))
				addressCoreDTO.setComplement(zipCode.getComplement());
			
			addressCoreDTO.setCity(zipCode.getLocality());
			addressCoreDTO.setNeighborhood(zipCode.getNeighborhood());
			addressCoreDTO.setStreetName(zipCode.getStreetName());
			addressCoreDTO.setState(zipCode.getUf());
			addressCoreDTO.setZipcode(zipCode.getId());

		});
	}
}
