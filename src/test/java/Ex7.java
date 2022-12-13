import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex7 {
    @Test
    public void Test7() {
        int statusCode;
        String location = "https://playground.learnqa.ru/api/long_redirect";
       do {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(location)
                .andReturn();
        statusCode = response.getStatusCode();
        location = response.getHeader("Location");

        System.out.println(statusCode + " " + location);
        }  while (statusCode != 200);
    }
}
