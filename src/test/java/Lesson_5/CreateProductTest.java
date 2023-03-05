package Lesson_5;

import Lesson_5.api.ProductService;
import Lesson_5.dto.Product;
import Lesson_5.utils.MarketUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import com.github.javafaker.Faker;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProductTest {
    static ProductService productService;
    Product product = null;
    Product product1 = null;
    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {
        productService = MarketUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
    }

    @Test
    void createProductInFoodCategoryTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @Test
    void modifyProductId() throws IOException {
        product1 = new Product()
                .withId(1)
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
        Response<Product> response = productService.modifyProduct(product1)
                .execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @Test
    void getProductById() throws IOException {
        Response <Product> response = productService.getProductById(2).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }


    @Test
    void getProductsResponseBody() throws IOException {
        Response <ResponseBody> response = productService.getProducts().execute();
    }


    @SneakyThrows
    @Test
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));


    }
}
