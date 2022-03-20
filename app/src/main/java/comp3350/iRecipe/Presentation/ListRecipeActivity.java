package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.iRecipe.Business.SearchRecipe;
import comp3350.iRecipe.Persistence.GetRecipeFromCSV;
import comp3350.iRecipe.Persistence.RecipeList;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.R;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListInterface;

public class ListRecipeActivity extends AppCompatActivity {

    RecyclerView recyclerView_recipe;
    RecipeListInterface list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recipe);

        recyclerView_recipe = findViewById(R.id.recyclerView_recipe);
        recyclerView_recipe.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_recipe.setHasFixedSize(true);

        list = new RecipeListHSQLDB(MainActivity.getDBPathName());
        ArrayList<Recipe> recipe_list = null;
        ArrayList<Recipe> allRecipe = list.getAllRecipes();

        Intent intent = getIntent();
        String category = intent.getStringExtra("type");
        String recipeName = intent.getStringExtra("recipeName");

        TextView tv = (TextView)findViewById(R.id.titleText);


        if(category != null){
            recipe_list = showRecipeByCategory(category, allRecipe, tv);
        }
        else if (recipeName != null)
        {
            recipe_list = showRecipeBySearchResult(recipeName,allRecipe, tv);
        }

        AdapterRecipe adapter_recipe = new AdapterRecipe(recipe_list , this);
        recyclerView_recipe.setAdapter(adapter_recipe);
    }

    public ArrayList<Recipe> showRecipeByCategory(String category, ArrayList<Recipe> allRecipe, TextView tv)
    {
        ArrayList<Recipe> recipe_list;

        if(category.equalsIgnoreCase("All")){
            recipe_list = allRecipe;
            tv.setText("All Recipes");
        }else{
            recipe_list = SearchRecipe.getRecipesByCategory(category,allRecipe);
            tv.setText("All " + category);
        }

        return recipe_list;
    }

    public ArrayList<Recipe> showRecipeBySearchResult(String recipeName, ArrayList<Recipe> allRecipe, TextView tv)
    {
        ArrayList<Recipe> recipe_list;

        recipe_list = SearchRecipe.matchByName(recipeName, allRecipe);
        tv.setText("Search result by Recipe Name: \"" + recipeName + "\"");

        return recipe_list;
    }
}