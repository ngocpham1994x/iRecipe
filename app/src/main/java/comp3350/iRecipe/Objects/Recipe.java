package comp3350.iRecipe.Objects;

import java.util.ArrayList;

public class Recipe {
    private String name;            //name of the recipe

    //Maybe we should use enum for these two?
    private String category;        //Drinks, Main dishes, Soup/Salad, Appetizers, Dessert
    private String cookingLevel;    //Easy, Medium, hard

    private int prepTime;
    private int cookTime;
    private int serving;

    private ArrayList<String> keyIngredients;
    private ArrayList<String> ingredients;
    private String instruction;

    public Recipe(String newName, String newCate, String newLevel, int prepTime, int cookTime, int serving, ArrayList<String> newIngred, ArrayList<String> newKeyIngred, String newInstruct){
        name = newName;
        category = newCate;
        cookingLevel = newLevel;
        ingredients = newIngred;
        instruction = newInstruct;
        keyIngredients = newKeyIngred;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.serving = serving;
    }

    // second constructor - just to make testing a bit easier
    public Recipe(String recipeName , String newCategory)
    {
        name = recipeName;
        category = newCategory;
        cookingLevel = "easy";
        ingredients = new ArrayList<>();
        instruction = "this is pretty easy recipe";
        keyIngredients = new ArrayList<>();
        ingredients.add("eggs");
        ingredients.add("flour");
        ingredients.add("sugar");
        keyIngredients.add("flour");
        this.prepTime = 10;
        this.cookTime = 20;
        this.serving = 2;

    }

    public String getName(){ return name; }

    public String getCategory(){ return category; }

    public String getLevel(){ return cookingLevel; }

    public int getCookTime(){ return cookTime;}

    public int getServing() { return serving; }

    public int getPrepTime(){ return prepTime;}

    //Return a copy of the ingredients, so that others don't mess around in the list we store
    public ArrayList<String> getIngredients(){ return new ArrayList<>(ingredients); }

    public ArrayList<String> getKeyIngredients(){ return new ArrayList<>(keyIngredients); }

    public String getInstruction(){ return instruction; }

    //Add ingredient to all ingredients
    public void addToIngredients(String ingred) {
        ingredients.add(ingred);
    }

    //Add key ingredients to Recipe
    public void addToKeyIngredients(String ingred){
        keyIngredients.add(ingred);
    }
}
