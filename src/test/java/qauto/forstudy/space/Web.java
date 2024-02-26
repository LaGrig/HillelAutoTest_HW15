package qauto.forstudy.space;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Web {

    static WebDriver driver;
    private static final String baseUrl ="https://qauto.forstudy.space/";

    @BeforeTest
    public void startBrowser(){ driver = new ChromeDriver(); }

    @AfterTest
    public void closeBrowser() {
        driver.close(); }

    private void goToFirstPage() {
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test
    public void checkMainPageAccess() throws InterruptedException {
        goToFirstPage();
        var loginPage = new LoginPage();
        Thread.sleep(5000);
        loginPage.checkPageOpens();
    }

    @Test
    public void allElementsArePresentOnPage(){
        var loginPage = new LoginPage();
        loginPage.elementsOnPageChecker();
        Assert.assertTrue(true);
    }
}
