package Lesson_3;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostTests extends AbstractTest {
    @Test
    void postBeefTest() {
        given()
                .log()
                .all()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Corned Beef and Cabbage")
                .formParam("ingredientList", "Corned Beef")
                .when()
                .post(getPostUrl())
                .then()
                .statusCode(200);
    }

  @Test
  void postCubanStylePorkMedallionsTest() {
      given()
              .log()
              .all()
              .queryParam("apiKey", getApiKey())
              .queryParam("language", "en")
              .contentType("application/x-www-form-urlencoded")
              .formParam("title", "Cuban Style Pork Medallions")
              .formParam("ingredientList", "Pork")
              .when()
              .post(getPostUrl())
              .then()
              .statusCode(200);
  }

   @Test
    void postInstantPotChickenTacosTest() {
        given()
                .log()
                .all()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Instant Pot Chicken Tacos")
                .formParam("ingredientList", "Chicken")
                .when()
                .post(getPostUrl())
                .then()
                .statusCode(200);
    }
    @Test
    void postBakedTeriyakiChickenDrumsticksTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Baked Teriyaki Chicken Drumsticks")
                .formParam("ingredientList", "Broccoli")
                .when()
                .post(getPostUrl())
                .then()
                .statusCode(200);
    }

    @Test
    void postCauliflowerBrownRiceAndVegetableFriedRiceTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Cauliflower, Brown Rice, and Vegetable Fried Rice")
                .formParam("ingredientList", "Brown Rice")
                .when()
                .post(getPostUrl())
                .then()
                .statusCode(200);
    }

}
