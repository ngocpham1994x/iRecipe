What technical debt has been cleaned up
========================================

Show links to a commit where you paid off technical debt. Write 2-5 sentences
that explain what debt was paid, and what its classification is.

What technical debt did you leave?
==================================

Technical dept is the dept caused by adopting easy way to develop a product which later needs to be refactored. In our project, there are some of the technical depts and one of them is not having specific Id for all the cards in `AdapterMainPage.java`. we are using array to store all the informaiton of cards and for positioning of the cards, because of this we are using `withText` in system tesing files instead of using `withId`. In future if developer's team wanted to change the GUI and edit the text on the cards, then they also have to modify the testing files otherwise the code will throw the error. We are not going to fix it because we have to change alot of things in our logic layer, so we decided to move forward with this technical dept.

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

Did your estimates get better or worse through the course? Show some
evidence of the estimates/actuals from tasks.
