package comp3350.iRecipe;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

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

    public static ArrayList<Recipe> getRecipe(){
        ArrayList<Recipe> allRecipe = new ArrayList<>();
        try{
            BufferedReader recipeReader = new BufferedReader(new FileReader("Recipe.csv"));

            //Read Recipe data line by line
            String line = recipeReader.readLine();  //Skip the first line, which is the header, not the data
            while( (line = recipeReader.readLine()) != null ){
                String[] data = line.split(",");
                String name = data[RECIPENAME];
                String insturctions = "";
                ArrayList<String> ingred = new ArrayList<>();
                ArrayList<String> keyIngred = new ArrayList<>();

                BufferedReader readInstruct = new BufferedReader(new FileReader("Instructions.csv"));
                String instructLine = readInstruct.readLine();      //Skip first header line
                while( (instructLine = readInstruct.readLine()) != null){

                    String[] instructData = instructLine.split(",");
                    //If the name matches, add to the Recipe object
                    if(instructData[RECIPENAME].equals(name) ){
                        insturctions += instructData[INSTRUCTION] + "\n";
                    }
                }
                readInstruct.close();

                Recipe recipe = new Recipe(data[RECIPENAME], data[CATEGORY], data[COOKINGLEVEL],
                        Integer.parseInt(data[PREPTIME]), Integer.parseInt(data[COOKINGTIME]),
                        Integer.parseInt(data[SERVING]), ingred, keyIngred, insturctions);

                //Read ingredients and add to recipe
                BufferedReader readIngred = new BufferedReader(new FileReader("Ingredients.csv"));
                String ingredLine = readIngred.readLine();      //Skip first header line
                while( (ingredLine = readIngred.readLine()) != null){

                    String[] ingredData = ingredLine.split(",");
                    //If the name matches, add to the Recipe object
                    if(ingredData[RECIPENAME].equals(name) ){
                        recipe.addToIngredients(ingredData[INGREDIENTS]);
                    }
                }
                readIngred.close();

                //Read Key ingredients and add to recipe
                BufferedReader readKeyIngred = new BufferedReader(new FileReader("KeyIngredients.csv"));
                String keyIngredLine = readKeyIngred.readLine();    //Skip first header line
                while( (keyIngredLine = readKeyIngred.readLine()) != null){

                    String[] keyIngredData = keyIngredLine.split(",");
                    //If the name matches, add to the Recipe object
                    if(keyIngredData[RECIPENAME].equals(name)){
                        recipe.addToKeyIngredients(keyIngredData[KEYINGREDIENTS]);
                    }
                }
                readKeyIngred.close();

                allRecipe.add(recipe);

            }//End of reading Recipe.csv

            recipeReader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return allRecipe;
    }
}
