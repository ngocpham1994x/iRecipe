package comp3350.iRecipe;

import java.util.ArrayList;

public interface RecipeListInterface {

    // add recipe
    public boolean addRecipe(Recipe newRecipe);

    // remove the recipe
    public boolean removeRecipe(Recipe toRemove);

    // search the recipe from the name of the recipe
    public Recipe searchByName(String nameOfRecipe);

    // returns the entire list
    public ArrayList<Recipe> getAllRecipes();

    //returns a list of recipes based on the category
    public ArrayList<Recipe> getRecipesByCategory(String category);

    public ArrayList<Recipe> searchByIngredients(String category);


}
