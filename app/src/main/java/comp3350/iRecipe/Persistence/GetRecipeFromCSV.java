package comp3350.iRecipe.Persistence;


import android.content.Context;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import comp3350.iRecipe.Objects.Category;
import comp3350.iRecipe.Objects.CookingLevel;
import comp3350.iRecipe.Objects.Recipe;



public class GetRecipeFromCSV {

    //Column number in Recipe.csv
    static final int RECIPENAME = 0;
    static final int CATEGORY = 1;
    static final int COOKINGLEVEL = 2;
    static final int PREPTIME = 3;
    static final int COOKINGTIME = 4;
    static final int SERVING = 5;

    //Column number in Ingredients.csv
    static final int INGREDIENTS = 1;

    //Column number in keyIngredients.csv
    static final int KEYINGREDIENTS = 1;

    //Column number in Instructions.csv
    static final int INSTRUCTION = 1;

    public GetRecipeFromCSV(){ }

    public ArrayList<Recipe> readRecipesFromCSV(Context context){
        ArrayList<Recipe> allRecipe = new ArrayList<>();
        try{

            InputStream recipeIn = context.getAssets().open("Recipe.csv");
            BufferedReader recipeReader = new BufferedReader(new InputStreamReader(recipeIn));

            //Read Recipe data line by line
            String line = recipeReader.readLine();  //Skip the first line, which is the header, not the data
            while( (line = recipeReader.readLine()) != null ){
                //Log.i("Read recipe.csv")

                String[] data = line.split(",");
                String name = data[RECIPENAME];
                String insturctions = "";
                ArrayList<String> ingred = new ArrayList<>();
                ArrayList<String> keyIngred = new ArrayList<>();

                InputStream instrucIn = context.getAssets().open("Instructions.csv");
                BufferedReader readInstruct = new BufferedReader(new InputStreamReader(instrucIn));
                String instructLine = readInstruct.readLine();      //Skip first header line
                while( (instructLine = readInstruct.readLine()) != null){

                    String[] instructData = instructLine.split(",");
                    //If the name matches, add to the Recipe object
                    if(instructData[RECIPENAME].equals(name) ){
                        insturctions += instructData[INSTRUCTION] + "\n";
                    }
                }
                readInstruct.close();
                instrucIn.close();

                Recipe recipe = new Recipe(data[RECIPENAME], Category.getCategory(data[CATEGORY]), CookingLevel.getCookingLevel(data[COOKINGLEVEL]),
                        Integer.parseInt(data[PREPTIME]), Integer.parseInt(data[COOKINGTIME]),
                        Integer.parseInt(data[SERVING]), ingred, keyIngred, insturctions);

                //Read ingredients and add to recipe
                InputStream ingredIn = context.getAssets().open("Ingredients.csv");
                BufferedReader readIngred = new BufferedReader(new InputStreamReader(ingredIn));
                String ingredLine = readIngred.readLine();      //Skip first header line
                while( (ingredLine = readIngred.readLine()) != null){

                    String[] ingredData = ingredLine.split(",");
                    //If the name matches, add to the Recipe object
                    if(ingredData[RECIPENAME].equals(name) ){
                        recipe.addToIngredients(ingredData[INGREDIENTS]);
                    }
                }
                readIngred.close();
                ingredIn.close();

                //Read Key ingredients and add to recipe
                InputStream keyIngredIn = context.getAssets().open("KeyIngredients.csv");
                BufferedReader readKeyIngred = new BufferedReader(new InputStreamReader(keyIngredIn));
                String keyIngredLine = readKeyIngred.readLine();    //Skip first header line
                while( (keyIngredLine = readKeyIngred.readLine()) != null){

                    String[] keyIngredData = keyIngredLine.split(",");
                    //If the name matches, add to the Recipe object
                    if(keyIngredData[RECIPENAME].equals(name)){
                        recipe.addToKeyIngredients(keyIngredData[KEYINGREDIENTS]);
                    }
                }
                readKeyIngred.close();
                keyIngredIn.close();

                allRecipe.add(recipe);

            }//End of reading Recipe.csv
            recipeIn.close();
            recipeReader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return allRecipe;
    }


}
