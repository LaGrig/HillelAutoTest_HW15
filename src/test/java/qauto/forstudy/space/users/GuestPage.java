package qauto.forstudy.space.users;

public class GuestPage {

    //Page objects locators
    private final String loggedInAsGuestNotifier = "//* [@class='header_bar' and text()='Logged in as guest, any changes will be lost!']";
    private final String sidebarGarageLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn -active' and @href='/panel/garage']";
    private final String headerGarageLink = "//a[@class='btn header-link -active' and @href='/panel/garage']";
    private final String sidebarExpensesLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/expenses']";
    private final String headerExpensesLink = "//a[@class='btn header-link' and @href='/panel/expenses']";
    private final String sidebarInstructionsLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/instructions']";
    private final String headerInstructionsLink = "//a[@class='btn header-link' and @href='/panel/instructions']";
    private final String logOutButton = "//a[@class='btn btn-link text-danger btn-sidebar sidebar_btn' and text()=' Log out ']";

    public String getLoggedInAsGuestNotifier() { return loggedInAsGuestNotifier; }
}
