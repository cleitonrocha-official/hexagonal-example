package br.com.demo.adapter.inbound.rest.response.json;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetAddressResponseJson {

	private String id;
	private String streetName;
	private Integer number;
	private String complement;
	private String neighborhood;
	private String city;
	private String state;
	private String zipcode;

}
