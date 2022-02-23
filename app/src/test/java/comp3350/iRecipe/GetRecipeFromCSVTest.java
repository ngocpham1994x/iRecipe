package comp3350.iRecipe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GetRecipeFromCSVTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRecipe() {
        //GetRecipeFromCSV read = new GetRecipeFromCSV();
        ArrayList<Recipe> allRecipe = GetRecipeFromCSV.getRecipe();
        assertEquals(10,allRecipe.size());
    }
}