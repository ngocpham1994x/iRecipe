package comp3350.iRecipe.Persistence;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Comment;

public interface RecipeCommentInterface {

    public ArrayList<Comment> getComments(String recipeName);

    public boolean addComments(String recipeName, Comment comment);


}
