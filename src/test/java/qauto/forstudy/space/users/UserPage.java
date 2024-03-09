package qauto.forstudy.space.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qauto.forstudy.space.webSettings.Web;

public class UserPage extends Web {
    //Locators
    private final String loginMessage = "//*[contains(text(),'You have been successfully logged in')]";


    // User predefined credentials
    private final String userEmail = "greg@gmail.com";
    private final String userPassword = "Qwerty123";

    // Getters

    public String getUserEmail() { return userEmail; }
    public String getUserPassword() { return userPassword; }

    public String getLoginMessage() { return loginMessage;  }
    //Other

    //WebElement message = driver.findElement(By.xpath(loginMessage));
    public final void User (String name, String password) {
        name = "TestUser";
        password ="Qwerty123";
    }
}
