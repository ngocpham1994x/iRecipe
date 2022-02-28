package comp3350.iRecipe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.iRecipe.Business.GetRecipeFromCSV;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListInterface;


public class RecipeListUnitTest {

    RecipeListInterface recipeList;

    @Before
    public void setUp()
    {
        recipeList = new GetRecipeFromCSV();
    }


    @Test
    public void addRecipe_test()
    {

        Recipe r1 = new Recipe("eggs" , "breakfast");
        Recipe r2 = new Recipe("pancakes" , "dinner");
        Recipe r3 = new Recipe("pancakes 2" , "breakfast");
        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        recipeList.addRecipe(r3);

        ArrayList<Recipe> categoryList = recipeList.getRecipesByCategory("breakfast");

        assertEquals(r1 , recipeList.searchByName("eggs"));
        assertTrue(categoryList.contains(r1));
        assertTrue(categoryList.contains(r3));
        assertFalse(categoryList.contains(r2));
    }


}