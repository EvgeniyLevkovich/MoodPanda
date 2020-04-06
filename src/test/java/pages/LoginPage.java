package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final static String URL = "https://moodpanda.com/Login/";
    private final static String GOOGLE_PLAY_LINK_CSS = "[alt='MoodPanda Android App on Google Play']";
    private final static String EMAIL_FIELD_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    private final static String PASSWORD_FIELD_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    private final static String LOGIN_BUTTON_CSS =  "#ContentPlaceHolderContent_ButtonLogin";

    public LoginPage openPage() {
        open(URL);
        $(GOOGLE_PLAY_LINK_CSS).waitUntil(Condition.visible, 30000);
        return this;
    }

    public FeedPage login(String user, String password) {
        $(EMAIL_FIELD_CSS).sendKeys(user);
        sleep(1000);
        $(PASSWORD_FIELD_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }
}
