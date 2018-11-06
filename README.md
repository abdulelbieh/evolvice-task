# evolvice-task
Java Practical Task for Evolvice

This Project is bulit using Spring boot.

I have developed 2 rest APIs, one for Car and the other one for the brand.

First you create Brand with request like this

  {
    "brand": "BMW",
    "externalId": "bm-x31",
    "firstReleaseYear": 2001,
    "lastReleaseYear": 0,
    "model": "X3",
    "notes": "Family Car"
  }
  
Then you create a car with request like this

{
  "brandId": "bm-x31",
  "externalId": "car-dummy1",
  "productionYear": 2008
}

** This task still needs writing more unit tests. i have just written for some of Repository layer.
** This task still needs to add some authentication with Spring security, and some metrics to monitor the app.

