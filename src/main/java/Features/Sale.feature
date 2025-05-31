Feature: This feature file would add the product to cart and purchase it

  Background:
    Given Navigate to url
    And Provide "standard_user" and "secret_sauce" to login

    @AddProducts @ProductPage
    Scenario: Add Products to cart and purchase them
      Then User adds "Backpack,Bike Light,Fleece Jacket" products to my cart
#      And User Clicks on Cart Page
#      And User Click on "CHECKOUT"
#      And User provides "First Name","Last Name" and "Postal Code"
#      And User Click on "CONTINUE"
#      And User Verifies the Products
#      And User Click on "FINISH"
#      And Verify that Order has been placed Successfully


      @Sort @ProductPage
      Scenario Outline: Sort the items as the data provided
        Then Sort the products as "<Sort Type>"
        Examples:
          | Sort Type           |
          | Name (A to Z)       |
          | Name (Z to A)       |
          | Price (low to high) |
          | Price (high to low) |