package qauto.forstudy.space.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qauto.forstudy.space.pages.MainPage;
import qauto.forstudy.space.webSettings.Web;

import java.net.MalformedURLException;

public class MainTest extends Web {

    public MainTest() throws MalformedURLException {
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
