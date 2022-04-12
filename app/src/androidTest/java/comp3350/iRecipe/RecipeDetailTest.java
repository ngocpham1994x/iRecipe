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
public class RecipeDetailTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void verifyRecipeDetailEntirely() {

        //clicking on View all recipe card on the main screen
        onView(withText("View all recipes")).perform(click());

        // clicking on banana pancake recipe on the second screen
        onView(withText("Banana Pancakes")).perform(click());

        // confirming all the details about that recipe and matching them with the expectations
        onView(withId(R.id.recipe)).check(matches(withText("Banana Pancakes")));
        onView(withId(R.id.cook_level)).check(matches(withText("Level: Easy")));
        onView(withId(R.id.serving)).check(matches(withText("Serving: 4")));
        onView(withId(R.id.cook_time)).check(matches(withText("Cooking Time: 20 Min")));
        onView(withId(R.id.prep_time)).check(matches(withText("Preparation Time: 5 Min")));


    }

    @Test
    public void verifyRecipeDetailEntirely2() {

        // Testing second recipe to check the data we get is specific  and unique to each recipe
        onView(withText("Main dishes")).perform(click());
        onView(withText("Lasagna Flatbread")).perform(click());
        onView(withId(R.id.recipe)).check(matches(withText("Lasagna Flatbread")));
        onView(withId(R.id.cook_level)).check(matches(withText("Level: Easy")));
        onView(withId(R.id.serving)).check(matches(withText("Serving: 6")));
        onView(withId(R.id.cook_time)).check(matches(withText("Cooking Time: 15 Min")));
        onView(withId(R.id.prep_time)).check(matches(withText("Preparation Time: 25 Min")));


    }





}


