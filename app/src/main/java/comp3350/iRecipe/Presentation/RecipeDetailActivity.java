package comp3350.iRecipe.Presentation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
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



        list = new RecipeListHSQLDB(MainActivity.getDBPathName());


        Intent intent = getIntent();
        String recipeName = intent.getStringExtra("name");

        final int[] image_array = {R.drawable.app_icon,R.drawable.round_cocktail ,
                                    R.drawable.round_fish , R.drawable.round_spaguetti};


        recipe = SearchRecipe.searchByName(recipeName,list.getAllRecipes());
        TextView name = (TextView)findViewById(R.id.recipe);
        TextView desc = (TextView)findViewById(R.id.detail_disc);
        ImageView image = (ImageView)findViewById(R.id.recipe_image);

        name.setText(recipe.getName());
        desc.setText(recipe.getInstruction());

//        Random random_index = new Random();
//        if(recipe.get_image_code() != -1)
//            image.setImageResource(image_array[random_index.nextInt(4)]);
//        else
//            image.setImageResource(R.drawable.no_image);



        String fmn = recipe.getName().replace(" ", "_"); //  this is image file name
        String fmn2 = fmn.toLowerCase();
        Log.e(fmn2 , "DONE!");
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+ fmn2 , null, null);
        System.out.println("IMG ID :: "+imgId);
        System.out.println("PACKAGE_NAME :: "+PACKAGE_NAME);
        //     Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imgId);
        image.setImageBitmap(BitmapFactory.decodeResource(getResources(),imgId));




    }
}