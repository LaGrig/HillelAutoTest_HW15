package qauto.forstudy.space.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import qauto.forstudy.space.webSettings.Web;

public class MainPage extends Web {

    //Variables are in CamelCase (not Capital) because same style is applied at my work project
    //Page elements
    private final String guestLoginButton = "//button[contains(text(),'Guest')]";
    private final String userLoginButton = "//button[contains(text(),'Sign In')]";
    protected final String homeButton = "//a [text()='Home']";
    private final String aboutButton = "//button [text()='About']";
    private final String contactsButton = "//button [text()='Contacts']";
    private final String pageTitle = "//h1[contains(text(),'Do more!')]";
    private final String youTubeVideo = "//iframe[@src='https://www.youtube.com/embed/TLP8v7WTlSM?showinfo=0&controls=0']";
    private final String singUpButton = "//button [@class='hero-descriptor_btn btn btn-primary']";
    private final String aboutPicture1 = "//*[@alt='Instructions' and @src='/assets/images/homepage/info_1.jpg']";
    private final String aboutPicture2 = "//*[@alt='Instructions' and @src='/assets/images/homepage/info_2.jpg']";

    //Hillel links
    private final String hillelPageLink = "//a [contains(@href,'https://ithillel.ua')]";
    private final String hillelEmailLink = "//a [contains(@href,'mailto:developer@ithillel.ua')]";

    //social links
    private final String faceBook = "//span [@class='socials_icon icon icon-facebook']";
    private final String telegram = "//span [@class='socials_icon icon icon-telegram']";
    private final String youTube = "//span [@class='socials_icon icon icon-youtube']";
    private final String instagram = "//span [@class='socials_icon icon icon-instagram']";
    private final String linkedIn = "//span [@class='socials_icon icon icon-linkedin']";

    //Login form
    private final String singInEmailField = "//*[@id='signinEmail']";
    private final String singInPasswordField = "//*[@id='signinPassword']";
    private final String rememberCheckbox = "//*[@id='remember']";
    private final String buttonCrossToclosePopup = "//button[@class='close' and @aria-label='Close']/span[@aria-hidden='true']\n";
    private final String toRegistrationLink = "//*[button='Registration']//*[@class='btn btn-link']";
    private final String toLoginButton = "//button[@class='btn btn-primary' and text()='Login']";
    private final String forgotPasswordLink = "//button[@class='btn btn-link' and text()='Forgot password']";

    public String getGuestLoginButton() {return guestLoginButton; }
    public String getUserLoginButton() {return userLoginButton; }
    public String getHomeButton() { return homeButton;}
    public String getAboutButton() { return aboutButton; }
    public String getContactsButton() { return contactsButton; }
    public String getPageTitle() { return pageTitle; }
    public String getYouTubeVideo() {  return youTubeVideo;  }
    public String getSingUpButton() {  return singUpButton;   }
    public String getAboutPicture1() {  return aboutPicture1;   }
    public String getAboutPicture2() {  return aboutPicture2;    }
    public String getHillelPageLink() {   return hillelPageLink;  }
    public String getHillelEmailLink() {   return hillelEmailLink;   }
    public String getFaceBook() {  return faceBook;  }
    public String getTelegram() { return telegram;  }
    public String getYouTube() {  return youTube;  }
    public String getInstagram() {   return instagram;  }
    public String getLinkedIn() {  return linkedIn;  }
    public String getSingInEmailField() {  return singInEmailField;   }
    public String getSingInPasswordField() {  return singInPasswordField; }
    public String getRememberCheckbox() {  return rememberCheckbox;  }
    public String getButtonCrossToclosePopup() {   return buttonCrossToclosePopup; }
    public String getToRegistrationLink() {  return toRegistrationLink; }
    public String getToLoginButton() {   return toLoginButton;  }
    public String getForgotPasswordLink() {   return forgotPasswordLink; }


//    public void goToMainPageUrl() {
//        driver.get(webUrl);
//    }

    public void checkPageOpens() {
        var pageTitleHeader = driver.findElement(By.xpath(pageTitle));
        pageTitleHeader.isDisplayed();
    }

    public boolean elementsOnPageChecker() {
        try {
            driver.findElement(By.xpath(guestLoginButton));
            driver.findElement(By.xpath(userLoginButton));
            driver.findElement(By.xpath(homeButton));
            driver.findElement(By.xpath(aboutButton));
            driver.findElement(By.xpath(contactsButton));
            //driver.findElement(By.xpath(youTubeVideo)); //Пробема с определением объекта на странице
            driver.findElement(By.xpath(singUpButton));
            //driver.findElement(By.xpath(aboutPicture1)); //Пробема с определением объекта на странице
            //driver.findElement(By.xpath(aboutPicture2)); //Пробема с определением объекта на странице
            driver.findElement(By.xpath(hillelPageLink));
            driver.findElement(By.xpath(hillelEmailLink));
            driver.findElement(By.xpath(faceBook));
            driver.findElement(By.xpath(telegram));
            driver.findElement(By.xpath(youTube));
            driver.findElement(By.xpath(instagram));
            driver.findElement(By.xpath(linkedIn));
            return true; // Все элементы найдены
        } catch (NoSuchElementException ignored) {
            return false; // Один или несколько элементов не найдены
        }
    }
}
