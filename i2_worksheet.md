Iteration 2 Worksheet
=====================

Paying off technical debt
-----------------

Show two instances of your group paying off technical debt. For these two instances:

Explain how your are paying off the technical debt.
Show commits, links to lines in your commit where you paid off technical debt.
Classify the debt, and justify why you chose that classification with 1-3 sentences.

Example of how to link to a diff - click on he commit in the commit log, then click on the margin to the (line)[https://code.cs.umanitoba.ca/3350-winter-2021-a01/sample-project/-/commit/8e38ae9c3084d62adc4ac5fafa3b87d7d862dc26#72899361f89777662df76c5ce0ed847af04dff86_35_41]<br /><br />

There are many instances of our group paying off the techinal dept.Two of the main instances are:<br/>

DATABASE:In iteration1 we were using fake Database which was Prudent Deliberate techinal dept.We used fake Database because it was simpler and lighter weight implentation of functionality. We payed off this technical dept by implementing real Database with HSQL. Also we had to make changes in the project after implementing real Database like <br/>
[Database file](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/63-retrospectice-paying-off-technical-depth/app/src/main/java/comp3350/iRecipe/Persistence/RecipeListHSQLDB.java)<br/>
[changes for real database](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/868b03b99c3f2866438ef8b16750d5a6f115edd4)





SOLID
-----

Find a SOLID violation in the project of group with the same group number in the next class over - (n%3)+1 (A03 does A01) Open an issue in their project with the violation, clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure your links in the issues are to specific commits (not to main, or develop as those will be changed).

Provide a link to the issue you created here.

Retrospective
--------------

Retrospective has helped a lot in improving the project-planning. Also all group members are using Android studio and gitlab for the first time, so there was a bit of confusion especially with using gitlab during past iterations. But team members communicated well, helped each other and also switched the tasks if one was not able to complete it. To have team members on the same page we used google doc to track the workflow and new ideas. We used discord, telegram and sometimes zoom for meetings.

The iteration0 was on time as expected but there were some issues in iteration1 which were pushed to iteration2 and following are the links:

[Search recipe by key](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/3) <br />
[View recipe description](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/7)<br />
[View recipe estimate time](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/8)<br />
[View recipe ingredients](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/10)<br />


Design patterns
--------------

Links to project where we use a well-known design pattern:

- Singleton: we use Database (HSQL)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f671acd75740039815b3ce1eb8e2970d6628682b/app/src/main/java/comp3350/iRecipe/Persistence/RecipeListHSQLDB.java]
- Dependency Injection: mostly everywhere in the source codes. Examples: 
    - we use it most in Presentation Layer, where we pass the list of all recipes and filter based on category. (Line 27)[https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/AdapterRecipe.java/#L27] in AdapterRecipe.java, (Line 57)[https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java/#L57] in ListRecipeActivity.java
    - where we pass the searchByList to limit what we search by (name, ingredients, category). (Line 58)[https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/MainActivity.java/#L58] in MainActivity.java
- Facade: we used Facade where we can search and add recipe easily
    - (searchByName() )[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Business/SearchRecipe.java#L12]
    - (addRecipe())[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Persistence/RecipeList.java#L33] to the end of the list
    - (addToIngredients())[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Objects/Recipe.java#L78]
    - (removeRecipe())[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Persistence/RecipeList.java#L33] using specified in parameter
  
Iteration 1 Feedback fixes
--------------

Provide a link to an issue opened by the grader.

Explain what the issue was, and why it was flagged. Explain what you did to refactor or fix your code to address the issue. Provide links to the commits where you fixed the issue.
