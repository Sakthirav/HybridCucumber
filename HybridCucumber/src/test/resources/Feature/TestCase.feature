Feature: To test the orangehrm application

Scenario Outline:
Given To launch the application and navigate to url
When Enter "<username>" and "<password>"
Then To click the submit button
And To close the browser and take screenshot
Examples:
|username|password|
|Admin|admin123| 
|john|john456|