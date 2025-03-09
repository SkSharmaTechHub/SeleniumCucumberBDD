Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing page
When User searched with Shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page
And Validate product page in Offer Page matches with Landing Page

Examples:
| Name |
| Tom  |
| Strawberry |