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

        // typical cases
        assertTrue(recipeList.addRecipe(r1));
        assertTrue(recipeList.addRecipe(r2));
        assertTrue(recipeList.addRecipe(r3));

        // will allow duplicate recipes because everyone can add their own choice of recipes
        assertTrue(recipeList.addRecipe(r1));

        assertEquals(recipeList.getAllRecipes().size() , 4);
        assertTrue(recipeList.getAllRecipes().contains(r1));

    }

    @Test
    public void removeRecipeTest()
    {
        Recipe r1 = new Recipe("eggs" , "breakfast");
        Recipe r2 = new Recipe("pancakes" , "dinner");

        // No recipes exists
        assertFalse("Should return False , r1 does not exists " , recipeList.removeRecipe(r1));
        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        assertTrue("r1 is removable , should return true" , recipeList.removeRecipe(r1));
        assertEquals(1 , recipeList.getAllRecipes().size());

        assertTrue(recipeList.removeRecipe(r2));

        assertEquals(0 , recipeList.getAllRecipes().size() );

    }



}