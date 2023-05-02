package br.com.demo.adapter.inbound.jms;

import java.util.Optional;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.demo.adapter.inbound.jms.component._JmsReceivedComponent;
import br.com.demo.adapter.inbound.jms.mapper.InboundJmsMapper;
import br.com.demo.core.port.inbound.AddressCrudDomainPortInbound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Service
@AllArgsConstructor
public class AddressCrudDomainInboundJmsListener {

	private _JmsReceivedComponent jmsReceivedComponent;
	private AddressCrudDomainPortInbound crudDomainPortInbound;
	private InboundJmsMapper mapper;

	@JmsListener(destination = "${spring.activemq.queue.new-address}")
	public void onReceiveQueueNewAddress(Optional<String> addressArray) {
		log.info("Received messages jms listener : {}", addressArray);
		processAddressMsgListReceived(addressArray);
	}

	@Async
	private void processAddressMsgListReceived(Optional<String> addressArray) {
		addressArray.map(jmsReceivedComponent::addressArrayCollect)
		.orElseThrow()
		.stream()
		.map(mapper::from).forEach(crudDomainPortInbound::create);

	}

}
