package comp3350.iRecipe.Persistence;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Locale;


import comp3350.iRecipe.CopyDB;
import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.Recipe;

import comp3350.iRecipe.Presentation.MainActivity;

public class RecipeListIT {

    private RecipeListInterface list;
    private File temp_Database;


    @Before
    public void setUp() throws IOException
    {
        this.temp_Database = CopyDB.copy_real_db();
        MainActivity.setDBPathName(this.temp_Database.getAbsolutePath().replace(".script" , ""));
        list = new RecipeListHSQLDB(MainActivity.getDBPathName());

    }

    @Test
    public void test_getRecipes()
    {
        ArrayList<Recipe> all = list.getAllRecipes();
        assertEquals(10,all.size());
    }

    @Test
    public void testAddRecipe()
    {
        // adding a valid recipe.
        Recipe r1 = new Recipe("recipe 1" , Category.getCategory("Main dishes"));
        assertTrue(list.addRecipe(r1));
        assertEquals(11 , list.getAllRecipes().size());
        assertNotNull(list.searchByName("recipe 1"));
        assertTrue(list.addRecipe(new Recipe("" , Category.getCategory("Main dishes"))));

        // adding not a valid recipe - duplicate recipe
        assertFalse(list.addRecipe(r1));



    }

    @Test
    public void testDeleteRecipe()
    {
        // adding a recipe to test delete
        Recipe r1 = new Recipe("recipe 1" , Category.getCategory("Main dishes"));
        assertTrue(list.addRecipe(r1));
        assertEquals(11 , list.getAllRecipes().size());

        // deleting an existing recipe should return true
        assertTrue(list.removeRecipe(r1));
        assertEquals(10 , list.getAllRecipes().size());
        assertFalse(list.getAllRecipes().contains(r1));


    }

    @Test
    public void testSearchByName()
    {
        Recipe r1 = new Recipe("RECIPE 1" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("recipe 1" , Category.getCategory("Main dishes"));

          assertTrue(list.addRecipe(r1));
          assertFalse(list.addRecipe(r2));


          assertEquals("RECIPE 1" , list.searchByName("RECIPE 1").getName());
          assertEquals("RECIPE 1" , list.searchByName("recipe 1").getName());
    }

    @Test
    public void testMatchByName()
    {

        Recipe r1 = new Recipe("RECIPE 1" , Category.getCategory("Main dishes"));
        Recipe r2 = new Recipe("RECIPE 2" , Category.getCategory("Main dishes"));
        assertTrue(list.addRecipe(r1));
        assertTrue(list.removeRecipe(r1));

        assertTrue(list.addRecipe(r1));
        assertEquals("RECIPE 1" , list.matchByName("RECIPE").get(0).getName());
        assertEquals("RECIPE 1" , list.matchByName("recipe").get(0).getName());
        assertEquals("RECIPE 1" , list.matchByName("ecipe").get(0).getName());
        assertEquals("RECIPE 1" , list.matchByName("1").get(0).getName());

        assertTrue(list.addRecipe(r2));

        assertEquals(2 , list.matchByName("recipe").size());
        assertNotEquals(2 , list.matchByName("recipe 1").size());

    }

    @Test
    public void testSearchByCategory_Ingredients()
    {
        // ignore case
        ArrayList<Recipe> list_category = list.getRecipesByCategory("Main Dishes");
        ArrayList<Recipe> list_ingredients = list.searchByIngredients("egg");

        int i = 0;
        while( i < list_category.size() )
        {
            // used lower case , so it ignore case while comparing.
            assertEquals("Main Dishes".toLowerCase(Locale.ROOT) , list_category.get(i).getCategory().toLowerCase(Locale.ROOT));
            i++;
        }

        i = 0;
        while( i < list_ingredients.size() )
        {
            // used lower case , so it ignore case while comparing.
            assertTrue(list_ingredients.get(i).getKeyIngredients().contains("Egg"));
            i++;
        }

        System.out.println(list_ingredients.size());
    }



    @After
    public void tearDown() throws IOException
    {
        this.temp_Database.delete();

    }











}

