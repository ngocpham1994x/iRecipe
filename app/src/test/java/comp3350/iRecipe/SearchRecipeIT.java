package comp3350.iRecipe;

import static org.junit.Assert.assertEquals;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import comp3350.iRecipe.Application.Main;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.Presentation.MainActivity;

public class SearchRecipeIT {

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
    public void test_1()
    {
        ArrayList<Recipe> all = list.getAllRecipes();
        assertEquals(10,all.size());
    }

    @After
    public void tearDown()
    {
        this.temp_Database.delete();
    }











}
