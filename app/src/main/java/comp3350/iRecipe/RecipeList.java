package comp3350.iRecipe;


import java.util.ArrayList;

// Implements arrayList data structure and it's methods.
public class RecipeList implements RecipeListInterface {

    // A list of all recipes
    private ArrayList<Recipe> recipeList;


    // constructor
    public RecipeList()
    {
        recipeList = new ArrayList<>();
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
    public Recipe searchByName(String nameOfRecipe)
    {

        for (Recipe retrieved_recipe : recipeList) {
            if (nameOfRecipe.equals(retrieved_recipe.getName())) {
                return retrieved_recipe;
            }
        }

        return null;
    } // search the recipe of the given name

    @Override
    public ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeList);
    } // return a deep copy of the recipe list.

    @Override
    public ArrayList<Recipe> getRecipesByCategory(String category) {

        ArrayList<Recipe> recipeListByCategory = new ArrayList<>();

        for (Recipe retrieved_recipe : recipeList) {
            if (category.equals(retrieved_recipe.getCategory())) {
                recipeListByCategory.add(retrieved_recipe);
            }
        }

        return recipeListByCategory;
    } // return a list of all recipe from the same category

}