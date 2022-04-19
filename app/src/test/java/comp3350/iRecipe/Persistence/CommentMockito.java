package comp3350.iRecipe.Persistence;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import comp3350.iRecipe.Objects.Comment;
import comp3350.iRecipe.Objects.Recipe;


public class CommentMockito {

    CommentHSQLDB comments = mock(CommentHSQLDB.class);
    RecipeListHSQLDB recipeList = mock(RecipeListHSQLDB.class);

    @Test
    public void integrationTest()
    {
        Recipe r1 = new Recipe("Recipe1" , "Main dishes");

        recipeList.addRecipe(r1 );
        verify(recipeList).addRecipe(r1);
        Comment c1 = new Comment(5 , "Nice one ! " , "user 1");
        assertTrue(comments.addComments("Recipe1" , c1));
        verify(comments).addComments(r1.getName(), c1);
        //System.out.println(comments.getComments(r1.getName()).get(0).getUserName());



    }




}
