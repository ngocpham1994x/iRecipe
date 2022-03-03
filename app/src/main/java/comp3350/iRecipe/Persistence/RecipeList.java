package comp3350.iRecipe.Persistence;

import android.content.Context;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Recipe;

public class RecipeList implements RecipeListInterface{

    private ArrayList<Recipe> recipeList;

    public RecipeList()
    {
        recipeList = new ArrayList<>();
    }

    public RecipeList(Context context)
    {
        recipeList = readRecipesFromCSV(context);
    }

    private ArrayList<Recipe> readRecipesFromCSV(Context context)
    {
        GetRecipeFromCSV getRecipes = new GetRecipeFromCSV();
        return getRecipes.readRecipesFromCSV(context);
    }

    @Override
    public boolean addRecipe(Recipe newRecipe)
    {
        return recipeList.add(newRecipe);
    } // will add a new recipe to the end of the list.

    @Override
    public boolean removeRecipe(Recipe toRemove)
    {
        return recipeList.remove(toRemove);
    } // remove the recipe specified in the parameter

    @Override
    public ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeList);
    } // return a deep copy of the recipe list.
}
