package Lesson_4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTest extends AbstractTest{

    @Test
    void getCuisineTest() {
        given().spec(getRequestSpecification1())
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getDietTest() {
        given().spec(getRequestSpecification2())
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
   void  getMealTypeTest() {
        given().spec(getRequestSpecification3())
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getTypeTest() {
        given().spec(getRequestSpecification4())
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);

    }

}

