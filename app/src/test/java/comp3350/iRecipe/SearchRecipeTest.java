package comp3350.iRecipe;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.iRecipe.Business.SearchRecipe;
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
        Recipe r1 = new Recipe("eggs" , "breakfast");
        Recipe r2 = new Recipe("pancakes" , "dinner");

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);

         //typical test , returns the recipe
        assertEquals(r1 ,  SearchRecipe.searchByName("eggs" , recipeList.getAllRecipes()));

        // case sensitivity test - should ignore case
        assertEquals(r1 , SearchRecipe.searchByName("Eggs" , recipeList.getAllRecipes()));

        assertNotNull(SearchRecipe.searchByName("Pancakes" , recipeList.getAllRecipes()));
    }

    @Test
    public void getRecipesByCategoryTest()
    {
        Recipe r1 = new Recipe("eggs" , "breakfast");
        Recipe r2 = new Recipe("pancakes" , "dinner");
        Recipe r3 = new Recipe("pancakes 2" , "breakfast");

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        recipeList.addRecipe(r3);

        ArrayList<Recipe> category_list = SearchRecipe.getRecipesByCategory("Main dishes" , recipeList.getAllRecipes());
        assertEquals(0 , category_list.size());

        ArrayList<Recipe> category_list_2 = SearchRecipe.getRecipesByCategory("Breakfast" , recipeList.getAllRecipes());
        assertEquals(2 , category_list_2.size());
        assertTrue(category_list_2.contains(r1) && !category_list_2.contains(r2));
    }

    @Test
    public void searchByIngredientTest()
    {
        Recipe r1 = new Recipe("eggs" , "breakfast");
        Recipe r2 = new Recipe("pancakes" , "dinner");
        Recipe r3 = new Recipe("pancakes 2" , "breakfast");

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        recipeList.addRecipe(r3);

        r1.addToKeyIngredients("item 1");
        r2.addToKeyIngredients("item 2");
        r1.addToKeyIngredients("item 2");
        r3.addToIngredients("item 2");

        ArrayList<Recipe> listByIngredient = SearchRecipe.searchByIngredients("Item 2" , recipeList.getAllRecipes());
        assertEquals(2 , listByIngredient.size());

        // Item 2 is not key ingredient in r3
        assertFalse(listByIngredient.contains(r3));
    }
}
