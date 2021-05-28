package br.com.demo.core.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.demo.core.bo.AddressBO;
import br.com.demo.core.dto.AddressCoreDTO;
import br.com.demo.core.dto.ZipCodeDataCoreDTO;
import br.com.demo.core.errors.NotFoundRegisterToChangerValuesException;
import br.com.demo.core.port.inbound.AddressCrudDomainPortInbound;
import br.com.demo.core.port.outbound.AddressCreatePortOutbound;
import br.com.demo.core.port.outbound.AddressDeletePortOubound;
import br.com.demo.core.port.outbound.AddressPatchPortOubound;
import br.com.demo.core.port.outbound.AddressReadAllPortOutbound;
import br.com.demo.core.port.outbound.AddressReadByIdPortOutbound;
import br.com.demo.core.port.outbound.AddressUpdatePortOutbound;
import br.com.demo.core.port.outbound.ZipCodeDataByAddressPortOubound;
import br.com.demo.core.port.outbound.ZipCodeDataByIdPortOubound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AddressCrudDomainService implements AddressCrudDomainPortInbound {

	private AddressCreatePortOutbound addressCreatePortOutbound;

	private AddressReadAllPortOutbound addressReadAllPortOutbound;

	private AddressReadByIdPortOutbound addressReadByIdPortOutbound;

	private AddressUpdatePortOutbound addressUpdatePortOutbound;

	private AddressPatchPortOubound addressPatchPortOubound;

	private AddressDeletePortOubound addressDeletePortOubound;

	private ZipCodeDataByIdPortOubound zipCodeDataByIdPortOubound;
	
	private ZipCodeDataByAddressPortOubound zipCodeDataByAddressPortOubound;

	private final AddressBO addressBO = AddressBO.getInstance();

	@Override
	public String create(AddressCoreDTO addressCoreDTO) {

		log.info("start create process...");

		zipeCodeResolver(addressCoreDTO);

		var addressId = addressCreatePortOutbound.execute(addressCoreDTO);

		log.info("finish create process");

		return addressId;
	}

	@Override
	public Optional<AddressCoreDTO> read(String addressId) {

		log.info("start read by id process...");

		var optAddressCoreDTO = addressReadByIdPortOutbound.execute(addressId);

		log.info("finish read by id process");

		return optAddressCoreDTO;
	}

	@Override
	public Page<AddressCoreDTO> read(Pageable pageable) {

		log.info("start read all process...");

		var pageAddressCoreDTO = addressReadAllPortOutbound.execute(pageable);

		log.info("finish read all process");

		return pageAddressCoreDTO;
	}

	@Override
	public void update(AddressCoreDTO addressCoreDTO) throws NotFoundRegisterToChangerValuesException{

		log.info("start update process...");

		var canUpdateThisAddress = read(addressCoreDTO.getId());

		addressBO.canChangeThisAddressValidation(canUpdateThisAddress);

		zipeCodeResolver(addressCoreDTO);

		addressUpdatePortOutbound.execute(addressCoreDTO);

		log.info("finish update process");
	}

	@Override
	public void patch(AddressCoreDTO patchAddressCoreDTO) throws NotFoundRegisterToChangerValuesException {

		log.info("start patch process...");

		var canUpdateThisAddress = read(patchAddressCoreDTO.getId());

		addressBO.canChangeThisAddressValidation(canUpdateThisAddress);
		
		var addressFoundToPatch = canUpdateThisAddress.orElseThrow(NotFoundRegisterToChangerValuesException::new);

		addressPatchPortOubound.execute(addressFoundToPatch, patchAddressCoreDTO);

		log.info("finish patch process");

	}

	@Override
	public void delete(String addressId) throws NotFoundRegisterToChangerValuesException{

		log.info("start delete process...");
		
		var canUpdateThisAddress = read(addressId);

		addressBO.canChangeThisAddressValidation(canUpdateThisAddress);

		addressDeletePortOubound.execute(addressId);

		log.info("finish delete process");

	}

	private void zipeCodeResolver(AddressCoreDTO addressCoreDTO) {
		
			var addressByZipCodeFound = findAddressByZipCode(addressCoreDTO);

			addressBO.updateAddress(addressCoreDTO, addressByZipCodeFound);
		
	}

	private Optional<ZipCodeDataCoreDTO> findAddressByZipCode(AddressCoreDTO addressCoreDTO) {
		if(addressBO.containZipCodeValid(addressCoreDTO)) {
			
			return zipCodeDataByIdPortOubound.execute(addressCoreDTO.getZipcode());
		}
		
		return zipCodeDataByAddressPortOubound.execute(addressCoreDTO);
		
	}

}
