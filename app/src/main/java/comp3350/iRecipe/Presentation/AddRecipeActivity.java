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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListHSQLDB;
import comp3350.iRecipe.Persistence.RecipeListInterface;
import comp3350.iRecipe.R;

public class AddRecipeActivity extends AppCompatActivity implements OnItemSelectedListener {
    String recipeName, category, level;
    int prepTime, cookTime, serving;
    String ingredients, keyIng, instructions;

    EditText rName, cat, lev, pt, ct, serv, ingr, key, instr;

    Button button;
    Spinner one , two;
    String[] cats, levs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        rName = findViewById(R.id.recipeName);

        /**Spinner for categories*/
        cats = getResources().getStringArray(R.array.categories);
        one = findViewById(R.id.recipeCategory);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        one.setAdapter(adapter);
        one.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                category = (String) adapterView.getItemAtPosition(pos);
                if(pos>0){
                    Toast.makeText(adapterView.getContext(), (CharSequence) cat, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /**Spinner for levels*/
        levs = getResources().getStringArray(R.array.levels);
        two = findViewById(R.id.recipeLevel);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.levels, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        two.setAdapter(adapter2);
        two.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                level = (String) adapterView.getItemAtPosition(pos);
                if(pos>0) {
                    Toast.makeText(adapterView.getContext(), (CharSequence) lev, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pt = findViewById(R.id.prep_time);
        ct = findViewById(R.id.cook_time);
        serv = findViewById(R.id.servings);
        ingr = findViewById(R.id.ingredients);
        key = findViewById(R.id.keyIng);
        instr = findViewById(R.id.instructions);

        button = findViewById(R.id.submitRecipe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipeName = rName.getText().toString();
                prepTime = Integer.parseInt(pt.getText().toString());
                cookTime = Integer.parseInt(ct.getText().toString());
                serving = Integer.parseInt(serv.getText().toString());
                ingredients = ingr.getText().toString();
                keyIng = key.getText().toString();
                instructions = instr.getText().toString();

                String[] ingredTokens = ingredients.split("[\\s,]+");
                ArrayList<String> ingred = new ArrayList<>(Arrays.asList(ingredTokens));

                String[] keyTokens = keyIng.split("[\\s,]+");
                ArrayList<String> key = new ArrayList<>(Arrays.asList(keyTokens));

                Recipe newR = new Recipe(recipeName,category,level,prepTime,cookTime,serving,ingred,key,instructions );
                addRecipe(newR);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){}

    public void onNothingSelected(AdapterView<?> parent){}

    public void addRecipe(Recipe r){
        RecipeListInterface rl = new RecipeListHSQLDB(MainActivity.getDBPathName());
        rl.addRecipe(r);
    }
}
