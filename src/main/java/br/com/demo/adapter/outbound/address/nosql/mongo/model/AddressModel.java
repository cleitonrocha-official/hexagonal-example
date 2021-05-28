package br.com.demo.adapter.outbound.address.nosql.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Address")
@Getter
@Setter
public class AddressModel {

	@Id
	private String id;
	private String streetName;
	private Integer number;
	private String complement;
	private String neighborhood;
	private String city;
	private String state;
	private String zipcode;


}
