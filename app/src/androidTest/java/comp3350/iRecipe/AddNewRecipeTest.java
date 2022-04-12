package comp3350.iRecipe;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
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
public class AddNewRecipeTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void add(){
        //click on add button on main activity page
        onView(withId(R.id.addButton)).perform(click());
        //recipe name
        onView(withId(R.id.recipeName)).perform(typeText("Tune patties"));
        //dropdown for category
        onView(withId(R.id.recipeCategory)).perform(click());
        onView(withText("Main Dishes")).inRoot(isPlatformPopup()).perform(click());
        //dropdown for level of recipe
        onView(withId(R.id.recipeLevel)).perform(click());
        onView(withText("Medium")).inRoot(isPlatformPopup()).perform(click());

        //enter prep time
        onView(withId(R.id.prep_time)).perform(typeText("20"));
        //enter cooking itme
        onView(withId(R.id.cook_time)).perform(typeText("20"));
        //number of serving
        onView(withId(R.id.servings)).perform(typeText("2"));
        //ingredients of recipe
        onView(withId(R.id.ingredients)).perform(scrollTo(),typeText("tuna, egg, lemon"));
        //key ingredients
       onView(withId(R.id.keyIng)).perform(scrollTo(),typeText("tuna"));
        //instructions
       onView(withId(R.id.instructions)).perform(scrollTo(),typeText("Beat eggs and lemon juice in a bowl; stir in Parmesan cheese and bread crumbs to make a paste. Fold in tuna and onion until well-mixed. Season with black pepper. Shape tuna mixture into eight 1-inch-thick patties"));
       closeSoftKeyboard();
        //button to submit
        onView(withId(R.id.submitRecipe)).perform(scrollTo(),click());
    }
}
