package br.com.demo.core.bo;

import static br.com.demo.core.errors.messages.AddressErrorMessages.NOT_FOUND_REGISTER_TO_UPDATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;
import br.com.demo.core.errors.exceptions.AddressException;

class AddressBOUnityTest {

	private final AddressBO addressBO = AddressBO.getInstance();

	@Test
	void notCanChangeThisAddress() throws AddressException {

		Optional<AddressCoreDTO> emptyOptinalAddress = Optional.empty();

		var assertThrows = assertThrows(AddressException.class, () -> {
			addressBO.canChangeThisAddressValidation(emptyOptinalAddress);
		});

		assertEquals(AddressException.class, assertThrows.getClass());
		assertEquals(NOT_FOUND_REGISTER_TO_UPDATE, assertThrows.getMessage());

	}

	@Test
	void canChangeThisAddress() throws AddressException {

		var emptyOptinalAddress = Optional.ofNullable(new AddressCoreDTO());

		var canChangeThisAddressValidation = addressBO.canChangeThisAddressValidation(emptyOptinalAddress);

		assertThat(canChangeThisAddressValidation).isNotNull();
	}

	@Test
	void setZipCodeComplementWhenNotContainsComplementInAddressUpdate() {


		var addressCoreDTO = AddressCoreDTO.builder().number(10).build();

		var zipCodeDataCoreDTO = buildDataAddressCoreDTO();

		addressBO.update(addressCoreDTO, Optional.ofNullable(zipCodeDataCoreDTO));

		assertEquals(addressCoreDTO.getComplement(), zipCodeDataCoreDTO.getComplement());

	}

	@Test
	void notSetZipCodeComplementWhenExistsContainsComplementInAddressUpdate() {

		var complementAddress = "COMPLEMENT_ADDRESS";
		var complementZipcode = "COMPLEMENT_ZIPCODE";

		var addressCoreDTO = AddressCoreDTO.builder().complement(complementAddress).build();

		var zipCodeDataCoreDTO = buildDataAddressCoreDTO();

		addressBO.update(addressCoreDTO, Optional.ofNullable(zipCodeDataCoreDTO));

		assertThat(addressCoreDTO.getComplement()).isNotEqualTo(complementZipcode);

	}

	@Test
	void validAllValuesTranslatorAddresUpdate() {



		var addressCoreDTO = AddressCoreDTO.builder().number(10).build();
		
		var zipCodeDataCoreDTO = buildDataAddressCoreDTO();

		addressBO.update(addressCoreDTO, Optional.ofNullable(zipCodeDataCoreDTO));

		assertThat(addressCoreDTO.getComplement()).isEqualTo(zipCodeDataCoreDTO.getComplement());
		assertThat(addressCoreDTO.getCity()).isEqualTo(zipCodeDataCoreDTO.getLocality());
		assertThat(addressCoreDTO.getNeighborhood()).isEqualTo(zipCodeDataCoreDTO.getNeighborhood());
		assertThat(addressCoreDTO.getStreetName()).isEqualTo(zipCodeDataCoreDTO.getStreetName());
		assertThat(addressCoreDTO.getState()).isEqualTo(zipCodeDataCoreDTO.getUf());
		assertThat(addressCoreDTO.getZipcode()).isEqualTo(zipCodeDataCoreDTO.getId());

	}
	
	

	private ZipCodeDataCoreDTO buildDataAddressCoreDTO() {
		var zipCodeComplement = "COMPLEMENT_ZIPCODE";
		var zipCodeLocality = "zipCodeLocality";
		var zipCodeNeighborhood = "zipCodeNeighborhood";
		var zipCodeStreetName = "zipCodeStreetName";
		var zipCodeUF = "zipCodeUF";
		var zipCodeId = "zipCodeId";
		
		var zipCodeDataCoreDTO = ZipCodeDataCoreDTO.builder()
				.complement(zipCodeComplement)
				.locality(zipCodeLocality)
				.neighborhood(zipCodeNeighborhood)
				.streetName(zipCodeStreetName)
				.uf(zipCodeUF)
				.id(zipCodeId)
				.build();
		return zipCodeDataCoreDTO;
	}

}
