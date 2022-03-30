Iteration 2 Worksheet
=====================

Paying off technical debt
-----------------

Show two instances of your group paying off technical debt. For these two instances:

Explain how your are paying off the technical debt.
Show commits, links to lines in your commit where you paid off technical debt.
Classify the debt, and justify why you chose that classification with 1-3 sentences.

Example of how to link to a diff - click on he commit in the commit log, then click on the margin to the (line)[https://code.cs.umanitoba.ca/3350-winter-2021-a01/sample-project/-/commit/8e38ae9c3084d62adc4ac5fafa3b87d7d862dc26#72899361f89777662df76c5ce0ed847af04dff86_35_41]

SOLID
-----

Find a SOLID violation in the project of group with the same group number in the next class over - (n%3)+1 (A03 does A01) Open an issue in their project with the violation, clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure your links in the issues are to specific commits (not to main, or develop as those will be changed).

Provide a link to the issue you created here.

Retrospective
--------------

Describe how the retrospective has changed the way you are doing your project. Is there evidence of the change in estimating/committing/peer review/timelines/testing? Provide those links and evidence here - or explain why there is not evidence.

Design patterns
--------------

Links to project where we use a well-known design pattern:

- Singleton: we use Database [HSQL] (https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f671acd75740039815b3ce1eb8e2970d6628682b/app/src/main/java/comp3350/iRecipe/Persistence/RecipeListHSQLDB.java)

- Dependency Injection: mostly everywhere in the source codes. Examples:

    - we use it most in Presentation Layer, where we pass the list of all recipes and filter based on category. [Line 27](https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/AdapterRecipe.java/#L27) in AdapterRecipe.java,
      [Line 57](https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java/#L57) in ListRecipeActivity.java

    - where we pass the searchByList to limit what we search by (name, ingredients, category).
      [Line 58](https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/MainActivity.java/#L58) in MainActivity.java

- Facade: we used Facade where we can search and add recipe easily

    - [searchByName()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Business/SearchRecipe.java#L12)

    - [addRecipe()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Persistence/RecipeList.java#L33) to the end of the list

    - [addToIngredients()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Objects/Recipe.java#L78)

    - [removeRecipe()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Persistence/RecipeList.java#L33) using specified in parameter

- Chain Of Responsibilities:

    - [Line 133](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Presentation/MainActivity.java#L133) in MainActivity.java pass the "searchString" and "searchBy" value to
      [Line 43](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/5b3ca1ec9bc057f6b1b7988b8f7a9c65c908c4b0/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java#L43) ListRecipeActivity.java, it passes the "search by which" responsibility to show search results
      ([Line 76](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/5b3ca1ec9bc057f6b1b7988b8f7a9c65c908c4b0/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java#L76)) when click Search Icon on MainActivity.java

    - [Line 88](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Presentation/AdapterMainPage.java#L88) AdapterMainPage.java
      pass the "type" to MainPage.java
      [Line 42](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/5b3ca1ec9bc057f6b1b7988b8f7a9c65c908c4b0/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java#L42) in ListRecipeActivity.java
      to be responsible for displaying proper list of recipes based on according category.

Iteration 1 Feedback fixes
--------------

- Fixed Search Problem: [first fixed](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/55)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/bfa69b59e50837c3e4a843c769b4be0a02afc4f4)
, [second fixed](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/62)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/d144a207e2b78818f587d7f7240b413934c059ce)
    
    The problem with the code is that we seperate the Search funtion from the interface, it was pointed out that seraching for Recipe should be a part of the Interface as well. So I added the serach function to the interface, and modify the stub database
    to use the SearchFunction already written for the old implementation. I also added the search function in the Real database to use query for the search. The second was to fix some error loading Recipe Object from database.

- OCP violation fixed: [dev task](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/60)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/f671acd75740039815b3ce1eb8e2970d6628682b)

    We have code that repeat itself and it is hard to make modification in the future. So we change the code to use a couple arrays to store the resources and let the program to iterate through them itself. So that if we want to add more resources, we can just 
    add them to the array and don't have to modify the code

- Fixed not using exists constructor to reduce code repeat: [dev task](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/58)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/2479b4cfe13dfd395d0ab49188865dc1ed0cd224)


