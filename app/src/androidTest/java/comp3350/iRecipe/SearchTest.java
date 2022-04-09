package comp3350.iRecipe;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.iRecipe.Presentation.MainActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SearchTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private String testRecipeName = "banana";

    @Test
    public void verifySearchResult()
    {
        // select dropdown menu
        onView(withId(R.id.auto_complete_txt)).perform(click());

        // select searchBy "Recipe Name" option
        onView(withText("Recipe Name"))
                .inRoot(isPlatformPopup())
                .perform(click());

        // type in "banana"
        onView(withId(R.id.searchText)).perform(typeText(testRecipeName));

        // click on search icon
        onView(withId(R.id.search_icon)).perform(click());

        closeSoftKeyboard();

        // verify matching
        onView(withId(R.id.card_recipe)).perform(click());
        onView(withId(R.id.recipe)).check(matches(withText("Banana Pancakes")));
    }

}
