package comp3350.iRecipe.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import comp3350.iRecipe.Business.GetRecipeFromCSV;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.R;

public class MainDish extends AppCompatActivity {

    RecyclerView recyclerView_maindish;
    RecipeListInterface list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dish);

        recyclerView_maindish = findViewById(R.id.recyclerView_maindish);
        recyclerView_maindish.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_maindish.setHasFixedSize(true);


        list = new GetRecipeFromCSV(this);
        ArrayList<Recipe> recipe_list = list.getRecipesByCategory("Main dishes");

        AdapterRecipe adapter_recipe = new AdapterRecipe(recipe_list);
        recyclerView_maindish.setAdapter(adapter_recipe);

    }
}