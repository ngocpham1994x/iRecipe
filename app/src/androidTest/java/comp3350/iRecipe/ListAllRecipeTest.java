package comp3350.iRecipe;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.iRecipe.Presentation.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListAllRecipeTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyListOfReciped(){
        //select the view all recipe card 
        onView(withText("View all recipes")).perform(click());

        onView(withText("Butter chicken")).perform(click());
        onView(withId(R.id.recipe)).check(matches(withText("Butter chicken")));
    }

}
