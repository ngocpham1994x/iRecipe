package comp3350.iRecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListRecipe extends AppCompatActivity {

    RecyclerView recyclerView_recipe;
    List<String> recipe_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recipe);

//        recyclerView_recipe = findViewById(R.id.recyclerView_recipe);
//        recyclerView_recipe.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView_recipe.setHasFixedSize(true);
//        AdapterRecipe adapter_recipe = new AdapterRecipe(recipe_list);
//        recyclerView_recipe.setAdapter(adapter_recipe);
//
//
//
//        recipe_list = new ArrayList<>();
//        recipe_list.add("recipe1");
//        recipe_list.add("recipe2");
    }
}