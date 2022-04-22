package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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
    String searchByList[] = {"Recipe Name", "Ingredients"};

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
        String searchBy = intent.getStringExtra("searchBy");
        String searchString = intent.getStringExtra("searchString");

        TextView tv = (TextView)findViewById(R.id.titleText);


        if (category != null)        // category buttons
            recipe_list = showRecipeByCategory(category, allRecipe, tv);
        else if (searchBy != null)  // search icon button
            recipe_list = showRecipeBySearchResult(searchBy, searchString ,allRecipe, tv);


        if (recipe_list != null) {
            AdapterRecipe adapter_recipe = new AdapterRecipe(recipe_list, this);
            recyclerView_recipe.setAdapter(adapter_recipe);
        }
        else
            Toast.makeText(this, "Search By option was not selected",
                    Toast.LENGTH_LONG).show();  // show message Search drop-down menu was not selected
    }

    public ArrayList<Recipe> showRecipeByCategory(String category, ArrayList<Recipe> allRecipe, TextView tv)
    {
        ArrayList<Recipe> recipe_list;

        if(category.equalsIgnoreCase("View all recipes")){
            recipe_list = allRecipe;
            tv.setText("All Recipes");
        }else{
            recipe_list = list.getRecipesByCategory(category);
            tv.setText("All " + (category.endsWith("s")? category : (category + "s")));
        }

        return recipe_list;
    }

    public ArrayList<Recipe> showRecipeBySearchResult(String searchBy, String searchString, ArrayList<Recipe> allRecipe, TextView tv)
    {
        ArrayList<Recipe> recipe_list = null;

        if (searchBy.equalsIgnoreCase(searchByList[0]))         // search by Recipe Name
            recipe_list = list.matchByName(searchString);
        else if (searchBy.equalsIgnoreCase(searchByList[1]))    // search by Ingredients
            recipe_list = list.searchByIngredients(searchString);

        tv.setText("Search result by " + searchBy + ":\n \"" + searchString + "\"");

        return recipe_list;
    }
}