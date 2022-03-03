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

Provide a link to a test of exceptional code. In a few sentences,
provide an explanation of why the exception is handled or thrown
in the code you are testing.

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
[GroupRecipeByCategory](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/2) <br />
[ViewRecipeDescription](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/7)<br />
[SearchRecipesbykeyword](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/3) <br />
[ViewCompleteDescriptionOfARecipe](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/22) <br />
[ViewRecipeEstimateTime](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/8) <br />
[ViewRecipeIngredients](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/10) <br />







