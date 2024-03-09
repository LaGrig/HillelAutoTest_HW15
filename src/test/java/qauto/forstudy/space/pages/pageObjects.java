package qauto.forstudy.space.pages;

import qauto.forstudy.space.users.GuestPage;
import qauto.forstudy.space.users.UserPage;
import qauto.forstudy.space.webSettings.Web;

public class pageObjects extends Web {
    protected MainPage mainPage = new MainPage();
    protected GuestPage guestPage = new GuestPage();
    protected UserPage userPage = new UserPage();
}
