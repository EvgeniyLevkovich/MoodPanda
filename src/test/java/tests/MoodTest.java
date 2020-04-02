package tests;

import org.testng.annotations.Test;

public class MoodTest extends BaseTest {

    @Test
    public void updateMoodRatingTest() {
        steps
                .login("horus@mailinator.com", "password01")
        /** "date" field can contain values "Now", "Yesterday", "2 days ago" and "3 days ago" **/
                .updateMood(4, "All I want to do is eat", "Now");
    }
}
