package qauto.forstudy.space.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import qauto.forstudy.space.pages.PageObjects;

import java.time.Duration;
import java.util.List;

public class UI_tests extends PageObjects {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //Main page tests

    @Test (testName = "Check Main page opens fine")
    public void checkPageOpens_MainPage_1() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainPage.getPageTitle())));
        mainPage.checkPageOpens();
        Assert.assertEquals(driver.getCurrentUrl(), "https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test (testName = "Check Main page elements are presents on page")
    public void checkMainPageElementArePresent_MainPage_2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainPage.getPageTitle())));
        Assert.assertTrue(mainPage.elementsOnPageChecker());
    }

    @Test (testName = "Check Home button works fine")
    public void checkHomeButtonLeadsToRightLocation_MainPage_3() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainPage.getPageTitle())));
        driver.findElement(By.xpath(mainPage.getHomeButton())).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainPage.getPageTitle())));
        Assert.assertEquals(driver.getCurrentUrl(), "https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test (testName = "Check About button works fine")
    public void checkAboutButtonLeadsToRightLocation_MainPage_4() throws InterruptedException {
        driver.findElement(By.xpath(mainPage.getAboutButton())).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(mainPage.getAboutPicture1())).isDisplayed());
    }

    @Test (testName = "Check Contacts button works fine")
    public void checkContactsButtonLeadsToRightLocation_MainPage_5() throws InterruptedException {
        driver.findElement(By.xpath(mainPage.getContactsButton())).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(mainPage.getHillelPageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(mainPage.getHillelEmailLink())).isDisplayed());
    }

    @Test (testName = "Check that is possible to login as Guest")
    public void checkGuestLoginButton_MainPage_6(){
        driver.findElement(By.xpath(mainPage.getGuestLoginButton())).click();
        var currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");
        Assert.assertTrue(driver.findElement(By.xpath(guestPage.getLoggedInAsGuestNotifier())).isDisplayed());
    }

    @Test (testName = "Check Login button leads to login form")
    public void checkSignInButtonLeadToLogin_MainPage_7 () throws InterruptedException {
        driver.findElement((By.xpath(mainPage.getUserLoginButton()))).click();
        WebElement emailField = driver.findElement(By.xpath(mainPage.getSignInEmailField()));
        WebElement passwordField = driver.findElement(By.xpath(mainPage.getSignInPasswordField()));
        WebElement loginButton = driver.findElement(By.xpath(mainPage.getToLoginButton()));

        emailField.click();
        emailField.sendKeys(userPage.getUserEmail());
        passwordField.click();
        passwordField.sendKeys(userPage.getUserPassword());
        loginButton.click();
        Thread.sleep(1000);
        var currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getLoginMessage())).isDisplayed());
    }

    //Guest page
    @Test (testName = "Login as Guest and check existing tabs")
    public void loginAsGuestAndCheckPresentTabs(){
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath(mainPage.getGuestLoginButton())).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userPage.getLoggedInAsGuestNotifier())));
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getLoggedInAsGuestNotifier())).isDisplayed());
        String currUrl = driver.getCurrentUrl();
        Assert.assertEquals(currUrl, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getHeaderGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getHeaderExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getHeaderInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getLogOutButton())).isDisplayed());

        List<WebElement> settingsLinks = driver.findElements(By.xpath(userPage.getSidebarSettingsLink()));
        Assert.assertTrue(settingsLinks.isEmpty());

        List<WebElement> profileLinks = driver.findElements(By.xpath(userPage.getSidebarProfileLink()));
        Assert.assertTrue(profileLinks.isEmpty());
    }

    @Test (testName = "Login as User and check all tabs are present")
    public void loginAsUserAndCheckPresentsTabs(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        login();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userPage.getLoginMessage())));
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getLoginMessage())).isDisplayed());
        String currUrl = driver.getCurrentUrl();
        Assert.assertEquals(currUrl, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getHeaderGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getHeaderExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getHeaderInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarProfileLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getHeaderProfileLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getSidebarSettingsLink())).isDisplayed());
    }

    @Test (testName = "Check if registration of new user is possible")
    public void checkIfRegistrationFormMayRegisterNewUser_Registration_Form_2(){
        long timestamp = System.currentTimeMillis();
        String userName = "John";
        String userLastName = "Doe";
        String password = "Qwerty123";
        driver.findElement(By.xpath(mainPage.getSignUpButton())).click();

        driver.findElement(By.xpath(mainPage.getSignUpNameInput())).sendKeys(userName);
        driver.findElement(By.xpath(mainPage.getSignUpLastnameInput())).sendKeys(userLastName);
        driver.findElement(By.xpath(mainPage.getSignUpEmailInput())).sendKeys(userName + timestamp + "@gmail.com");
        driver.findElement(By.xpath(mainPage.getSignUpPasswordInput())).sendKeys(password);
        driver.findElement(By.xpath(mainPage.getSignUpRePasswordInput())).sendKeys(password);
        driver.findElement(By.xpath(mainPage.getRegisterButton())).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userPage.getRegisterMessage())));
        Assert.assertTrue(driver.findElement(By.xpath(userPage.getRegisterMessage())).isDisplayed());
        String currUrl = driver.getCurrentUrl();
        Assert.assertEquals(currUrl, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");
    }

    @Test (testName = "Logout by Guest and Registered User")
    public void checkLogoutfunction() throws InterruptedException {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        //Guest login-logout
        driver.findElement(By.xpath(mainPage.getGuestLoginButton())).click();
        driver.findElement(By.xpath(userPage.getLogOutButton())).click();
        String currUrl = driver.getCurrentUrl();
        Assert.assertEquals(currUrl, "https://guest:welcome2qauto@qauto.forstudy.space/");
        //User login-logout
        login();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userPage.getHeaderProfileLink())));
        driver.findElement(By.xpath(userPage.getHeaderProfileLink())).click();
        driver.findElement(By.xpath(userPage.getLogOutDropdownButton())).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainPage.getPageTitle())));
        String currUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(currUrl2, "https://guest:welcome2qauto@qauto.forstudy.space/");
    }




    public void login() {
        String email = userPage.getUserEmail();
        String password = userPage.getUserPassword();
        driver.findElement(By.xpath(mainPage.getUserLoginButton())).click();
        driver.findElement(By.xpath(mainPage.getSignInEmailField())).sendKeys(email);
        driver.findElement(By.xpath(mainPage.getSignInPasswordField())).sendKeys(password);
        driver.findElement(By.xpath(mainPage.getToLoginButton())).click();
    }

}
