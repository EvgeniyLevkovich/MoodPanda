package steps;

import pages.FeedPage;
import pages.LoginPage;
import pages.MoodModal;
import pages.MyDiaryPage;

public class MoodSteps {
    LoginPage loginPage;
    FeedPage feedPage;
    MoodModal moodModal;
    MyDiaryPage myDiaryPage;

    public MoodSteps() {
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        moodModal = new MoodModal();
        myDiaryPage = new MyDiaryPage();
    }

    public MoodSteps login(String user, String password) {
        loginPage.openPage()
                .login(user, password)
                .isPageOpened();
        return this;
    }

    public MoodSteps updateMood(int moodRating, String description, String date) {
        feedPage.clickUpdate()
                .isPageOpened()
                .updateDetails(moodRating, description, date)
                .clickUpdateMood()
                .toDiary()
                .isPageOpened()
                .validateForMoodRatingUpdate(moodRating);
        return this;
    }
}
