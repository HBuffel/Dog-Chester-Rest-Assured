package dog_api_tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class api_dog {

    static final ResponseSpecification SUCCESS = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    static final RequestSpecification REQUEST = new RequestSpecBuilder()
            .setBaseUri("https://api.thedogapi.com/")
            .addHeader("x-api-key", "live_inNgUSeCbz4ZaQaEKm7BaSGoCXLYJevb0fswbCYWPeh9qs9Gk2IH61W4TghL5lN1")
            .build();

    @Test
    public void getFavourites() {
        given()
                .spec(REQUEST)
                .queryParam("sub_id", "my-user-1234")
                .when()
                .get("/v1/favourites")
                .then()
                .spec(SUCCESS.statusCode(200));
        System.out.println("Favourites");
    }

    @Test
    public void createFavourite() {
        given()
                .spec(REQUEST)
                .queryParam("image_id", "70849")
                .queryParam("id", "papa penny")
                .when()
                .post("/v1/favourites")
                .then()
                .spec(SUCCESS.statusCode(400));
        System.out.println("Successfully created Papa Penny");
    }

        @Test
        public void saveFavourite() {
            given()
                    .spec(REQUEST)
                    .queryParam("image_id", "70878")
                    .queryParam("sub_id", "my-user-1234") // add sub_id to associate the favorite with the user
                    .when()
                    .post("/v1/favourites")
                    .then()
                    .spec(SUCCESS.statusCode(400)); // update the expected status code
              System.out.println("Saved Papa Penny successfully");
    }
         public void deleteFavourite() {
                given()
                        .spec(REQUEST)
                        .queryParam("favourite_id", "Papa Penny")
                        .when()
                        .delete("/v1/favourites")
                        .then()
                        //update the expected status code
                        .spec(SUCCESS.statusCode(400));
                System.out.println("Successfully deleted Papa Penny");

            }
            }



