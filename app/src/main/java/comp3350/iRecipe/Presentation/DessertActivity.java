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

public class DessertActivity extends AppCompatActivity {
    
    RecyclerView recyclerView_dessert;
    RecipeListInterface list;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

        recyclerView_dessert = findViewById(R.id.recyclerView_dessert);
        recyclerView_dessert.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_dessert.setHasFixedSize(true);


        list = new GetRecipeFromCSV(this);
        ArrayList<Recipe> recipe_list = list.getRecipesByCategory("Dessert");

        AdapterRecipe adapter_recipe = new AdapterRecipe(recipe_list);
        recyclerView_dessert.setAdapter(adapter_recipe);
    }
}