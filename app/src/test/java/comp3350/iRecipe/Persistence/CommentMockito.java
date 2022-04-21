package comp3350.iRecipe.Persistence;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.Comment;
import comp3350.iRecipe.Objects.Recipe;


public class CommentMockito {

    RecipeCommentInterface commentGetter;
    RecipeListInterface recipeGetter;

    @Before
    public void setup(){
        commentGetter = mock(RecipeCommentInterface.class);
        recipeGetter = mock(RecipeListInterface.class);
    }

    // tests using mockito libraries
    @Test
    public void integrationTest()
    {
        String recipeName = "Recipe1";
        ArrayList<Recipe> recipeList = new ArrayList<>();

        //Test for the recipe
        Recipe r1;
        recipeList.add(new Recipe(recipeName , Category.getCategory("Main dishes")));
        when(recipeGetter.searchByName(recipeName)).thenReturn(recipeList.get(0));

        r1 = recipeGetter.searchByName(recipeName);
        assertTrue(recipeName.equals(r1.getName()));

        verify(recipeGetter).searchByName(recipeName);

        String userName = "Tester";
        int rating = 5;
        String myComment = "Great";
        Comment comment;
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(new Comment(5,"Great","Tester"));
        when(commentGetter.getComments(recipeName)).thenReturn(comments);

        comment = commentGetter.getComments(recipeName).get(0);

        assertTrue(comment.getUserName().equals(userName));
        assertTrue(comment.getRating() == rating);
        assertTrue(comment.getComment().equals(myComment));

        verify(commentGetter).getComments(recipeName);
    }




}
