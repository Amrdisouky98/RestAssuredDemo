import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class petGetTest {

    File imageFile = new File("src/Screenshot (23).png");
    @Test
    public void uploadImageReq()
    {

//        JSONObject object = new JSONObject();
//        //object.put("petID", "1234");
//        object.put("additionalMetadata","Rex");

        baseURI = "https://petstore.swagger.io/v2";

        given().
                queryParam("status","available").
                when().
                get("/pet/findByStatus").
                then().
                statusCode(200).log().all();


    }
}
