package Lesson_3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTests extends AbstractTest{
    @Test
    void getCuisineTest() {
        given()
               .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "asian")
                .queryParam("maxReadyTime", "50")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);
    }

   @Test
   void getTestDiet() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "Ketogenic")
                .queryParam("maxReadyTime", "30")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);
    }

    @Test
    void getTestSort() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("sort", "protein")
                .queryParam("maxReadyTime", "25")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);
    }
    @Test
    void getTestMealType() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "dessert")
                .queryParam("maxReadyTime", "20")
                .queryParam("cuisine", "asian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);
    }

  @Test
    void getMinFat() {
      given()
              .log()
              .all()
              .queryParam("apiKey", getApiKey())
              .queryParam("minFat", "15")
              .queryParam("maxReadyTime", "40")
              .queryParam("cuisine", "american")
              .when()
              .get("https://api.spoonacular.com/recipes/complexSearch")
              .then()
              .statusCode(200);
  }

}

