# Firemart_Shopping_Application
## Description
The Online Shopping is a console-based menu driven application that simulates online shopping experience. An employee can add Products. A Customer can place order on the products. The employee delivers the Product to the Customer and keeps updating the tracker to track the orders placed. Employee maintains products in the system. Customer has a order history and can also view products from categories and can add it to cart for checkout.
## Features
* Data is stored in a database.
* Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
* Service Layer need to be implemented which depends on Data Access layer for getting data from database.
* Presentation Layer (console) should depend on Service Layer to implement each feature.
* Inputs is received using the java.util.Scanner class.
* Log4j is implemented to log events to a file.
* JUnit test is written to test some functionality
## Technologies and Environments Used
* Java
* JDBC
* MySQL
* Maven
* Log4J
* Junit
## Getting Started
* Download and Install the Java 8 jdk provided by Oracle - https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html
* Download and Install the Eclipse Spring suite tool IDE to execute java code - https://www.eclipse.org/community/eclipse_newsletter/2018/february/springboot.php
* Download and Install the MySQL workbench - https://dev.mysql.com/downloads/workbench/
* Download and Install the Git Bash - https://git-scm.com/downloads
* Clone this code into your local storage using this url - https://github.com/Github-500/Firemart_Shopping_Application.git
## Implementation
Use Maven project environment for executing this code. Create a Database and Tables on MySQL workbench. After that, you need to use JDBC to connect to that created Database and Java application in order to manipulate(like send, retrieve etc.) the data from the Tables. As it is a console based application, you can directly execute the code using spring suite tool IDE. After executing code a console will appear which will guide you through the entire application steps, you can follow the steps and perform operations you want. 
