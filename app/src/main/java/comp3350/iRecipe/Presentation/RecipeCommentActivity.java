package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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
    String recipeName;
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
        recipeName = intent.getStringExtra("name");

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

        Button myButton = (Button) findViewById(R.id.commentThisRecipe);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(RecipeCommentActivity.this);
                builder.setTitle("Rate and Comment!");

                // Set up the input
                EditText nameInput = new EditText(RecipeCommentActivity.this);
                RatingBar myBar = new RatingBar(RecipeCommentActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                myBar.setLayoutParams(lp);
                myBar.setNumStars(MAXRATING);
                myBar.setStepSize(1);

                nameInput.setLayoutParams(lp);
                final EditText commentInput = new EditText(RecipeCommentActivity.this);


                LinearLayout layout = new LinearLayout(RecipeCommentActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                nameInput.setInputType(InputType.TYPE_CLASS_TEXT);
                nameInput.setHint("Your name");
                commentInput.setSingleLine(false);
                commentInput.setHint("Your comment");
                commentInput.setLayoutParams(lp);


                layout.addView(nameInput);
                layout.addView(myBar);
                layout.addView(commentInput);

                builder.setView(layout);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = nameInput.getText().toString();
                        int value = (int)myBar.getRating();
                        String comment = commentInput.getText().toString();

                        if( !commentList.addComments(recipeName, new Comment(value,comment,name)) ){
                            CharSequence c = "You already made comment and rating to this Recipe!";
                            Toast.makeText(getApplicationContext(), c, Toast.LENGTH_LONG).show();
                        }else{
                            CharSequence c = "Comment added!";
                            Toast.makeText(getApplicationContext(), c, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), RecipeCommentActivity.class);
                            intent.putExtra("name",recipeName);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }


}