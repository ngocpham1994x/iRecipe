package comp3350.iRecipe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;




@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddNewRecipeTest.class,
        CommentAndRatingTest.class,
        GetRecipeFromCSVTest.class,
        ListAllRecipeTest.class,
        RecipeDetailTest.class,
        SearchTest.class
})

public class AllSystemTests {

}
