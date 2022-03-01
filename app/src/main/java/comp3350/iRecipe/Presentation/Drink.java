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

public class Drink extends AppCompatActivity {

    RecyclerView recyclerView_drink;
    RecipeListInterface list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        recyclerView_drink = findViewById(R.id.recyclerView_drink);
        recyclerView_drink.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_drink.setHasFixedSize(true);


        list = new GetRecipeFromCSV(this);
        ArrayList<Recipe> recipe_list = list.getRecipesByCategory("Drink");

        AdapterRecipe adapter_recipe = new AdapterRecipe(recipe_list);
        recyclerView_drink.setAdapter(adapter_recipe);
    }
}