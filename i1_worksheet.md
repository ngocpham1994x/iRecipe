Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Feature: List of all the recipes. [FeatureIssue](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/1)

User Stories: [UserStory](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/9)

Dev taks: [Task](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/23)

- To add this feature to our project, we first need to create the Object of Recipe, and decide what should one single recipe have. Our design was that, a Recipe should have its name, its category (Main dishes, drinks, soup, etc.), its ingredients and its instructions on how to cook. And also expected cooking time, cooking level and the expected number of serving people. Then we should have some default recipes to work as a fake database. For this, we decided to write some default recipe and store it inside CSV Files and read it to set up a fake database. We have an interface that define the method to acquire/search that returns an ArrayList of Recipe. Then we have a class that read from CSV File and implement all the function from this interface, this sets up our business layer and provide logic support for this feature.

- In the GUI design that implement this feature, we use Adapter to fetch info according to the button we clicked to show a List of Recipe. We can choose to show all recipe (Using the function from the interface to get all recipe), or show a list of recipe according to its category (Using the search recipe by category function from the interface). Then the listing of the overview of the Recipe would just be the name of the Recipe and its category. This is how we added this feature to our project.

Link of merge request related to this implementation: 

interface: [interface](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/merge_requests/2)
ReadingCSVFile: [First_Implementation](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/merge_requests/3) 
[Implementation_Changes](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/merge_requests/4)
GUI: [MainPageGUI](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/merge_requests/7) 
[ListAllRecipeGUI](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/merge_requests/8)

Exceptional code
----------------

Link to an Exceptional code : [Exceptional_code](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/main/java/comp3350/iRecipe/Persistence/RecipeList.java)
Testing of Exceptional code : [Exception_testing](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/main/app/src/test/java/comp3350/iRecipe/RecipeListUnitTest.java)

- For our project, we are using an ArrayList Data structure. we found out that a built-in "add" method of ArrayList does not throw exception when adding null object to the list. That allows a null object to be in a list of recipes and causes NULL pointer exception, Whenever we try to access the recipes and its methods from ArrayList. To resolve that, we are checking for a null object before adding a recipe in the list. [Exceptional_code][line 32]

- For testing purpose, we kept one add method in RecipeList.java, which does not check for null object. [Exceptional_code][line 46]
When we execute a unit test [Exception_testing][line 49] about getting a recipe from the list after adding a null object, unsurprisingly it returns us a null object causing an exception. That shows that ArrayList add method accepts null object so we need to check for that before using that method.





Branching
----------

This is our [Branching Strategy](BranchingStrategy.md)

SOLID
-----

Group 11 Solid Violation: [SOLID Violation](https://code.cs.umanitoba.ca/winter-2022-a02/group-11/3350-project-group11/-/issues/20)

Agile Planning
--------------

Iteration1 went almost as expected.For some of the features/user stories, logic layer was complete but GUI was not done in given period of time. So these features was pushed for Iteration2. Other features like Search recipe by keyword was pushed because it was not time permitting.<br />

Some of the features are pushed to Iteration2 and are listed below:<br />

[ViewRecipeDescription](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/7)<br />
[SearchRecipesbykeyword](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/3) <br />
[ViewCompleteDescriptionOfARecipe](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/22) <br />
[ViewRecipeEstimateTime](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/8) <br />
[ViewRecipeIngredients](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/10) <br />







