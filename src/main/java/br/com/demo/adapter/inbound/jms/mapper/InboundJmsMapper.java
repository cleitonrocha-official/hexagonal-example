package br.com.demo.adapter.inbound.jms.mapper;

import org.mapstruct.Mapper;

import br.com.demo.adapter.inbound.jms.receive.AddressMsgReceive;
import br.com.demo.core.dto.AddressCoreDTO;

@Mapper(componentModel = "spring")
public interface InboundJmsMapper {

	AddressCoreDTO from(AddressMsgReceive addressMsgReceive);

}
