package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.iRecipe.Business.SearchRecipe;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.R;

public class RecipeDetailActivity extends AppCompatActivity {

    RecipeListInterface list;
    Recipe recipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);



        list = new RecipeListHSQLDB(MainActivity.getDBPathName());


   Intent intent = getIntent();
        String recipeName = intent.getStringExtra("name");

        SearchRecipe searching = new SearchRecipe(list.getAllRecipes());
        recipe = searching.searchByName(recipeName);
        TextView tv = (TextView)findViewById(R.id.recipe);
        tv.setText(recipe.getName());





    }
}