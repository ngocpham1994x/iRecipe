package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.iRecipe.Business.SearchRecipe;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.R;

public class RecipeDetailActivity extends AppCompatActivity {

    RecipeListInterface list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        list = new RecipeListHSQLDB(MainActivity.getDBPathName());


        Intent intent = getIntent();
        String recipeName = intent.getStringExtra("name");



        TextView tv = (TextView)findViewById(R.id.editTextTextPersonName);
        tv.setText(recipeName);
    }
}