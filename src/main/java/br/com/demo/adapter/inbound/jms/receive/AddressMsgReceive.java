package br.com.demo.adapter.inbound.jms.receive;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressMsgReceive {

	
	@SerializedName("endereco")
	private String streetName;
	@SerializedName("nemero")
	private Integer number;
	@SerializedName("complento")
	private String complement;
	@SerializedName("bairro")
	private String neighborhood;
	@SerializedName("cidade")
	private String city;
	@SerializedName("uf")
	private String state;
	@SerializedName("cep")
	private String zipcode;
}
