package br.com.demo.adapter.inbound.jms.bo;

import java.util.List;

import br.com.demo.adapter.inbound.jms.receive.AddressMsgReceive;


public interface JmsReceivedBO {

	
	public List<AddressMsgReceive> addressArrayCollect(String addressArray) ;
}
