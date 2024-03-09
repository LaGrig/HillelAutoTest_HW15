package qauto.forstudy.space.users;

public class GuestPage {
    private final String loggedInAsGuestNotifier = "//* [@class='header_bar' and text()='Logged in as guest, any changes will be lost!']";


    public String getLoggedInAsGuestNotifier() { return loggedInAsGuestNotifier; }
}
