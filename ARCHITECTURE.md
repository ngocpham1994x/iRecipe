# ARCHITECTURE.md

## GetRecipeFromCVS.java 
It is the main class where all the features like addRecipe, removeRecipe, searchByName, getAllRecipes, getRecipesbyCategory and searchByIngredients are implemented.It makes a Arraylist for fake database by making object of Recipelist java file  and read all the data from a csv file line by line, till end of file.

## RecipeList.java
Recipe.java is the class used to make objects and store them in Array List. this class have 2 constructors to initialize all the required variables and have get/set methods namely : getname,getCategory,getLevel, getCookTime, getServing, getPrepTime, getIngredients, getKeyIngredients, getInstructions, addToInstructions, addToKeyIngredients

## RecipeListInterface.java
RecipeListInterface.java is the interface of recipelist class and have signature of all the required methods


![https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/80c75184bd4a2ae64f169f1f944ebae7ec1fb55d/graphical.png](graphical.png"graphical representation")
