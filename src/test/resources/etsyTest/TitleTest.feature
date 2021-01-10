@regressiontest

Feature: Validating Title for each page

  @TEC-2004

  Scenario Outline: Validating titles
    Given User navigates to Etsy application
    When User click on "<department>" part
    Then User validates "<title>" title
    Examples:
      | department            | title                         |
      | Post-Holiday Sales    | Post-holiday sales\| Etsy     |
      | Jewelry & Accessories | Jewelry & Accessories \| Etsy |
      | Clothing & Shoes      | Clothing & Shoes \| Etsy      |
      | Home & Living         | Home & Living \| Etsy         |
      | Wedding & Party       | Wedding & Party \| Etsy       |
      | Toys & Entertainment  | Toys & Entertainment \|       |
      | Art & Collectibles    | Art & Collectibles \| Etsy    |
      | Craft Supplies        | Craft Supplies      \| Etsy   |
      | Gifts                 | Gifts                \| Etsy  |