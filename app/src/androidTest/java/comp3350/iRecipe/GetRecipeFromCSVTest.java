package comp3350.iRecipe;

import static org.junit.Assert.assertEquals;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeList;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.Presentation.MainActivity;


@RunWith(AndroidJUnit4.class)
public class GetRecipeFromCSVTest {

    RecipeListInterface recipeGetter;
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        recipeGetter = new RecipeList(activityRule.getActivity());
    }

    @Test
    public void getAllRecipes() {
        //There are 10 default recipe in the CSV file, so it should be equal to size 10 after we get all recipe for the first time.
        //If you added any other recipe before this test, it might fail!
        ArrayList<Recipe> all = recipeGetter.getAllRecipes();
        assertEquals(10,all.size());
    }



}