package comp3350.iRecipe.Business;

import java.util.ArrayList;

import comp3350.iRecipe.Objects.Recipe;
import comp3350.iRecipe.Persistence.RecipeListInterface;

public class SearchRecipe {


    public static Recipe searchByName(String nameOfRecipe, ArrayList<Recipe> recipeList)
    {

        for (Recipe retrieved_recipe : recipeList) {
            if (nameOfRecipe.equalsIgnoreCase(retrieved_recipe.getName())) {
                return retrieved_recipe;
            }
        }

        return null;
    } // search the recipe of the given name

    public static ArrayList<Recipe> getRecipesByCategory(String category, ArrayList<Recipe> recipeList) {

        ArrayList<Recipe> recipeListByCategory = new ArrayList<>();

        for (Recipe retrieved_recipe : recipeList) {
            if ( category.equalsIgnoreCase(retrieved_recipe.getCategory())) {
                recipeListByCategory.add(retrieved_recipe);
            }
        }

        return recipeListByCategory;
    } // return a list of all recipe from the same category

    public static ArrayList<Recipe> searchByIngredients(String ingredient, ArrayList<Recipe> recipeList){

        ArrayList<Recipe> result = new ArrayList<>();
        for(Recipe retrieved : recipeList){

            ArrayList<String> allKeyIngredients = retrieved.getKeyIngredients();
            for(String toCheck : allKeyIngredients){

                //If found one match, exit this loop and check next recipe
                if(ingredient.equalsIgnoreCase(toCheck)){
                    result.add(retrieved);
                    break;
                }
            }

        }
        return result;
    }
}
