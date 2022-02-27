package comp3350.iRecipe;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import comp3350.iRecipe.Business.RecipeList;
import comp3350.iRecipe.Objects.Recipe;


public class RecipeListUnitTest {


    @Test
    public void addRecipe_test()
    {
        RecipeList r_list = new RecipeList();
        Recipe r1 = new Recipe("eggs" , "breakfast");
        Recipe r2 = new Recipe("pancakes" , "dinner");
        Recipe r3 = new Recipe("pancakes 2" , "breakfast");
        r_list.addRecipe(r1);
        r_list.addRecipe(r2);
        r_list.addRecipe(r3);

        ArrayList<Recipe> categoryList = r_list.getRecipesByCategory("breakfast");

        assertEquals(r1 , r_list.searchByName("eggs"));
        assertTrue(categoryList.contains(r1));
        assertTrue(categoryList.contains(r3));
        assertFalse(categoryList.contains(r2));
    }


}