package Lesson_4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    protected static ResponseSpecification responseSpecification;
    protected static RequestSpecification requestSpecification1;
    protected static RequestSpecification requestSpecification2;
    protected static RequestSpecification requestSpecification3;
    protected static RequestSpecification requestSpecification4;


@BeforeAll

static void initTest() throws IOException {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    configFile = new FileInputStream("src/main/resources/my.properties");
    prop.load(configFile);

    apiKey =  prop.getProperty("apiKey");
    baseUrl= prop.getProperty("base_url");

    responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectStatusLine("HTTP/1.1 200 OK")
            .expectContentType(ContentType.JSON)
            .expectResponseTime(Matchers.lessThan(5000L))
            .build();

    requestSpecification1 = new RequestSpecBuilder()
            .addQueryParam("apiKey", apiKey)
            .addQueryParam("cuisine", "asian")
            .addQueryParam("maxReadyTime", "40")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    requestSpecification2 = new RequestSpecBuilder()
            .addQueryParam("apiKey", apiKey)
            .addQueryParam("diet", "Ketogenic")
            .addQueryParam("maxReadyTime", "40")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    requestSpecification3 = new RequestSpecBuilder()
            .addQueryParam("apiKey", apiKey)
            .addQueryParam("minFat", "15")
            .addQueryParam("maxReadyTime", "20")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    requestSpecification4 = new RequestSpecBuilder()
            .addQueryParam("apiKey", apiKey)
            .addQueryParam("type", "dessert")
            .addQueryParam("maxReadyTime", "20")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

   RestAssured.responseSpecification = responseSpecification;

}

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public RequestSpecification getRequestSpecification1(){
        return requestSpecification1;
    }

    public RequestSpecification getRequestSpecification2(){
        return requestSpecification2;
    }

    public RequestSpecification getRequestSpecification3(){
        return requestSpecification3;
    }

    public RequestSpecification getRequestSpecification4(){
        return requestSpecification4;
    }
}
