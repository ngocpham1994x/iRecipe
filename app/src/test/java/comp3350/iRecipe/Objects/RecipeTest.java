package comp3350.iRecipe.Objects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Recipe;

public class RecipeTest {

    Recipe recipe;

    @Before
    public void setUp()
    {
        ArrayList<String> ingredients = new ArrayList<>();
        ArrayList<String> kIngredients = new ArrayList<>();
        ingredients.add("eggs");
        kIngredients.add("eggs");
        recipe = new Recipe("1 Boiled egg" , Category.getCategory("Main dishes") , CookingLevel.getCookingLevel("Easy") , 1 , 20 , 1 , ingredients , kIngredients , "Boil water and then eggs");
    }

    @Test
    public void TestGetters()
    {

        assertEquals(recipe.getCategory() , "Main dishes");
        assertEquals(recipe.getLevel() , "Easy");
        assertEquals(recipe.getPrepTime() , 1);
        assertEquals(recipe.getCookTime() , 20);
        assertEquals(recipe.getServing() , 1);


    }

    @Test
    public void addIngredientsTest()
    {
        recipe.addToIngredients("item 1");
        assertTrue(recipe.getIngredients().contains("item 1") && !recipe.getKeyIngredients().contains("item 1"));

        recipe.addToKeyIngredients("Main item");
        assertTrue(recipe.getKeyIngredients().contains("Main item") && !recipe.getIngredients().contains("Main item") );
    }



}
