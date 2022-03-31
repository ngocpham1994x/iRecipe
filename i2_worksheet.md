Iteration 2 Worksheet
=====================

Paying off technical debt
-----------------

There are many instances of our group paying off the techinal dept.Two of the instances are:<br/>

DATABASE:In iteration1 we were using fake Database which was Prudent Deliberate techinal dept.We used fake Database because it was simpler and lighter weight implentation of functionality. We payed off this technical dept by implementing real Database with HSQL. Also we had to make changes in the project after implementing real Database some of the links are below:
- [Link to Database file](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/63-retrospectice-paying-off-technical-depth/app/src/main/java/comp3350/iRecipe/Persistence/RecipeListHSQLDB.java)<br/>
- [changes for real database](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/868b03b99c3f2866438ef8b16750d5a6f115edd4)
- copying database to device (line40)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/868b03b99c3f2866438ef8b16750d5a6f115edd4/app/src/main/java/comp3350/iRecipe/Presentation/MainActivity.java] <br/>
- Linking Real Database: (line 35)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/868b03b99c3f2866438ef8b16750d5a6f115edd4/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java] <br/>

DUPLICATE RECIPES:In iteration1, project was using data Structure and the real database. Because of this project was getting all the recipes twice.It was the Prudent and Deliberate debt because we didn't think about the data duplicacy and didn't removed it but when we get to know about it. We payed off the dept by removing the data structure. we had to make some changes in project and links are below:<br/> 
- (line12)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/59c5740af4a008ec3faf94cfbe13ed9819eae1a4/app/src/main/java/comp3350/iRecipe/Business/SearchRecipe.java]<br/>
- (line49)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/59c5740af4a008ec3faf94cfbe13ed9819eae1a4/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java]<br/>
- (line39)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/59c5740af4a008ec3faf94cfbe13ed9819eae1a4/app/src/main/java/comp3350/iRecipe/Presentation/RecipeDetailActivity.java]<br/>
- (line25)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/59c5740af4a008ec3faf94cfbe13ed9819eae1a4/app/src/test/java/comp3350/iRecipe/SearchRecipeTest.java]<br/>
- Removed Data Structure:[link to issue](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/c0a8f094733366be7c6d7defa3e9b5ba02fc7b63)<br/>






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

- **Singleton**: we use Database [HSQL](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f671acd75740039815b3ce1eb8e2970d6628682b/app/src/main/java/comp3350/iRecipe/Persistence/RecipeListHSQLDB.java)
    where we instantiate database connection once. 

- **Dependency Injection**: mostly everywhere in the source codes. Examples:

    - we use it most in Presentation Layer, where we pass the list of all recipes and filter based on category. [Line 27](https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/AdapterRecipe.java/#L27) in AdapterRecipe.java,
      [Line 57 ListRecipeActivity.java](https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java/#L57)

    - where we pass the searchByList to limit what we search by (name, ingredients).
      [Line 58 MainActivity.java](https://code.cs.umanitoba.ca/-/ide/project/winter-2022-a02/group-10/irecipe/tree/main/-/app/src/main/java/comp3350/iRecipe/Presentation/MainActivity.java/#L58)

- **Facade**: we used Facade where we can search and add recipe easily when building Presentation Layer (the low level codes are hidden)

    - [searchByingredients()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f8221e547cda55cd2fe3416aa4866e565a1aeb92/app/src/main/java/comp3350/iRecipe/Presentation/AddRecipe.java#L127) 
      is used in [Line 86 of ListRecipeActivity.java](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f8221e547cda55cd2fe3416aa4866e565a1aeb92/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java#L86)

    - [addRecipe()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f8221e547cda55cd2fe3416aa4866e565a1aeb92/app/src/main/java/comp3350/iRecipe/Persistence/RecipeListHSQLDB.java#L87)
        is used in [Line 127 of AddRecipeActivity.java](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f8221e547cda55cd2fe3416aa4866e565a1aeb92/app/src/main/java/comp3350/iRecipe/Presentation/AddRecipe.java#L127)

    - [addToIngredients()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Objects/Recipe.java#L78)

    - [removeRecipe()](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/f8221e547cda55cd2fe3416aa4866e565a1aeb92/app/src/main/java/comp3350/iRecipe/Persistence/RecipeListHSQLDB.java#L126) using specified in parameter

- **Chain Of Responsibilities**:

    - [Line 133 MainActivity.java](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Presentation/MainActivity.java#L133) passes the "searchString" and "searchBy" value to
      [Line 43 ListRecipeActivity.java](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/5b3ca1ec9bc057f6b1b7988b8f7a9c65c908c4b0/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java#L43) , it passes the search-by-which responsibility to show search results on 
      ([Line 76](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/5b3ca1ec9bc057f6b1b7988b8f7a9c65c908c4b0/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java#L76)) when click on search icon on MainActivity.java

    - [Line 89 AdapterMainPage.java](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/5245c02c719f52cafc1e856f62d6ffc98b48651b/app/src/main/java/comp3350/iRecipe/Presentation/AdapterMainPage.java#L89)
      passes the "type" to 
      [Line 42 ListRecipeActivity.java](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/5b3ca1ec9bc057f6b1b7988b8f7a9c65c908c4b0/app/src/main/java/comp3350/iRecipe/Presentation/ListRecipeActivity.java#L42)
       to be responsible for displaying proper list of recipes based on according category.

Iteration 1 Feedback fixes
--------------

- Fixed Search Problem: [first fixed](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/55)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/bfa69b59e50837c3e4a843c769b4be0a02afc4f4)
, [second fixed](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/62)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/d144a207e2b78818f587d7f7240b413934c059ce)
    
    The problem with the code is that we separate the Search function from the interface, it was pointed out that searching for Recipe should be a part of the Interface as well. So we added the search function to the interface, and modify the stub database
    to use the SearchFunction already written for the old implementation. We also added the search function in the Real database to use query for the search. The second was to fix some error loading Recipe Object from database.

- OCP violation fixed: [dev task](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/60)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/f671acd75740039815b3ce1eb8e2970d6628682b)

    We have code that repeat itself and it is hard to make modification in the future. So we change the code to use a couple arrays to store the resources and let the program to iterate through them itself. So that if we want to add more resources, we can just 
    add them to the array and don't have to modify the code

- Fixed not using exists constructor to reduce code repeat: [dev task](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/58)->[commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/2479b4cfe13dfd395d0ab49188865dc1ed0cd224)


i2_worksheet.md
Explain what the issue was, and why it was flagged. Explain what you did to refactor or fix your code to address the issue. Provide links to the commits where you fixed the issue.


