import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PutPatchDeleteEx {
    @Test
        public void putRequest(){

        //Map<String, Object> map = new HashMap<String, Object>();
        JSONObject putReq = new JSONObject();
        putReq.put("Name", "Disouky");
        putReq.put("Job", "Tester");
        System.out.println(putReq.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                body(putReq.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).log().all();

    }

    @Test
    public void deleteRequest(){

        baseURI = "https://reqres.in/api";
                when().
                delete("/users/2").
                then().
                statusCode(204).log().all();

    }
}
