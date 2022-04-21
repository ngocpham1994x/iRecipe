package comp3350.iRecipe.Persistence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Persistence.GetRecipeFromCSV;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeList;
import comp3350.iRecipe.Persistence.RecipeListInterface;


public class RecipeListUnitTest {

    RecipeListInterface recipeList;

    @Before
    public void setUp()
    {
        recipeList = new RecipeList();
    }


    @Test
    public void addRecipe_test()
    {

        Recipe r1 = new Recipe("eggs" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("pancakes" , Category.getCategory("Main dishes"));
        Recipe r3 = new Recipe("pancakes 2" , Category.getCategory("Main dishes"));

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
    public void addRecipe_Test_Exception()
    {
        RecipeList newList = new RecipeList();
        newList.addRecipeWithException(null);

        ArrayList<Recipe> retrieved_list = newList.getAllRecipes();

        // This test shows that list contains null recipe if we add using addRecipeException ,
        // However , it shouldn't be. So, we need to check for null objects before we add anything
        // to  arrayList
        assertNull(retrieved_list.get(0));

    }


    @Test
    public void removeRecipeTest()
    {
        Recipe r1 = new Recipe("eggs" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("pancakes" , Category.getCategory("Main dishes"));

        // No recipes exists
        assertFalse("Should return False , r1 does not exists " , recipeList.removeRecipe(r1));
        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);
        assertTrue("r1 is removable , should return true" , recipeList.removeRecipe(r1));
        assertEquals(1 , recipeList.getAllRecipes().size());

        assertTrue(recipeList.removeRecipe(r2));

        assertEquals(0 , recipeList.getAllRecipes().size() );

    }



    @Test
    public void getRecipesTest()
    {
        Recipe r1 = new Recipe("eggs" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("pancakes" , Category.getCategory("Main dishes"));
        Recipe r3 = new Recipe("pancakes 2" , Category.getCategory("Main dishes"));

        recipeList.addRecipe(r1);
        recipeList.addRecipe(r2);

        assertEquals(2 , recipeList.getAllRecipes().size());
        recipeList.removeRecipe(r1);
        assertTrue(recipeList.getAllRecipes().contains(r2) && !recipeList.getAllRecipes().contains(r1));


    }







}