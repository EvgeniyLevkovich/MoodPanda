package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    private final static String UPDATE_MOOD_ID = "#LinkUpdate";

    public FeedPage isPageOpened() {
        $(UPDATE_MOOD_ID).waitUntil(Condition.visible, 30000);
        return this;
    }

    public MoodModal clickUpdate() {
        $(UPDATE_MOOD_ID).click();
        return new MoodModal();
    }
}
