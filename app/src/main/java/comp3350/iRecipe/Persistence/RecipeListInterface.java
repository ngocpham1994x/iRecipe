package comp3350.iRecipe.Persistence;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Recipe;

public interface RecipeListInterface {

    // add recipe
    public boolean addRecipe(Recipe newRecipe);

    // remove the recipe
    public boolean removeRecipe(Recipe toRemove);

    public Recipe searchByName(String nameOfRecipe);

    public ArrayList<Recipe> matchByName(String nameOfRecipe);

    public ArrayList<Recipe> getRecipesByCategory(String category);

    public ArrayList<Recipe> searchByIngredients(String ingredient);

    // returns the entire list
    public ArrayList<Recipe> getAllRecipes();

}
