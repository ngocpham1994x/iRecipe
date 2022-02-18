package comp3350.iRecipe;

import java.util.ArrayList;

public class Recipe {
    private String name;            //name of the recipe

    //Maybe we should use enum for these two?
    private String category;        //Drinks, Main dishes, Soup/Salad, Appetizers, Dessert
    private String cookingLevel;    //Easy, Medium, hard

    private ArrayList<String> ingredients;
    private String instruction;

    public Recipe(String newName, String newCate, String newLevel, ArrayList<String> newIngred, String newInstruct){
        name = newName;
        category = newCate;
        cookingLevel = newLevel;
        ingredients = newIngred;
        instruction = newInstruct;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public String getLevel(){
        return cookingLevel;
    }

    //Return a copy of the ingredients, so that others don't mess around in the list we store
    public ArrayList<String> getIngredients(){
        return new ArrayList<String>(ingredients);
    }

    public String getInstruction(){
        return instruction;
    }
}
