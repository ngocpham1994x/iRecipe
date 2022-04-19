What technical debt has been cleaned up
========================================

We had minor technical debt that could not be solved by the end of iteration 2 due to time constraint and higher priorities. 
Our addRecipe method that adds a new recipe to the database checks duplicate recipes by comparing their names only.
When we would enter a duplicate recipe on our "Add your own recipe!" page to check that the system was successfully not adding
a duplicate recipe, we found the method to be case sensitive.
Due to this the system would add for example "chicken rice" and "Chicken rice" despite them being duplicates.
This was prudent and deliberate. We have now fixed our code and removed the technical debt.
Link to the commit: [here](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/commit/8acc8c03b7d826b280d660d0f3ac73d3d92820aa)

What technical debt did you leave?
==================================

What one item would you like to fix, and can't? Anything you write will not
be marked negatively. Classify this debt.

Discuss a Feature or User Story that was cut/re-prioritized
============================================

When did you change the priority of a Feature or User Story? Why was it
re-prioritized? Provide a link to the Feature or User Story. This can be from any
iteration.

Acceptance test/end-to-end
==========================

I (Ngoc Pham) is responsible for testing the Search Feature of the app.

I set up the search test to search both by Recipe Name and Ingredients. Testing both types will verify the robustness of our app.

As a user, I would like to be able to find recipe by its name as well as by its key ingredient.

I ensure the flow of the test makes the most sense as from the user's point of view since the moment they freshly install and open the app.

I ensure the user is able to view recipe they want to from the search results.

Procedures for search by recipe name:
- User installs the app (fresh install).
- User navigates to the Search By, clicks on Search By to view the drop down menu options. 
- User selects which type / category of search that they want to perform.
- User selects Recipe Name to search by name of recipes.
- User navigates to text area to type in letter "b".
- User navigates to and clicks on the search icon.
- A new page occurs listing all recipes matching the result of the search.
- User selects the "Lasagna Flatbread" recipe.
- User verifies a new page occur listing details of the recipe "Lasagna Flatbread".
- Test completed.

Link to the test: [SearchTest.java](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/blob/76-acceptance-test-searchtest-modification/app/src/androidTest/java/comp3350/iRecipe/SearchTest.java)


Acceptance test, untestable
===============

What challenges did you face when creating acceptance tests? What was difficult
or impossible to test?

Challenges:

Expresso test can be used with androidx library or android.support library.

android.support is depricating and Ngoc developed GUI using androidx library for RecyclerView and Card.

Using android.support on an androidx item is conflicting.

Therefore, Ngoc used `withText()` instead of `withId()` to be able to find and click on the appropriate card.

Velocity/teamwork
=================

Our estimate gets better as time progress in genral. At first, our estimation does not quite matches the time we actually spend, for example, most were short: [Creating Object](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/23), 
[Creating interface](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/25),[Stub database with file](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/24),
 [GUI for listing Recipe](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/29), [Move file into pacakages](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/33). 
 
But for the next iteration (iteration 2), some of our task's estimation matches the actaull time spend: [Swithing to read Database](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/49), [Refactor previous implementation](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/52), [Adding logic support for new feature](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/53). But some exceed because we are working with new stuffs, such as new GUI, so the estimation was not correct: [GUI](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/57), [Another GUI](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/50)

For iteration 3, the fixing part of the code can be estimated correctly: (Code refactor)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/70], but some of the estimation is not that good, mostly because we are dealing with new stuffs. For example, acceptence test that we have not written before: (Test 1)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/79], (Test 2)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/77], (Test 3)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/76]. Also, personally, I have to create another new GUI by myself, I was focusing on the backend stuff and this is new for me, so my time estimation was not good either (GUI page for comment for recipe)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/72]

So overall, if we are estimating the things we have done before, our time spend match our estimation. But we are not so good at estimating things that we have never done before.
