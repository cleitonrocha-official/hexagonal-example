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
public class ZipCodeDataCoreDTO {

	private String id;
	private String streetName;
	private String neighborhood;
	private String locality;
	private String uf;
	private String complement;

}
