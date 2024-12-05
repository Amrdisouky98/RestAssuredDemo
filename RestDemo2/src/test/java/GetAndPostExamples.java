import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {
    //@Test
    public void testGet(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[2].first_name",equalTo("Tobias")).
                body("data.first_name", hasItems("George","Rachel"));
    }

    @Test
    public void testPost(){
        //Key value collection
//        Map <String, Object> map = new HashMap <String, Object>();
//
//        map.put("name", "Amr");
//        map.put("Job", "Teacher");

        //System.out.println(map);

        //JSON object creation
        JSONObject postReq = new JSONObject();
        postReq.put("Name", "Disouky");
        postReq.put("Job", "Tester");
        System.out.println(postReq.toJSONString());

        //Testing script
        baseURI = "https://reqres.in/api";
        given().
                body(postReq.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();

    }
}
