import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import java.io.File;

public class petPostTest {


    File imageFile = new File("src/Screenshot (23).png"); // Replace with the actual file path
    @Test
    public void uploadImageReq()
    {

        JSONObject object = new JSONObject();
        object.put("additionalMetadata","Rex");

        baseURI = "https://petstore.swagger.io/v2";

        given().
                pathParam("petId",1234).
                multiPart("file",imageFile).
                when().
                post("/pet/{petId}/uploadImage").
                then().
                statusCode(200).log().all();


    }

}
