package br.com.demo.adapter.inbound.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.demo.adapter.inbound.rest.request.json.CreateAddressRequestJson;
import br.com.demo.adapter.inbound.rest.request.json.UpdateAddressRequestJson;
import br.com.demo.adapter.inbound.rest.response.json.GetAddressResponseJson;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
class AddressCrudDomainInboundControllerIntegreationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private String id = "4";
	
	private String BASE_URI ;
	
	
	@BeforeEach
	public void init() {
		BASE_URI = "http://localhost:" + port + "/address";
		mongoTemplate.getDb().drop();
	}
	
	
	@Test
	void readAddressWithNotFound() {
		ResponseEntity<String> response = this.restTemplate.getForEntity(BASE_URI,
				String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
	
	@Test
	void postAddressWithBadRequest() {
		var response = this.restTemplate.postForEntity(BASE_URI, 
				CreateAddressRequestJson.builder()
				.build(), String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@Test
	void postAddressWithoutLongitudeAndLatitudeWithSucess() {
		var response = createWithSuccess();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
	}

	
	@Test
	void readAddressWithSuccess() {
		
		assertThat(createWithSuccess().getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		ResponseEntity<String> response = this.restTemplate.getForEntity(BASE_URI,
				String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
	
	@Test
	void readAddressByIDWithSuccess() {
		var createWithSuccess = createWithSuccess();
		
		assertThat(createWithSuccess.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		var id = extractIdFromHeader(createWithSuccess);
		
		ResponseEntity<GetAddressResponseJson> response = this.restTemplate.getForEntity(BASE_URI + "/" + id,
				GetAddressResponseJson.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}

	
	@Test
	void putAddressWithChangeNeighbourdhoodSuccess() {
		
		var createWithSuccess = createWithSuccess();
		
		assertThat(createWithSuccess.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		var id = extractIdFromHeader(createWithSuccess);
		
		 this.restTemplate.put(BASE_URI +  "/" + id,
				UpdateAddressRequestJson.builder()
					.city("Sao paulo")
					.streetName("Avenida x")
					.country("São paulo")
					.number(33)
					.state("SP")
					.zipcode("13232211")
				.build());
		
		ResponseEntity<GetAddressResponseJson> responseGet = this.restTemplate.getForEntity(BASE_URI + "/" + id,
				GetAddressResponseJson.class);
		
		assertThat(responseGet.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		
		assertThat(responseGet.getBody().getNeighborhood()).isEqualTo("Parque Residencial Califórnia");
		
	}
	

	
	@Test
	void deleteAddressByIDWithSuccess() {

		assertThat(createWithSuccess().getStatusCode()).isEqualTo(HttpStatus.CREATED);
		this.restTemplate.delete(BASE_URI + "/" + id);

		ResponseEntity<GetAddressResponseJson> responseGet = this.restTemplate.getForEntity(BASE_URI + "/" + id,
				GetAddressResponseJson.class);

		assertThat(responseGet.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	}
	
	private ResponseEntity<String> createWithSuccess() {
		 var postForEntity = this.restTemplate.postForEntity(BASE_URI, 
				CreateAddressRequestJson.builder()
					.city("Sao paulo")
					.streetName("Avenida maria pansarim porcari")
					.country("São paulo")
					.zipcode("13232211")
					.neighborhood("String")
					.number(330)
					.state("SP")
					.zipcode("13232211")
				.build(), String.class);
		 log.info("return = {}",postForEntity.getHeaders());
		 return postForEntity;
	}
	
	private String extractIdFromHeader(ResponseEntity<String> createWithSuccess) {
		var location = getHeaderWithLocation(createWithSuccess);
		var split = splitUri(location);
		var id = selectIdFromUri(split);
		return id;
	}

	private String getHeaderWithLocation(ResponseEntity<String> createWithSuccess) {
		return createWithSuccess.getHeaders().get("Location").get(0);
	}

	private String[] splitUri(String location) {
		return location.split("/");
	}

	private String selectIdFromUri(String[] split) {
		return split[6];
	}




	
}
