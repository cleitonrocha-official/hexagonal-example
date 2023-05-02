package br.com.demo.adapter.inbound.jms.component;

import java.util.List;

import br.com.demo.adapter.inbound.jms.receive.AddressMsgReceive;


public interface _JmsReceivedComponent {

	public List<AddressMsgReceive> addressArrayCollect(String addressArray) ;
}
