package comp3350.iRecipe.Presentation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

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



        //setting the database in the list
        list = new RecipeListHSQLDB(MainActivity.getDBPathName());


        // get the intent from ListRecipeActivity as a recipe name
        Intent intent = getIntent();
        String recipeName = intent.getStringExtra("name");


        // searching  the recipe from the database
        recipe = list.searchByName(recipeName);

        if(recipe != null) {

            // getting all the text box from xml file to set text according to recipe values.
            TextView name = (TextView) findViewById(R.id.recipe);
            TextView desc = (TextView) findViewById(R.id.detail_disc);
            TextView level = (TextView) findViewById(R.id.cook_level);
            TextView prep_time = (TextView) findViewById(R.id.prep_time);
            TextView cook_time = (TextView) findViewById(R.id.cook_time);
            TextView serving = (TextView) findViewById(R.id.serving);

            String level_text = "Level: " + recipe.getLevel();
            String prep_text = "Preparation Time: " + recipe.getPrepTime() + " Min";
            String cook_text = "Cooking Time: " + recipe.getCookTime() + " Min";
            String serving_text = "Serving: " + recipe.getServing();
            level.setText(level_text);
            prep_time.setText(prep_text);
            cook_time.setText(cook_text);
            serving.setText(serving_text);


            // setting an image - find the image based on the recipe name
            // if image not found - set the default image as no_image.
            ImageView image = (ImageView) findViewById(R.id.recipe_image);

            name.setText(recipe.getName());
            desc.setText(recipe.getInstruction());

            String recipe_name_with__ = recipe.getName().replace(" ", "_");
            recipe_name_with__ = recipe_name_with__.replace("-", "_");//  this is image file name
            String recipeLower = recipe_name_with__.toLowerCase();
            String PACKAGE_NAME = getApplicationContext().getPackageName();

            int recipeImg = getResources().getIdentifier(PACKAGE_NAME + ":drawable/" + recipeLower, null, null);

            if (recipeImg > 0)
                image.setImageBitmap(BitmapFactory.decodeResource(getResources(), recipeImg));
            else
                image.setImageResource(R.drawable.no_image);


            // list of ingredients
            String[] list = recipe.getIngredients().toArray(new String[0]);

            ListView ingredients_list = (ListView) findViewById(R.id.ingredients);
            ArrayAdapter<String> ingredients = new ArrayAdapter<String>(this, R.layout.listitem, list);
            ingredients_list.setAdapter(ingredients);

        }






    }
}