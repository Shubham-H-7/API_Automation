package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.Users;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests {

    Faker faker;
    Users userpayload;

    @BeforeClass
    public void setUpData(){
            faker= new Faker();
           userpayload = new Users();

           userpayload.setId(faker.idNumber().hashCode());
           userpayload.setUsername(faker.name().username());
           userpayload.setFirstName(faker.name().firstName());
           userpayload.setLastName(faker.name().lastName());
           userpayload.setEmail(faker.internet().emailAddress());
           userpayload.setPassword(faker.internet().password());
    }
    @Test(priority = 1)
    public void testPostUser(){
        Response res  = UserEndPoints.createUser(userpayload);
       // res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUser(){
        Response res = UserEndPoints.readUser(this.userpayload.getUsername());
       // res.then().log().all();

        Assert.assertEquals(res.getStatusCode(),200);
    }
    @Test(priority = 3)
    public void testUpdateUser(){
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());

        Response res=UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
        res.then().log().all();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUser(){
        Response res= UserEndPoints.deleteUser(this.userpayload.getUsername());
        //res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }
}
