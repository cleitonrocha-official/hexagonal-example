package br.com.demo.core.bo;

class AddressBOTest {

	private final AddressBO addressBO = AddressBO.getInstance();
	
//	@Test
//	void canAddLngAndLatWhenGeolocateExistButLatAmdLngIsNullInAddressCoreDTO() {
//		
//		AddressCoreDTO addressCoreDTO = new AddressCoreDTO();
//		BigDecimal latitude =  BigDecimal.valueOf(30.5);
//		BigDecimal longitude =  BigDecimal.valueOf(20.3);
//		Optional<ZipCodeDataCoreDTO> optGeolocate = Optional.of(ZipCodeDataCoreDTO.builder()
//				.latitude(latitude)
//				.longitude(longitude)
//				.build());
//				
//		addressBO.updateAddress(addressCoreDTO , optGeolocate);
//		assertThat(addressCoreDTO.getLatitude()).isEqualByComparingTo(latitude);
//		assertThat(addressCoreDTO.getLongitude()).isEqualByComparingTo(longitude);
//	}
//	
//	
//	@Test
//	void notAddLngAndLatWhenGeolocateNotExistButLatAmdLngIsNullInAddressCoreDTO() {
//		
//		AddressCoreDTO addressCoreDTO = new AddressCoreDTO();
//		Optional<ZipCodeDataCoreDTO> optGeolocate = Optional.empty();
//				
//		addressBO.updateAddress(addressCoreDTO , optGeolocate);
//		assertThat(addressCoreDTO.getLatitude()).isNull();
//		assertThat(addressCoreDTO.getLongitude()).isNull();
//	}
//	
//	@Test
//	void notAddLngAndLatWhenGeolocateExistButLatAmdLngIsNotNullInAddressCoreDTO() {
//		
//		AddressCoreDTO addressCoreDTO = new AddressCoreDTO();
//		
//		BigDecimal latitude =  BigDecimal.valueOf(30.5);
//		BigDecimal longitude =  BigDecimal.valueOf(20.33);
//		addressCoreDTO.setLatitude( latitude.add(BigDecimal.TEN));
//		addressCoreDTO.setLongitude( longitude.add(BigDecimal.TEN));
//		
//		Optional<ZipCodeDataCoreDTO> optGeolocate = Optional.of(ZipCodeDataCoreDTO.builder()
//				.latitude(latitude)
//				.longitude(longitude)
//				.build());
//				
//		addressBO.updateAddress(addressCoreDTO , optGeolocate);
//		assertThat(addressCoreDTO.getLatitude()).isEqualByComparingTo(latitude.add(BigDecimal.TEN));
//		assertThat(addressCoreDTO.getLongitude()).isEqualByComparingTo(longitude.add(BigDecimal.TEN));
//	}
}
