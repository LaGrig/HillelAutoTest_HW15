package qauto.forstudy.space;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends Web {

    private final String guestLoginButton = "//button[contains(text(),'Guest')]";
    private final String userLoginButton = "//button[contains(text(),'Sign In')]";
    private final String homeButton = "//a [text()='Home']";
    private final String aboutButton = "//button [text()='About']";
    private final String contactsButton = "//button [text()='Contacts']";
    private final String pageTitle = "//h1[contains(text(),'Do more!')]";

    //social links
    private final String faceBook = "//span [@class='socials_icon icon icon-facebook']";
    private final String telegram = "//span [@class='socials_icon icon icon-telegram']";
    private final String youTube = "//span [@class='socials_icon icon icon-youtube']";
    private final String instagram = "//span [@class='socials_icon icon icon-instagram']";
    private final String linkedIn = "//span [@class='socials_icon icon icon-linkedin']";

    private WebElement pageTitile;

    public void checkPageOpens() {
        pageTitile = driver.findElement(By.xpath(pageTitle));
        pageTitile.isDisplayed();
    }

    public void elementsOnPageChecker() {
        try {
            driver.findElement(By.xpath(guestLoginButton));
            driver.findElement(By.xpath(userLoginButton));
            driver.findElement(By.xpath(homeButton));
            driver.findElement(By.xpath(aboutButton));
            driver.findElement(By.xpath(contactsButton));
            driver.findElement(By.xpath(faceBook));
            driver.findElement(By.xpath(telegram));
            driver.findElement(By.xpath(youTube));
            driver.findElement(By.xpath(instagram));
            driver.findElement(By.xpath(linkedIn));
        } catch (NoSuchElementException e) {
        }
    }
}
