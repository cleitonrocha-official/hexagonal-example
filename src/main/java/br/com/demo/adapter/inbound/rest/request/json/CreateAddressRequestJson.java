package br.com.demo.adapter.inbound.rest.request.json;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAddressRequestJson {

	@NotNull
	private String streetName;
	
	private Integer number;
	
	private String complement;
	
	private String neighborhood;
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	private String country;
	
	private String zipcode;

}
