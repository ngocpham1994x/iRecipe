package comp3350.iRecipe.Presentation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
        String image1 = intent.getStringExtra("image");

        recipe = SearchRecipe.searchByName(recipeName,list.getAllRecipes());
        TextView name = (TextView)findViewById(R.id.recipe);
        TextView desc = (TextView)findViewById(R.id.detail_disc);
        ImageView image = (ImageView)findViewById(R.id.recipe_image);

        name.setText(recipe.getName());
        desc.setText(recipe.getInstruction());
        image.setImageDrawable(Drawable.createFromPath(String.valueOf(R.drawable.round_cocktail)));





    }
}