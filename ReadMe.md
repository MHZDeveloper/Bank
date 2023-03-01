# Getting Started with Spring Boot

You will find [here](https://docs.google.com/presentation/d/10XUBpq-KUU75EI_o6c4rHLtps8zAKw9EY18aj6NrGtg/edit?usp=sharing)
the presentation of this session.

**"Bank"** is a mini project that lets you create a bank account, deposit and withdraw money and of course see your current balance.

## Building

Building this project requires the following tools:
* Git (obviously)
* JDK 11
* Maven 3.3.9

Below, you'll find the steps to clone the project on your pc 
(or you can download it) and run it :
```
 $ git clone https://github.com/MHZDeveloper/Bank.git
 $ cd Bank
 $ mvn spring-boot:run
```
Use postman to trigger API endpoints :
* POST : http://localhost:8080/api/bank-account/{amount}
* GET : http://localhost:8080/api/bank-account/{id}
* PUT : http://localhost:8080/api/bank-account/{id}/deposit/{amount}
* PUT : http://localhost:8080/api/bank-account/{id}/withdraw/{amount}

PS : you can also browse to [http://localhost:8080/actuator](http://localhost:8080/actuator) to see the endpoint metrics.


Enjoy !! :)