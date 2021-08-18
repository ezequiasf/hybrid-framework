package pageObjects;

import org.openqa.selenium.By;

public class Login_Page {

    public static By txtUser= By.id("userName");
    public static By txtPass= By.xpath("//input[@placeholder='Password']");
    public static By btnLogin= By.id("login");
    public static By btnRegister= By.id("newUser");

}
