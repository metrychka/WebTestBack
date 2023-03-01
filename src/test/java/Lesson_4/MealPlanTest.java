package Lesson_4;

import Lesson_3.AbstractTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MealPlanTest extends AbstractTest {

        String id;
        @Test
        void mealPlanTest() {
            String id = given()
                    .queryParam("hash", "051efdd09b09eb79242dcb289f81fc35458fb362")
                    .queryParam("apiKey", getApiKey())
                    .body("{\n"
                            + " \"date\": 1677253096,\n"
                            + " \"slot\": 1,\n"
                            + " \"position\": 0,\n"
                            + " \"type\": \"INGREDIENTS\",\n"
                            + " \"value\": {\n"
                            + " \"ingredients\": [\n"
                            + " {\n"
                            + " \"name\": \"10 apple\"\n"
                            + " }\n"
                            + " ]\n"
                            + " }\n"
                            + "}")
                    .when()
                    .post("https://api.spoonacular.com/mealplanner/anna_m/items")
                    .then()
                    .statusCode(200)
                    .extract()
                    .jsonPath()
                    .get("id")
                    .toString();



            given()
                    .queryParam("hash", "051efdd09b09eb79242dcb289f81fc35458fb362")
                    .queryParam("apiKey", getApiKey())
                    .delete("https://api.spoonacular.com/mealplanner/anna_m/items/" + id)
                    .then()
                    .statusCode(200);
        }


    }

