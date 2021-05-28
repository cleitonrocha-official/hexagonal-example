package br.com.demo.adapter.outbound.address.rest.cache.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StubbyCacheSimulatorDataResponseJson {

	private String id;
	private String street;
	private Integer number;
	private String add;
	private String neighborhood;
	private String local;
	private String uf;
	private String cep;

	
}
