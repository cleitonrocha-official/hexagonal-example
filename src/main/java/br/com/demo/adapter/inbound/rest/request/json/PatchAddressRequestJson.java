package br.com.demo.adapter.inbound.rest.request.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatchAddressRequestJson {

	private String streetName;
	private Integer number;
	private String complement;
	private String neighborhood;
	private String city;
	private String state;
	private String zipcode;

}
