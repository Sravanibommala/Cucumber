Feature:  Mobile Purchase 

#Scenario: Samsung Mobile Purchase
#Given User launch the browser
#And User login into flipkart
#When User search for mobile
#And User handling the window
#Then User validate the product


#Scenario: Mobile Purchase using one dim list
#Given User launch the browser
#And User login into flipkart
#When User search for mobile with one dim list
| OnePlus |
| Iphone |
| Vivo |
#And User handling the window
#Then User validate the product

#Scenario: Mobile Purchase using one dim Map
#Given User launch the browser
#And User login into flipkart
#When User search for mobile with one dim Map
|Phone1| Apple |
|Phone2| Vivo |
|Phone3| Nokia |
#And User handling the window
#Then User validate the product


Scenario: All Mobiles 
Given User launch the browser
And User login into flipkart
When Use search All Mobiles "<Phones>"
And User handling the window
Then User validate the product

Examples:
|Phones|
|Samsung|
|Apple|
|vivo|