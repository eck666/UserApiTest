package Tests;

import Users.User;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetAllUsersTest {


    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void getAllUsers() {
        User user = new User();
        System.out.println(user.GetAllUsers());
    }
}





