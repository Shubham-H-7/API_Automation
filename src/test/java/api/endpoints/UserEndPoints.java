package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

    public static Response createUser(Users payload){
       Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response readUser(String username){
        Response response= given()
                .pathParam("username",username)
                .when()
                .get(Routes.get_user);

        return response;
    }

    public static Response updateUser(String username, Users payload){
       Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(Routes.update_user);

        return response;
    }

    public static Response deleteUser( String username){
        Response response= given()
                .pathParam("username", username)
                .when()
                .delete(Routes.delete_user);

        return response;
    }
}


