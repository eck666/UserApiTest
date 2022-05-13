package Users;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Data;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

@Data

public class User {
    private String website;
    private Address address;
    private String phone;
    private String name;
    private int id;
    private String email;
    public String username2 = "Cannot Found User Name!";
    public int sayi;
    Response rs = given().when().get("/users");
    public void Username() {
        if (rs.getStatusCode() == HttpStatus.SC_OK) {
            List<String> userNameList = rs.getBody().jsonPath().get("name");
            sayi = userNameList.size();
            for (int a = 0; a < sayi; a++) {
                System.out.println("User Name : " + userNameList.get(a));
            }
        } else {
            Assert.fail(rs.getStatusLine() + "Fail!" + rs.getStatusCode());
        }
    }

    public String GetAllUsers() {
        String message = (rs.getBody().asString());
        return message;
    }

    public void GetSingleUsers(String ad) {
        if (rs.getStatusCode() == HttpStatus.SC_OK) {
            List<String> userNameList = rs.getBody().jsonPath().get("name");
            sayi = userNameList.size();
            boolean query = true;
            for (int a = 0; a < sayi; a++) {
                if (userNameList.get(a).equals(ad)) {
                    username2 = userNameList.get(a);
                    System.out.println("User Name : " + username2);
                    query = false;
                }
            }
            if (query) {
                System.out.println("User Name : " + username2);
            }
        } else {
            Assert.fail(rs.getStatusLine() + "Fail!" + rs.getStatusCode());
        }
    }

    public void createNewUser() {
        Response rs = given()
                .contentType(ContentType.JSON)
                .body(new File(System.getProperty("user.dir") + File.separator + "createUser.json"))
                .when()
                .post("/users");
        if (rs.getStatusCode() == HttpStatus.SC_CREATED) {
            System.out.println(rs.getBody().asString());
            int id = rs.getBody().jsonPath().get("id");
            Assert.assertEquals(id, 7);
        } else {
            Assert.fail(rs.getStatusLine() + " Fail User Create! " + rs.getStatusCode());
        }
    }

    public void deleteUser(int id){
        Response rsp = given().contentType(ContentType.JSON).pathParam("id", id)
                .when()
                .delete("/users/{id}");
        if (rs.getStatusCode() == HttpStatus.SC_OK) {
            List<String> userNameList = rs.getBody().jsonPath().get("name");
            List<Integer> userid = rs.getBody().jsonPath().get("id");
            sayi = userid.size();
            for (int a = 0; a < sayi; a++) {
                if (userid.get(a)==id) {
                    username2 = userNameList.get(a);

                }
            }
            System.out.println(" User Deleted : " + username2 );
        } else {
            Assert.fail(rsp.getStatusLine() + " Fail Delete! " + rsp.getStatusCode());
        }
    }
}