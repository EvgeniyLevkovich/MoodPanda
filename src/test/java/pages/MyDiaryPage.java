package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;

public class MyDiaryPage {

    private final static String MY_LAST_RATING_CSS = ".badge.pull-right";

    public MyDiaryPage isPageOpened() {
        $(MY_LAST_RATING_CSS ).should(Condition.appear);
        return new MyDiaryPage();
    }

    public MyDiaryPage validateForMoodRatingUpdate(int moodRating) {
        String moodRatingText = String.valueOf(moodRating);
        System.out.println(moodRating);
        $(MY_LAST_RATING_CSS ).shouldHave(Condition.exactText(moodRatingText));
        return this;
    }
}
