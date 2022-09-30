# Introduction

This is improved version of the code base located at (https://urldefense.com/v3/__https:/drive.google.com/file/d/1lnvKu3JTwuIBFwbqZv907PvCcKy7huUJ/view?usp=sharing__;!!M7QLJmrK_5o!TCaLOY2qfUxf8ydOl-_yuoY67hdkbJcA0ogJgywTo6n1KixwhfgZke2UamMfEPiJlGNR5i0UjegaKPh08BlAElXiLA$)

## Instructions
* **Consider this to be your project! Feel free to make any changes**
* There are several deliberate design, code quality and test issues in the current code, they should be identified and resolved
* Implement the "New Requirements" below
* Keep it mind that code quality is very important
* Focus on testing, and feel free to bring in any testing strategies/frameworks you'd like to implement
* You're welcome to spend as much time as you like, however, we're expecting that this should take no more than 2 hours

## `movie-theater`

### Current Features
* Customer can make a reservation for the movie
  * And, system can calculate the ticket fee for customer's reservation
* Theater have a following discount rules
  * 20% discount for the special movie
  * $3 discount for the movie showing 1st of the day
  * $2 discount for the movie showing 2nd of the day
* System can display movie schedule with simple text format

## New Requirements
* New discount rules; In addition to current rules
  * Any movies showing starting between 11AM ~ 4pm, you'll get 25% discount
  * Any movies showing on 7th, you'll get 1$ discount
  * The discount amount applied only one if met multiple rules; biggest amount one
* We want to print the movie schedule with simple text & json format
