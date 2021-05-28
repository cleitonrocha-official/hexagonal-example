package br.com.demo.adapter.outbound.zipcode.rest.viacep.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViaCepDataResponseJson {

	@JsonProperty("cep")
	private String zipCode;
	@JsonProperty("logradouro")
	private String streetName;
	@JsonProperty("complemento")
	private String complement;
	@JsonProperty("bairro")
	private String neighborhood;
	@JsonProperty("localidade")
	private String locality;
	@JsonProperty("uf")
	private String uf;

	
}
