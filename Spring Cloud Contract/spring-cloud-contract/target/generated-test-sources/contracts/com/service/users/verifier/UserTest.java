package com.service.users.verifier;

import com.service.users.verifier.UsersVerifierTest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;
import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.RestAssured.*;

@SuppressWarnings("rawtypes")
public class UserTest extends UsersVerifierTest {

	@Test
	public void validate_userCreate() throws Exception {
		// given:
			RequestSpecification request = given()
					.header("Content-Type", "application/json")
					.header("Accept", "application/json")
					.body("{\"userId\":\"1\",\"name\":\"tesSpringCloudContract\",\"phone\":\"08234232\",\"email\":\"tesduluaja@mailinator.com\",\"address\":\"cibunar\"}");

		// when:
			Response response = given().spec(request)
					.post("/users");

		// then:
			assertThat(response.statusCode()).isEqualTo(201);
			assertThat(response.header("Content-Type")).matches("application/json.*");

		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['userId']").isEqualTo("1");
			assertThatJson(parsedJson).field("['name']").isEqualTo("tesSpringCloudContract");
			assertThatJson(parsedJson).field("['phone']").isEqualTo("08234232");
			assertThatJson(parsedJson).field("['email']").isEqualTo("tesduluaja@mailinator.com");
			assertThatJson(parsedJson).field("['address']").isEqualTo("cibunar");
	}

	@Test
	public void validate_userGet() throws Exception {
		// given:
			RequestSpecification request = given()
					.header("Content-Type", "application/json")
					.header("Accept", "application/json");

		// when:
			Response response = given().spec(request)
					.get("/users");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");

		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("Hello");
	}

}
