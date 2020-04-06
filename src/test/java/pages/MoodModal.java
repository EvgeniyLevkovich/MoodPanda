package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MoodModal {

    private final static String UPDATE_BUTTON_CSS = ".ButtonUpdate";
    private final static String MOOD_RATING_SLIDER_CSS = "#slider-range-min a";
    private final static String DESCRIPTION_TEXT_FIELD_CSS = "#TextBoxUpdateMoodTag";
    private final static String TO_DIARY_BUTTON_CSS = ".ButtonMyDiary";

    public MoodModal isPageOpened() {
        $(UPDATE_BUTTON_CSS).should(Condition.appear);
        return this;
    }

    public MoodModal updateDetails(int moodRating, String description, String date) {
        int difference = moodRating - getActualRate();
        Keys key;

        if(difference < 0) {
            key  = Keys.ARROW_LEFT;
        } else {
            key = Keys.ARROW_RIGHT;
        }
        for(int i = 0; i < Math.abs(difference); i++) {
            $(MOOD_RATING_SLIDER_CSS).sendKeys(key);
        }
        $(DESCRIPTION_TEXT_FIELD_CSS).sendKeys(description);
        sleep(1000);
        $(byText(date)).click();
        return this;
    }

    public int getActualRate() {
        String buttonText = $(UPDATE_BUTTON_CSS).getText();
        String[] rate = buttonText.split("to ");
        return Integer.parseInt(rate[1]);
    }

    public MoodModal clickUpdateMood() {
        $(UPDATE_BUTTON_CSS).click();
        return this;
    }

    public MyDiaryPage toDiary() {
        $(TO_DIARY_BUTTON_CSS).click();
        return new MyDiaryPage();
    }
}
