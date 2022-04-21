package comp3350.iRecipe.Business;

import static org.junit.Assert.*;

import android.util.Log;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.iRecipe.Business.SearchRecipe;
import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeList;
import comp3350.iRecipe.Persistence.RecipeListInterface;

public class SearchRecipeTest {


    private RecipeListInterface recipeList;

    @Before
    public void setUp()
    {
        recipeList = new RecipeList();


    }


    @Test
    public void searchByNameTest()
    {
        Recipe r1 = new Recipe("eggs" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("pancakes" , Category.getCategory("Main dishes"));

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);

         //typical test , returns the recipe
        assertEquals(r1 , recipeList.searchByName("eggs"));

        // case sensitivity test - should not ignore case
        assertEquals(r1 , recipeList.searchByName("Eggs"));

        assertNotNull(recipeList.searchByName("Pancakes"));
    }

    @Test
    public void getRecipesByCategoryTest()
    {
        Recipe r1 = new Recipe("eggs" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("pancakes" , Category.getCategory("Main dishes"));
        Recipe r3 = new Recipe("Soup" , Category.getCategory("Soup"));

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        recipeList.addRecipe(r3);

        ArrayList<Recipe> category_list_2 = recipeList.getRecipesByCategory("Main dishes");
        assertEquals(2 , category_list_2.size());
        assertTrue(category_list_2.contains(r1) && !category_list_2.contains(r3));
    }

    @Test
    public void searchByIngredientTest()
    {
        Recipe r1 = new Recipe("eggs" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("pancakes" , Category.getCategory("Main dishes"));
        Recipe r3 = new Recipe("pancakes 2" , Category.getCategory("Main dishes"));

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        recipeList.addRecipe(r3);

        r1.addToKeyIngredients("item 1");
        r2.addToKeyIngredients("item 2");
        r1.addToKeyIngredients("item 2");
        r3.addToIngredients("item 2");

        ArrayList<Recipe> listByIngredient = recipeList.searchByIngredients("Item 2");
        assertEquals(2 , listByIngredient.size());

        // Item 2 is not key ingredient in r3
        assertFalse(listByIngredient.contains(r3));
    }

    @Test
    public void matchByNameTest()
    {
        //Just some dummy Recipe to test
        Recipe r1 = new Recipe("Test 1" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("2 Test 2" , Category.getCategory("Main dishes"));
        Recipe r3 = new Recipe("3 Test" , Category.getCategory("Main dishes"));
        Recipe r4 = new Recipe("44Test44" , Category.getCategory("Main dishes"));

        //Should return 0 because no recipe is called Test and we haven't add them
        ArrayList<Recipe> matchName_0 = SearchRecipe.matchByName("Test", recipeList.getAllRecipes());
        assertEquals(0,matchName_0.size());

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        recipeList.addRecipe(r3);
        recipeList.addRecipe(r4);

        //Should contain the upper four of them
        ArrayList<Recipe> matchName_1 = recipeList.matchByName("Test");
        assertEquals(4,matchName_1.size());

        //Should still return 4, Case insensitive
        ArrayList<Recipe> matchName_2 = recipeList.matchByName("TEST");
        assertEquals(4,matchName_2.size());

        //Should still return 4, Even with just a part of the String
        ArrayList<Recipe> matchName_3 = recipeList.matchByName("TES");
        assertEquals(4,matchName_3.size());

    }
}
