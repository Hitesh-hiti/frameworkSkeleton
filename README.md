# QE Mobile/Web UI Automation Framework
![](https://user-images.githubusercontent.com/85150722/229034663-72672be6-5043-4a88-b021-290717a1449d.jpg)

# Using Appium to Automate UI Testing of Android and iOS Apps with Java

## Overview

#### Key features of framework used  : 
-  Page Object Model 
 - Java : most convenient programming language for me
 - Maven: For build managemnt purpose, a common structure can be maintained very easily
 - Appium: Open source, most convenient native mobile app automation tool
 - Allure Reports : As it is most clean automation reports and provides lots of useful annotations as well. For better documentation, it has been chosen over other reporting tools
 - Lombok plugin : It provides very simple logging framework as compared to other logging methods
 - It automatically starts appium server and kills its instance after tests are executed
 



### Reasons for choosing the framework : Page Object Model
- According to Page Object Model, we should keep our tests and element locators separately, this will keep code clean and easy to understand and maintain.
- The Page Object approach makes test automation framework programmer friendly, more durable and comprehensive.
- Another important advantage is our Page Object Repository is Independent of Automation Tests. Keeping separate repository for page objects helps us to use this repository for different purposes with different frameworks like, we are able to integrate this repository with other tools like like TestNG/Cucumber/etc.
- Test cases become short and optimized as we are able to reuse page object methods in the POM classes.
- Any change in UI can easily be implemented, updated and maintained into the Page Objects and Classes.
- Easily Scalable approach

### Adavntages of POM framework?
- Advantages of POM are expalined above. Here are few disadvantages of POM approach
- If there is an application with hundreds or thousands of web pages than the time and the effort in the development of automation framework will be high.
- The cost increases when maintenance overhead increases which are due to the maintenance of large class as they break the OO design principle.
- The development of POM framework for multiple pages is equal to developers work thus testers should be highly knowledgeable in programming best practices.
- Page object model is not a generic model and its specific to the applications.


### Few best Coding practices are followed while writing automation script: 
- KISS (Keep it simple, stupid)
- YAGNI (You are gonna need it)
- DRY (Don't repeat yourself) : by providing reusbale functions 
- Static methods
- OOPS concepts

### Some tips on how to make sure your code is maintainable by other team members?
- In POM framework, it is very easy to understand for everyone so any one can contribute without investing much time on understanding it
- Having proper and meaningful package names, it is very easy to find them and use them
- Use comments wherever needed
- descriptive variable, method, class names
- Use design patterns 

### What is Appium? 

Appium is an open source test automation framework for use with native, hybrid and mobile web apps. 
It drives iOS, Android, and Windows apps using the WebDriver protocol. Appium is built on the idea that testing native apps shouldn't require including an SDK or recompiling your app. And that you should be able to use your preferred test practices, frameworks, and tools. Appium also has made design and tool decisions to encourage a vibrant contributing community.

### Why Appium? 

As a test developer it is quite hard to create a good automated test suite that works on the iOS and Android platforms. Both Android and iOS have a couple of different test frameworks that work well but have nothing to do with each other. So you then have to create and maintain two separate test suites, one for Android and one for iOS. They are also written in different languages and with different development tools (IDEs) so even if the applications work the same it is hard to share any code between the tests for the different platforms.
But this is where Appium comes in. From Appium's own website:

Appium is “cross-platform”: it allows you to write tests against multiple platforms (iOS, Android), using the same API. This enables code reuse between iOS and Android testsuites.

## What's in this repository? 

This repository contains a minimalistic Appium Test Suite written in Java that runs a few simple tests on [this Android app](https://github.com/QualityWorksCG/Quality-Works-Sample-Android-app) and [this iOS app](https://github.com/QualityWorksCG/Quality-Works-Sample-iOS-App). To run the tests successfully you'll need have the .apk and the .app file of both apps so I'd recommend having those in place before getting started here if you want to see the tests run on those apps, otherwise this can be used as a starting point for your own Test Suite. 

### Technology stack:
  * TestNG (test runner)
  * Appium (mobile testing)
  * Selenium (web app testing)
  * REST-assured (REST API testing)
  * Allure (reporting)

## Reporting
1. Generate report `mvn site`
2. Deploy jetty `mvn jetty:run`
3. Reports should be accessible on port 8080

![alt text](http://i.imgur.com/bezAgFm.png "Allure report")
