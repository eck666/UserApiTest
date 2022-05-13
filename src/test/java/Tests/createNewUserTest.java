package Tests;

import Users.User;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class createNewUserTest {
    public static Logger LOG = Logger.getLogger(createNewUserTest.class);

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }


    @Test
    public void createNewUser() {
        User user = new User();
        user.createNewUser();
    }
}