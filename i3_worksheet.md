Insturction for marker when using our app for iteration_3 marking:
===================================================================

Dear marker:

Hi!

If you have marked our app previously and still have our app installed in your emulator, please uninstall the app and reinstall it before using and marking it.
Our new feature involves creating new table in the database and populating the database with new data, the changes in the script file will not be copied over
unless the app is uninstalled and reinstalled again. For the purpose of making the app works properly, please do so to get the best experience.

Sincerely,

Group 10

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

Technical dept is the dept caused by adopting easy way to develop a product which later needs to be refactored. In our project, there are some of the technical depts and one of them is not having specific Id for all the cards in `AdapterMainPage.java`. we are using array to store all the informaiton of cards and for positioning of the cards, because of this we are using `withText()` in system tesing files instead of using `withId()`. In future if developer's team wanted to change the GUI and edit the text on the cards, then they also have to modify the testing files otherwise the code will throw the error. We are not going to fix it because we have to change alot of things in our logic layer, so we decided to move forward with this technical dept.

Discuss a Feature or User Story that was cut/re-prioritized
============================================

When we started working on the project, a feature about multi-user functionality was added to our list of features. while assigning priorities to all features, we have assigned multi-user functionality to iteration 3 with low priority. Because, we had other important features like RecipeDetail, SearchRecipe, and AddRecipe. Because we wanted to provide a strong recipe base to the users before allowing multiple user accounts.

During iteration 3 planning, we found out that we will only be able to finish one feature for this iteration. Because we were expected to create system tests using espresso which was a completely new technology for us to implement. So, it took a considerable portion of our time. Moreover, we needed to build a static website and a presentation video for the application. Due to all these reasons, we chose to implement the only comment/rate recipe feature over multi-user functionality because the implementation of the comment/rate feature would help many recipe creators to improve their content.

Link : [Multi-user functionality](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/13)


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

Espresso test can be used with androidx library or android.support library.

android.support is deprecating and Ngoc developed GUI using androidx library for RecyclerView and Card.

Using android.support on an androidx item is conflicting.

Therefore, Ngoc used `withText()` instead of `withId()` to be able to find and click on the appropriate card.

Velocity/teamwork
=================

Our estimate gets better as time progress in general. At first, our estimation does not quite matches the time we actually spend, for example, most were short: [Creating Object](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/23), 
[Creating interface](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/25),[Stub database with file](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/24),
 [GUI for listing Recipe](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/29), [Move file into pacakages](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/33). 
 
But for the next iteration (iteration 2), some of our task's estimation matches the actual time spend: [Swithing to read Database](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/49), [Refactor previous implementation](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/52), [Adding logic support for new feature](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/53). But some exceed because we are working with new stuffs, such as new GUI, so the estimation was not correct: [GUI](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/57), [Another GUI](https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/50)

For iteration 3, the fixing part of the code can be estimated correctly: (Code refactor)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/70], but some of the estimation is not that good, mostly because we are dealing with new stuffs. For example, acceptance test that we have not written before: (Test 1)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/79], (Test 2)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/77], (Test 3)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/76]. Also, personally, I have to create another new GUI by myself, I was focusing on the backend stuff and this is new for me, so my time estimation was not good either (GUI page for comment for recipe)[https://code.cs.umanitoba.ca/winter-2022-a02/group-10/irecipe/-/issues/72]

So overall, if we are estimating the things we have done before, our time spend match our estimation. But we are not so good at estimating things that we have never done before.
