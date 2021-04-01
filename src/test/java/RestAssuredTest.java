import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;


public class RestAssuredTest {

    @Test(description = "POST")
    public void postRequestExampleTest() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 31032022);
        requestBody.put("name", "Margo");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("https://petstore.swagger.io/v2/pet");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(response.getBody().asString());
    }

    @Test(description = "GET")
    public void getRequestExampleTest() {
        Response response = get("https://petstore.swagger.io/v2/pet/31032022");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(response.getBody().asString());
    }

    @Test(description = "PUT")
    public void putRequestExampleTest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 31032022);
        requestBody.put("name", "Margosha");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.put("https://petstore.swagger.io/v2/pet");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(response.getBody().asString());
    }

    @Test(description = "DELETE")
    public void deleteRequestExampleTest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 31032022);
        requestBody.put("name", "Margosha");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.delete("https://petstore.swagger.io/v2/pet/31032022");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(response.getBody().asString());
    }
}
