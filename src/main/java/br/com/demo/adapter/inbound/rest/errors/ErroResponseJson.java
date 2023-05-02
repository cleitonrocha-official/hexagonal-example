package br.com.demo.adapter.inbound.rest.errors;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErroResponseJson {

	private String type;
	private String message;
	private Timestamp createAt;

	public static ErroResponseJson from(HttpStatus status, Exception exception) {

		return new ErroResponseJson(status.getReasonPhrase(), 
				exception.getMessage(), 
				Timestamp.from(Instant.now()));
	}

}
