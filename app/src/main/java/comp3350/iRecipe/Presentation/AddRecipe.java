package comp3350.iRecipe.Presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.iRecipe.R;

public class AddRecipe extends AppCompatActivity {
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
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        one.setAdapter(adapter);

        /**Spinner for levels*/
        levs = getResources().getStringArray(R.array.levels);
        two = findViewById(R.id.recipeLevel);
        ArrayAdapter<CharSequence>adapter2 = ArrayAdapter.createFromResource(this, R.array.levels, android.R.layout.simple_spinner_item);
        two.setAdapter(adapter2);

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
            }
        });
    }
}
