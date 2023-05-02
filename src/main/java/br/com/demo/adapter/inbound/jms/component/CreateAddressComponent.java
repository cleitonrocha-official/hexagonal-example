package br.com.demo.adapter.inbound.jms.component;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.demo.adapter.inbound.jms.receive.AddressMsgReceive;

@Component
public class CreateAddressComponent implements _JmsReceivedComponent{

	public List<AddressMsgReceive> addressArrayCollect(String addressArray) {
		return Arrays.asList(new Gson().fromJson(addressArray, AddressMsgReceive[].class));
	}
	
}
