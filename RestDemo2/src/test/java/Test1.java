//to import the whole restAssured library statically
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {
    @Test
    public void test1(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getTime());
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }

    @Test
    public void test_2(){
        baseURI = "https://reqres.in/api";
        given().get("users?page=2").then().statusCode(200)
                        .body("data[1].id",equalTo(8)).log().all();
    }
}
