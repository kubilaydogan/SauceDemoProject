Feature: Shopping Cart Functionality
"""
        	Log into the site
        	Sort the items
        	Add two or more items to the shopping cart
        	Visit the shopping cart
            •	Assert that the items that you added are in the cart
        	Remove an item and then continue shopping
        	Add another item
        	Checkout
            •	Assert you are purchasing the correct items
            •	Assert the total price
            •	Finish checkout•
"""

  Scenario Outline: Validate shopping cart
    Given user is on landing page
    When user log into the site
      | username | standard_user |
      | password | secret_sauce  |
    And user sort the item by "<sort_type>"
    And user add "<item1>"
    And user add "<item2>"
    And user add following items
      | item    |
      | <item3> |
      | <item4> |
    And user navigates to the shopping cart
    Then verify that the added items are present in the cart
      | <item1> |
      | <item2> |
      | <item3> |
      | <item4> |
    When user removes "<item3>" from shopping cart
    And clicks on "Continue Shopping"
    And user add "<item5>"
    And user navigates to the shopping cart
    And clicks on "Checkout"

    Examples:
      | sort_type           | item1                   | item2               | item3                 | item4                    | item5             |
      | Price (high to low) | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Fleece Jacket | Sauce Labs Onesie |
