package comp3350.iRecipe;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.Comment;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.CommentHSQLDB;
import comp3350.iRecipe.Persistence.RecipeCommentInterface;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.Presentation.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CommentAndRatingTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    Recipe testRecipe;

    @Before
    public void setUpTestRecipeAndComment(){
        RecipeListInterface list = new RecipeListHSQLDB(MainActivity.getDBPathName());

        testRecipe = new Recipe("ATestCommentRecipe", Category.getCategory("Main dishes"));
        list.addRecipe(testRecipe);

    }

    @After
    public void removeTestRecipeAndComment(){
        RecipeListInterface list = new RecipeListHSQLDB(MainActivity.getDBPathName());

        list.removeRecipe(testRecipe);
    }

    @Test
    public void testViewComment(){
        //Add a comment using database method, not by GUI
        RecipeCommentInterface commentList = new CommentHSQLDB(MainActivity.getDBPathName());
        Comment testComment = new Comment(5,"Good","Tester");
        commentList.addComments(testRecipe.getName(),testComment);

        //Get all recipe
        onView(withText("View all recipes")).perform(click());

        //Get into the Test
        onView(withText(testRecipe.getName())).perform(click());

        //Get into the comment page
        onView(withId(R.id.viewComment)).perform(click());

        onView(withId(R.id.comment)).check(matches(withText(testComment.getComment())));
        onView(withId(R.id.userName)).check(matches(withText(testComment.getUserName())));
        onView(withId(R.id.rating)).check(matches(withText("Rating: " + testComment.getRating())));
    }

    @Test
    public void testAddComment(){
        //Get all recipe
        onView(withText("View all recipes")).perform(click());

        //Get into the Test
        onView(withText(testRecipe.getName())).perform(click());

        //Get into the comment page
        onView(withId(R.id.viewComment)).perform(click());

        //Click add button
        onView(withId(R.id.commentThisRecipe)).perform(click());

        //Input through alertdialog
        onView(withHint("Your name")).perform(typeText("Tester"));
        onView(withHint("Your comment")).perform(typeText("Great"));
        onView(withText("OK")).perform(click());

        //Check to see if it is there
        onView(withId(R.id.userName)).check(matches(withText("Tester")));
        onView(withId(R.id.comment)).check(matches(withText("Great")));
        onView(withId(R.id.rating)).check(matches(withText("Rating: 0")));
    }

}
