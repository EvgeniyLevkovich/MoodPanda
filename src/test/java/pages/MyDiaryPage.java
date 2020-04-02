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
        String moodRatingText = String.valueOf(moodModal.getNewMoodRating());  // вот тут достает 0 вместо 4
        System.out.println(moodRatingText);
        $(MY_LAST_RATING_CSS ).shouldHave(Condition.exactText(moodRatingText));
        return this;
    }
}
