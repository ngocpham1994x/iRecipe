package comp3350.iRecipe.Persistence;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


import comp3350.iRecipe.CopyDB;
import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.Comment;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Presentation.MainActivity;

public class CommentIT {

    private RecipeListInterface list;
    private CommentHSQLDB comment_list;

    private File temp_Database;


    @Before
    public void setUp() throws IOException
    {
        this.temp_Database = CopyDB.copy_real_db();
        MainActivity.setDBPathName(this.temp_Database.getAbsolutePath().replace(".script" , ""));
        list = new RecipeListHSQLDB(MainActivity.getDBPathName());
        comment_list = new CommentHSQLDB(MainActivity.getDBPathName());

    }

    @Test
    public void testAddComments()
    {
        Recipe r1 = new Recipe("recipe 1" , Category.getCategory("Main dishes"));
        assertTrue(list.addRecipe(r1));
        Comment c1 = new Comment(4 , "nice recipe !" , "me");

        // adding comment to an existing recipe
        assertTrue(comment_list.addComments("recipe 1" , c1));

        // adding comment to a non existing recipe
        assertFalse(comment_list.addComments("recipe 2" , c1));

        // should not add the same comment twice
        assertFalse(comment_list.addComments("recipe 1" , c1));

    }

    @Test
    public void testGetComments()
    {
        Recipe r1 = new Recipe("recipe 1" , Category.getCategory("Main dishes"));
        assertTrue(list.addRecipe(r1));
        Comment c1 = new Comment(4 , "nice recipe !" , "user 1");
        Comment c2 = new Comment(5 ,  "Awesome" , "user 1");
        Comment c3 = new Comment(5 ,  "Awesome" , "user 2");


        assertTrue(comment_list.addComments("recipe 1" , c1));
        assertTrue(comment_list.addComments("recipe 1" , c3));

        // same user is not allowed to comment and rate twice for the same recipe
        assertFalse(comment_list.addComments("recipe 1" , c2));

        assertEquals(2 , comment_list.getComments("recipe 1").size());
        assertEquals("user 1" , comment_list.getComments("recipe 1").get(0).getUserName());
        assertEquals("user 2" , comment_list.getComments("recipe 1").get(1).getUserName());




    }


    @After
    public void tearDown() throws IOException
    {
        this.temp_Database.delete();

    }
}
