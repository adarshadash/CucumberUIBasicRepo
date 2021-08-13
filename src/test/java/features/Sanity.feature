Feature: Search and place order for Vegetables

Background:
Given User is on Greencart Landing page

@RegressionTest
Scenario: Search for items and validate results
When User searched for Cucumber Vegetable
Then "Cucumber" results are displayed



@RegressionTest
Scenario Outline: Search for items and then move to checkout page
Given User is on Greencart Landing page
When User searched for <Name> Vegetable
And Added items to cart
And User proceeded to Checkout page for purchase
Then verify selected <Name> items are displayed in Check out page


Examples:
|Name	 |
|Brinjal |
|Beetroot|
