package org.acme.hibernate.orm.panache;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class FruitsEndpointTest {

    @Test
    public void testListAllFruits() {

        Response response = given()
                .when()
                .get("/fruits")
                .then()
                .statusCode(200)
                .extract().response();

        int fruitsCount = response.jsonPath().getList("fruits").size();
        List<String> names = response.jsonPath().getList("name");
        List<String> ids = response.jsonPath().getList("id");
        System.out.println("names: "+ ids);

        assertThat(names, hasSize(fruitsCount));
        assertThat(names, hasItem("Apple"));
        assertThat(ids, hasSize(fruitsCount));
    }
}

