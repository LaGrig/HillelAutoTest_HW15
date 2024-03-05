package qauto.forstudy.space.webSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Web {

      public static WebDriver driver;
      public static final String webUrl = "https://guest:welcome2qauto@qauto.forstudy.space/";
//    public static RemoteWebDriver driver;
//    String gridUrl = "http://192.168.0.109:4444";

    //private static final String baseUrl ="https://qauto.forstudy.space/";

//    public Web() {
//        ChromeOptions options = new ChromeOptions();
//        try {
//            driver = new RemoteWebDriver(new URI(gridUrl).toURL(), options);
//        } catch (URISyntaxException e) {
//            System.out.println("Ошибка при создании URI: " + e.getMessage());
//        } catch (MalformedURLException e) {
//            System.out.println("Ошибка при преобразовании URI в URL: " + e.getMessage());
//        }
//    }

    @BeforeTest
    public void startBrowser(){
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void test1 () {
        driver.get(webUrl);
        var title = driver.getTitle();
        System.out.println(title);
    }

//    public void goToFirstPage() {
//        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
//    }
}
