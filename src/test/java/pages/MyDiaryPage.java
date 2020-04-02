package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;

public class MyDiaryPage {
    MoodModal moodModal = new MoodModal();

    private final static String MY_LAST_RATING_CSS = ".badge.pull-right";

    public MyDiaryPage isPageOpened() {
        $(MY_LAST_RATING_CSS ).should(Condition.appear);
        return new MyDiaryPage();
    }

    public MyDiaryPage validateForMoodRatingUpdate() {
        $(MY_LAST_RATING_CSS ).shouldNotHave(Condition.exactText(String.valueOf(moodModal.getNewMoodRating())));
        return this;
    }
}
