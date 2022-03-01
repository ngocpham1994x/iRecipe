# ARCHITECTURE.md

## GetRecipeFromCVS.java 
It is the main class where all the features like addRecipe, removeRecipe, searchByName, getAllRecipes, getRecipesbyCategory and searchByIngredients are implemented.It makes a Arraylist for fake database by making object of Recipelist java file  and read all the data from a csv file line by line, till end of file.

## RecipeList.java
Recipe.java is the class used to make objects and store them in Array List. this class have 2 constructors to initialize all the required variables and have get/set methods namely : getname,getCategory,getLevel, getCookTime, getServing, getPrepTime, getIngredients, getKeyIngredients, getInstructions, addToInstructions, addToKeyIngredients

## RecipeListInterface.java
RecipeListInterface.java is the interface of recipelist class and have signature of all the required methods


![e8c910824afd33f55ce20663d783d86272d50027](graphical.png"graphical representation")
