package comp3350.iRecipe.Persistence;

import android.content.Context;

import java.util.ArrayList;

import comp3350.iRecipe.Business.SearchRecipe;
import comp3350.iRecipe.Objects.Recipe;

public class RecipeList implements RecipeListInterface{

    private ArrayList<Recipe> recipeList;

    // when we have fake object instances of recipes
    public RecipeList()
    {
        recipeList = new ArrayList<>();
    }

    // when we are reading data files from asset folder
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
        // will handle Null Pointer exception
        if(newRecipe != null)
            return recipeList.add(newRecipe);
        else
            return false;
    } // will add a new recipe to the end of the list.


    // arraylist add method won't directly throw NullPointer exception
    // So, you can add Null object to arraylist at first
    // However , it gives exception when you use that "NULL" Object somewhere else
    // It is Tested in RecipeListUnitTest file
    public boolean addRecipeWithException(Recipe newRecipe)
    {
        return recipeList.add(newRecipe);
    }


    @Override
    public boolean removeRecipe(Recipe toRemove)
    {
        return recipeList.remove(toRemove);
    } // remove the recipe specified in the parameter

    @Override
    public ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeList);
    } // return a deep copy of the recipe list.

    @Override
    public Recipe searchByName(String nameOfRecipe){
        return SearchRecipe.searchByName(nameOfRecipe, getAllRecipes());
    }

    @Override
    public ArrayList<Recipe> matchByName(String nameOfRecipe){
        return SearchRecipe.matchByName(nameOfRecipe, getAllRecipes());
    }

    @Override
    public ArrayList<Recipe> getRecipesByCategory(String category){
        return SearchRecipe.getRecipesByCategory(category, getAllRecipes());
    }

    @Override
    public ArrayList<Recipe> searchByIngredients(String ingredient){
        return SearchRecipe.searchByIngredients(ingredient, getAllRecipes());
    }
}
