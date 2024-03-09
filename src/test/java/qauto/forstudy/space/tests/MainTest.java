package qauto.forstudy.space.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import qauto.forstudy.space.pages.MainPage;
import qauto.forstudy.space.pages.pageObjects;
import qauto.forstudy.space.webSettings.Web;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class MainTest extends pageObjects {

    @Test
    public void checkPageOpens_MainPage_1() {
        //driver.get(webUrl);
        mainPage.checkPageOpens();
        Assert.assertEquals(driver.getCurrentUrl(), "https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test
    public void checkMainPageElementArePresent_MainPage_2() {
        //driver.get(webUrl);
        Assert.assertTrue(mainPage.elementsOnPageChecker());
    }

    @Test
    public void checkHomeButtonLeadsToRightLocation_MainPage_3() {
        //driver.get(webUrl);
        driver.findElement(By.xpath(mainPage.getHomeButton())).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test
    public void checkAboutButtonLeadsToRightLocation_MainPage_4() throws InterruptedException {
        driver.findElement(By.xpath(mainPage.getAboutButton())).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(mainPage.getAboutPicture1())).isDisplayed());
    }

    @Test
    public void checkContactsButtonLeadsToRightLocation_MainPage_5() throws InterruptedException {
        driver.findElement(By.xpath(mainPage.getContactsButton())).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(mainPage.getHillelPageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(mainPage.getHillelEmailLink())).isDisplayed());
    }

    @Test
    public void checkGuestLoginButton_MainPage_6(){
        driver.findElement(By.xpath(mainPage.getGuestLoginButton())).click();
        var currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");
        Assert.assertTrue(driver.findElement(By.xpath(guestPage.getLoggedInAsGuestNotifier())).isDisplayed());
    }

    @Test
    public void checkSignInButtonLeadToLogin_MainPage_7 () throws InterruptedException {
        driver.findElement((By.xpath(mainPage.getUserLoginButton()))).click();
        WebElement emailField = driver.findElement(By.xpath(mainPage.getSingInEmailField()));
        WebElement passwordField = driver.findElement(By.xpath(mainPage.getSingInPasswordField()));
        WebElement loginButton = driver.findElement(By.xpath(mainPage.getToLoginButton()));
        emailField.click();
        emailField.sendKeys(userPage.getUserEmail());
        passwordField.click();
        passwordField.sendKeys(userPage.getUserPassword());
        loginButton.click();
        Thread.sleep(1000);
        var currentUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl2, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getLoginMessage())).isDisplayed());
    }
}
