package comp3350.iRecipe;

import org.junit.Before;

import comp3350.iRecipe.Business.GetRecipeFromCSV;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListInterface;

public class RecipeTest {

    Recipe recipe;

    @Before
    public void setUp()
    {
        recipe =  new Recipe("Banana" , "snack");
    }
}
