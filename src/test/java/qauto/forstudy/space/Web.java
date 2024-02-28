package qauto.forstudy.space;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Web {

    //static WebDriver driver;
    String gridUrl = "http://192.168.0.126:5555";
    ChromeOptions options = new ChromeOptions();
    RemoteWebDriver driver = new RemoteWebDriver(new URL(gridUrl), options);

    private static final String baseUrl ="https://qauto.forstudy.space/";

    public Web() throws MalformedURLException {
    }

    @BeforeTest

    //public void startBrowser(){ driver = new RemoteWebDriver(); }

    @AfterTest
    public void closeBrowser() {
        driver.close(); }

    private void goToFirstPage() {
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test
    public void checkMainPageAccess() throws InterruptedException, MalformedURLException {
        goToFirstPage();
        var loginPage = new LoginPage();
        Thread.sleep(5000);
        loginPage.checkPageOpens();
    }

    @Test
    public void allElementsArePresentOnPage() throws MalformedURLException {
        var loginPage = new LoginPage();
        loginPage.elementsOnPageChecker();
        Assert.assertTrue(true);
    }
}
