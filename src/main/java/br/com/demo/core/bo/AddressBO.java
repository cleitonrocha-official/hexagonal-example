package br.com.demo.core.bo;

import java.util.Optional;

import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;
import br.com.demo.core.errors.NotFoundRegisterToChangerValuesException;

public class AddressBO {

	private static final AddressBO INSTANCE = new AddressBO();

	private AddressBO() {

	}

	public static AddressBO getInstance() {
		return INSTANCE;
	}

	public boolean containZipCodeValid(AddressCoreDTO addressCoreDTO) {
		return addressCoreDTO.getZipcode() != null;
	}

	public void updateAddress(AddressCoreDTO addressCoreDTO, Optional<ZipCodeDataCoreDTO> zipCodeDataCoreDTO) {

		zipCodeDataCoreDTO.ifPresent(zipCode -> {

			if (addressCoreDTO.getComplement() == null)
				addressCoreDTO.setComplement(zipCode.getComplement());
			addressCoreDTO.setCity(zipCode.getLocality());
			addressCoreDTO.setNeighborhood(zipCode.getNeighborhood());
			addressCoreDTO.setStreetName(zipCode.getStreetName());
			addressCoreDTO.setState(zipCode.getUf());
			addressCoreDTO.setZipcode(zipCode.getId());

		});
	}

	public void canChangeThisAddressValidation(Optional<AddressCoreDTO> optAddressCoreDTO)
			throws NotFoundRegisterToChangerValuesException {
		if (optAddressCoreDTO.isEmpty()) {
			throw new NotFoundRegisterToChangerValuesException();
		}
	}
}
