# CPF Analyzer

O CPF Analyzer was created to meet the needs of the ecommerce anti-fraud analysis team.
Its main objective is to replace the spreadsheet that the team uses to verify CPFs at risk of fraud, through the
development of a system that controls CPFs by adding them to a restricted list.


## What you need
[Java 1.8](https://www.oracle.com/java/technologies/downloads/) or later 
[Maven 3.5+] (https://maven.apache.org/download.cgi)
MySQL
Postman

## Usage

First you need to create a database, the credentials are 
``` 
database: cpfanalyzer
Username: root
Password: root
```

After this, you can run the application and test the endpoints through Postman.

## Motivations

The application was created using Java programming language and its framework spring boot. 
By using the framework, it is possible to use its advantages, such as JPA, MVC, integration with Rest API and Hibernate,
witch all was used to build CPF Analyzer.

