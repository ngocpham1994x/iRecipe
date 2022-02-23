package comp3350.iRecipe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import java.util.ArrayList;


@RunWith(AndroidJUnit4.class)
public class GetRecipeFromCSVTest {

    @Rule
    public ActivityTestRule<GetRecipeFromCSV> activityRule = new ActivityTestRule<>(GetRecipeFromCSV.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addRecipe() {
    }

    @Test
    public void removeRecipe() {
    }

    @Test
    public void searchByName() {
    }

    @Test
    public void getAllRecipes() {
        GetRecipeFromCSV activity = activityRule.getActivity();
        ArrayList<Recipe> all = activity.getAllRecipes();
        assertEquals(10,all.size());
    }

    @Test
    public void getRecipesByCategory() {
    }

}