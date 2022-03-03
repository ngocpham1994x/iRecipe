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

Provide a link to where you describe your branching strategy.

Provide screen shot of a feature being added using your branching strategy
successfully. The [GitLab Graph tool can do this](https://code.cs.umanitoba.ca/comp3350-summer2019/cook-eBook/-/network/develop),
as well as using `git log --graph`.

SOLID
-----

Find a SOLID violation in the project of group `(n%16)+1` (group 16 does group 1).
Open an issue in their project with the violation,
clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure
your links in the issues are to **specific commits** (not to `main`, or `develop` as those will be changed).

Provide a link to the issue you created here.

Agile Planning
--------------

Write a paragraph about any plans that were changed. Did you
'push' any features to iteration 2? Did you change the description
of any Features or User Stories? Have links to any changed or pushed Features
or User Stories.
