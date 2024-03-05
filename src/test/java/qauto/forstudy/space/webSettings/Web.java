package qauto.forstudy.space.webSettings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import qauto.forstudy.space.pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

public class Web {

    static RemoteWebDriver driver;
    String gridUrl = "http://192.168.0.109:4444";

    //private static final String baseUrl ="https://qauto.forstudy.space/";

    public Web() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new RemoteWebDriver(new URL(gridUrl), options);
    }

//    @BeforeTest
//
//    //public void startBrowser(){ driver = new RemoteWebDriver(); }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }

    private void goToFirstPage() {
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test
    public void checkMainPageAccess() throws InterruptedException, MalformedURLException {
        goToFirstPage();
        var loginPage = new MainPage();
        Thread.sleep(5000);
        loginPage.checkPageOpens();
    }

    @Test
    public void allElementsArePresentOnPage() throws MalformedURLException {
        var loginPage = new MainPage();
        loginPage.elementsOnPageChecker();
        Assert.assertTrue(true);
    }
}
