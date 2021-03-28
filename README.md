# World

A new Spring boot application.

## Getting Started

This project is a starting point for a Spring boot application.


## Information about the Application


Create a spring boot Docker application with Jre8
Application required to download image database https://github.com/ghusta/docker-postgres-world-db during build and connect to it during runtime


- Implement an endpoint which when given country code should return country information
Example  GET- http:/localhost:8088/BHR should return:
{
"name": "Bahrain"
"continent": "Asia"
"population":617000
"life_expectancy":73
"country_language":"Arabic"
}

- Create Unit Tests for the following tests
if nonexistent code is called then return error message: "INVALID_COUNTRY_CODE" and http response should be internal server error
if database is down then the error message should be "INTERNAL_ERROR" and http response should be internal server error

# How to run 
- Setup Docker environment on your machine following the steps on the official documentation https://docs.docker.com/get-docker/
- install JDK 8 and Maven and add both to your environments variables
- download the project from the repository as a Zip and unZip it
- open terminal Or cmd and go to the project root location
- run " mvnw clean package -DskipTests " without quotes
- run " docker-compose up " without quotes

# Accessing the Application
- you can access the postgre DB (pgAdmin) throw http://localhost:5433/
- DB Name : world-db
- DB Username : world
- DB Password : world123
- you can access the Application throw http://localhost:8088/

# Provided Apis
- http://localhost:8088/country/BHR should return:
  Single country
  {
  "name": "Bahrain"
  "continent": "Asia"
  "population":617000
  "life_expectancy":73
  "country_language":"Arabic"
  }
- http://localhost:8088/all/get-all-countries should return: all the countries in the DB as json List as the above example.