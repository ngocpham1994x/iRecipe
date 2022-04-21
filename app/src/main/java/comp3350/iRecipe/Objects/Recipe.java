package comp3350.iRecipe.Objects;

import java.util.ArrayList;

import comp3350.iRecipe.Persistence.CommentHSQLDB;
import comp3350.iRecipe.Presentation.MainActivity;

public class Recipe {
    private String name;            //name of the recipe

    private Category category;        //Drinks, Main dishes, Soup/Salad, Appetizers, Dessert
    private CookingLevel cookingLevel;    //Easy, Medium, hard

    private int prepTime;
    private int cookTime;
    private int serving;

    private ArrayList<String> keyIngredients;
    private ArrayList<String> ingredients;
    private String instruction;
    int image_code;


    private ArrayList<Comment> comments;



    public Recipe(String newName, Category newCate, CookingLevel newLevel, int prepTime, int cookTime, int serving, ArrayList<String> newIngred, ArrayList<String> newKeyIngred, String newInstruct){
        name = newName;
        category = newCate;
        cookingLevel = newLevel;
        ingredients = newIngred;
        instruction = newInstruct;
        keyIngredients = newKeyIngred;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.serving = serving;
        image_code =  - 1;
    }

    // second constructor - just to make testing a bit easier
    public Recipe(String recipeName , Category newCategory)
    {

        this(recipeName ,
                newCategory ,
                CookingLevel.getCookingLevel("easy") ,
                10 ,
                20 ,
                2 ,
                new ArrayList<String>(){{ add("eggs") ; add("water") ; add("salt"); }},
                new ArrayList<String>(){{ add("eggs") ; }} ,
                "this is pretty easy recipe" );

    }

    public String getName(){ return name; }

    public String getCategory(){ return category.toString(); }

    public String getLevel(){ return cookingLevel.toString(); }

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

    public void set_image_code(int code)
    {
        image_code = code;
    }
    public int get_image_code()
    {
        return image_code;
    }


}
