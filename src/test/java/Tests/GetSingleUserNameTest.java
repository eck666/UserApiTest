package Tests;

import Users.User;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetSingleUserNameTest {
    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }
    @Test
    public void GetSingleUserName(){
        User user = new User();
        user.GetSingleUsers("ecktest1");
    }
}
