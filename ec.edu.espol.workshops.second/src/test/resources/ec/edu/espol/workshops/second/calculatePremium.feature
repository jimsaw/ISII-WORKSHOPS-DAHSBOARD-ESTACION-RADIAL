  Feature: Calculate the insurance prime for a customer over 80 years old
  Scenario: The customer age is over 80 years old
   Given the customer's age is 85
   And The customer identification length is 10
   And the customer sexo is M
   And the customer marital status is true
   When I Calculate the premium
   Then “Age is not allowed to grant you insurance” and “Insurance not granted” and the premium should be -1

  Scenario Outline: The premium is or is not 400
   Given the customer's age is "<age>"
   And I am using the ci  "0911789654"   
   And I am using the sexo  "M"
   And I am using the marital status "t"  
   When I Calculate the premium
   Then I should be told "<premium>"
  
  Examples:
  	|age |premium |
  	|80	 |300     |
  	|81	 |-1      |
  	|45	 |300     |
  	|50	 |200     |
  	|55	 |200     |
  	|82	 |-1      |
  	
  	
  	
  	
  	
 Feature: Calculate the insurance prime for a customer with an incorrrect ci
  Scenario: the customer's identification is incorrect.
   Given the customer's identification length is longer than 10 numbers.
   And the customer age is 65
   And the sexo is M
   And the marital status is false
   When I Calculate the premium
   Then the premium is -1 and it is denied to the customer because the driver license isn't valid.
   
  Scenario Outline: The premium is or is not -1
   Given the customer's identification is "<ci>"
   And I am using the age  "65"   
   And I am using the sexo  "M"
   And I am using the marital status "n"  
   When I Calculate the premium
   Then I should be told "<premium>"
  
  Examples:
  	|ci           |premium |
  	|09789875845  |-1      |
  	|0978987584   | 500    |
  	|097898758455 |-1      |
  	|0987458785122|-1      |
  	|0951285024   |500     |  	  	  	  	
  	
  	
  	


 Feature: Calculate the insurance prime for a customer 45 or older, but younger than 65
  Scenario: the customer is 45 or older, but younger than 65
   Given the customer's age in the range of 45 to 65
   And the customer ci is a number of ten digits
   And the customer sexo is M
   And the customer marital status is false
   When I Calculate the premium
   Then the premium must be equal to 400
   
  Scenario Outline: The premium is or is not 400
   Given the customer's age is "<age>"
   And I am using the ci  "0911789654"   
   And I am using the sexo  "M"
   And I am using the marital status "n"  
   When I Calculate the premium
   Then I should be told "<premium>"
  
  Examples:
  	|age |premium |
  	|45	 |400     |
  	|64	 |400     |
  	|50	 |400     |
  	|80	 |-1      |
  	|30	 |500     |
  	|35	 |500     |