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

import comp3350.iRecipe.Business.GetRecipeFromCSV;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Presentation.DummyActivity;


@RunWith(AndroidJUnit4.class)
public class GetRecipeFromCSVTest {

    GetRecipeFromCSV recipeGetter;

    @Rule
    public ActivityTestRule<DummyActivity> activityRule = new ActivityTestRule<>(DummyActivity.class);

    @Before
    public void setUp() throws Exception {
        recipeGetter = new GetRecipeFromCSV(activityRule.getActivity());
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
        //There are 10 default recipe in the CSV file, so it should be equal to size 10 after we get all recipe for the first time.
        //If you added any other recipe before this test, it might fail!
        ArrayList<Recipe> all = recipeGetter.getAllRecipes();
        assertEquals(10,all.size());
    }

    @Test
    public void getRecipesByCategory() {
    }

}