package br.com.demo.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressCoreDTO {

	private String id;
	private String streetName;
	private Integer number;
	private String complement;
	private String neighborhood;
	private String city;
	private String state;
	private String zipcode;
}
