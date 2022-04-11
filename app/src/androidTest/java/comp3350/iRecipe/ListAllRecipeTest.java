package comp3350.iRecipe;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import comp3350.iRecipe.Presentation.MainActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.support.test.rule.ActivityTestRule;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListAllRecipeTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyListOfReciped(){
        //select the view all recipe card 
        onView(withText("View all recipes")).perform(click());
    }

}
