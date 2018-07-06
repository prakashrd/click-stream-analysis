# Click-Stream-Analysis
*WIP*

Originally this challenge and the scope of the work was posted at [Click Stream Challenge](https://github.com/prakashrd/spark-challenge-public). 
The challenge is to analyse the click stream and derive analytics on user click count and product category count.
By the time i started doing this project the data files were removed so just borrowed the idea to do this activity.

## Development
### Setup Local Development Environment ( without Docker )
 1. Install [Java8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 1. Install [Maven](https://maven.apache.org/install.html). Maven is required for device detection using [DeviceAtlas](https://deviceatlas.com/) Java API.
 1. Install [Scala](https://www.scala-lang.org/download/install.html).
 1. Install [sbt](http://www.scala-sbt.org/release/docs/Setup.html)
 

## Overview
### Inputs
1. *Click Stream Data* CSV file having wide variety of data, only the columns of interest are listed here
    - Text Files
    - Schema
    
    
     Column	| Field
    --------|-------
    C1	|timestamp
    C2	|ip address
    C3	|url from products table
    C4	|SWID from users table
    C5	|city
    C6	|country
    C7	|state
    
1. *User Data* user information with following schema
    - CSV Text files
    - Schema
    
    
    SWID    | BIRTH_DT |  GENDER_CD
    --------|----------|------------
    String  | String   | String
    --------|----------|-----------
    
1. *Products* The product data set has the url and the category it belongs to
    - CSV Text files
    - Schema
    
    
    Url    | Category
    -------|----------
    String | String
    -------|---------
    
 ### Output
 
 It shall output three data sets
 1. Total number of clicks and distinct users (SWID) per day (TSV)
 1. Total number of clicks per product category (TSV)
 1. Data for customer service (JSON)

