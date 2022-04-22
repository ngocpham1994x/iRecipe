package comp3350.iRecipe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.iRecipe.Business.SearchRecipeTest;
import comp3350.iRecipe.Objects.RecipeTest;
import comp3350.iRecipe.Persistence.CommentIT;
import comp3350.iRecipe.Persistence.CommentMockito;
import comp3350.iRecipe.Persistence.RecipeListIT;
import comp3350.iRecipe.Persistence.RecipeListUnitTest;


// will run both unit tests and integration tests
@RunWith(Suite.class)
@Suite.SuiteClasses({
        RecipeListUnitTest.class, // unit
        RecipeTest.class, // unit
        SearchRecipeTest.class, // unit
        RecipeListIT.class, // integration test
        CommentIT.class,  // integration test
        CommentMockito.class // tests using mockito library

})

public class AllTests {

}
