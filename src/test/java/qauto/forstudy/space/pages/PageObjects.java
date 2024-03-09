package qauto.forstudy.space.pages;

import qauto.forstudy.space.users.GuestPage;
import qauto.forstudy.space.users.UserPage;
import qauto.forstudy.space.webSettings.Web;

public class PageObjects extends Web {
    protected MainPage mainPage = new MainPage();
    protected GuestPage guestPage = new GuestPage();
    protected UserPage userPage = new UserPage();
    protected GaragePage garagePage = new GaragePage();
}
