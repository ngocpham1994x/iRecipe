package comp3350.iRecipe.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.CookingLevel;
import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.R;

public class AddRecipeActivity extends AppCompatActivity implements OnItemSelectedListener {
    //variables for the recipe object
    String recipeName, category, level;
    int prepTime, cookTime, serving;
    String ingredients, keyIng, instructions;

    //variables for reading from the input
    EditText recipeNameIn, categoryIn, levelIn, prepTimeIn, cookTimeIn, servingIn, ingredientsIn, keyIngIn, instructionsIn;

    //other variables for button, spinners and arrays for populating spinner
    Button button;
    Spinner categorySelector , levelSelector;
    String[] categoryArray, levelArray;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        recipeNameIn = findViewById(R.id.recipeName);

        /**Spinner for categories*/
        categoryArray = getResources().getStringArray(R.array.categories);
        categorySelector = findViewById(R.id.recipeCategory);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        categorySelector.setAdapter(adapter);
        categorySelector.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                category = (String) adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){}
        });

        /**Spinner for levels*/
        levelArray = getResources().getStringArray(R.array.levels);
        levelSelector = findViewById(R.id.recipeLevel);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.levels, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSelector.setAdapter(adapter2);
        levelSelector.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                level = (String) adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        prepTimeIn = findViewById(R.id.prep_time);
        cookTimeIn = findViewById(R.id.cook_time);
        servingIn = findViewById(R.id.servings);
        ingredientsIn = findViewById(R.id.ingredients);
        keyIngIn = findViewById(R.id.keyIng);
        instructionsIn = findViewById(R.id.instructions);

        button = findViewById(R.id.submitRecipe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipeName = recipeNameIn.getText().toString();
                try {
                    prepTime = Integer.parseInt(prepTimeIn.getText().toString());
                    cookTime = Integer.parseInt(cookTimeIn.getText().toString());
                    serving = Integer.parseInt(servingIn.getText().toString());


                    ingredients = ingredientsIn.getText().toString();
                    keyIng = keyIngIn.getText().toString();
                    instructions = instructionsIn.getText().toString();

                    String[] ingredTokens = ingredients.split(",");
                    ArrayList<String> ingred = new ArrayList<>(Arrays.asList(ingredTokens));
                    for(int i=0; i<ingred.size(); i++){
                        ingred.set(i, ingred.get(i).trim());
                    }

                    String[] keyTokens = keyIng.split(",");
                    ArrayList<String> key = new ArrayList<>(Arrays.asList(keyTokens));
                    for(int i=0; i<key.size(); i++){
                        key.set(i, key.get(i).trim());
                    }

                    Recipe newR = new Recipe(recipeName, Category.getCategory(category), CookingLevel.getCookingLevel(level), prepTime, cookTime, serving, ingred, key, instructions);
                    boolean added = addRecipe(newR);
                    Intent intent;
                    if (!added) {
                        CharSequence c = "A recipe with this name exists already! Try adding another.";
                        Toast.makeText(getApplicationContext(), c, Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), AddRecipeActivity.class);
                    } else {
                        CharSequence c = "Recipe added!";
                        Toast.makeText(getApplicationContext(), c, Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                    }
                    startActivity(intent);
                    finish();
                }
                catch(Exception e)
                {
                    CharSequence c = "Didn't enter valid PrepTime, CookTime or Serving Data";
                    Toast.makeText(getApplicationContext(), c , Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){}

    public void onNothingSelected(AdapterView<?> parent){}

    public boolean addRecipe(Recipe r){
        RecipeListInterface rl = new RecipeListHSQLDB(MainActivity.getDBPathName());
        return rl.addRecipe(r);
    }
}
