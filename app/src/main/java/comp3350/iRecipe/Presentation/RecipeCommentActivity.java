package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Comment;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.CommentHSQLDB;
import comp3350.iRecipe.Persistence.RecipeCommentInterface;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.R;

public class RecipeCommentActivity extends AppCompatActivity {

    RecipeListInterface list;
    RecipeCommentInterface commentList;
    RecyclerView recyclerView_comment;
    static int MAXRATING = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_comment);

        recyclerView_comment = findViewById(R.id.recyclerView_comment);
        recyclerView_comment.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_comment.setHasFixedSize(true);

        list = new RecipeListHSQLDB(MainActivity.getDBPathName());
        commentList = new CommentHSQLDB(MainActivity.getDBPathName());

        Intent intent = getIntent();
        String recipeName = intent.getStringExtra("name");

        ArrayList<Comment> comments = commentList.getComments(recipeName);

        int rating = 0;
        for(int i=0; i<comments.size(); i++){
            rating += comments.get(i).getRating();
        }
        float ratingResult = rating;
        if(comments.size() != 0){
            ratingResult = ratingResult / comments.size();
        }

        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar);
        bar.setNumStars(MAXRATING);
        bar.setRating(ratingResult);


        TextView name = (TextView) findViewById(R.id.recipe);
        name.setText(recipeName);

        AdapterComment adapter = new AdapterComment(comments,this);
        recyclerView_comment.setAdapter(adapter);
    }
}