package comp3350.iRecipe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.iRecipe.Business.SearchRecipeTest;
import comp3350.iRecipe.Objects.RecipeTest;
import comp3350.iRecipe.Persistence.CommentIT;
import comp3350.iRecipe.Persistence.RecipeListIT;
import comp3350.iRecipe.Persistence.RecipeListUnitTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        RecipeListIT.class,
        CommentIT.class
})

public class IntegrationTests {

}
