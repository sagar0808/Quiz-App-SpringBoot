# Quiz App Backend - Spring Boot

This repository contains the backend implementation for a **Quiz App** built with **Spring Boot**. The app provides APIs for creating quiz sessions, retrieving random questions, submitting answers, and getting the results. Additionally, we have included SQL queries to populate the database with Java programming-related questions.

---

## Features

- **Start a new quiz session**: Initialize a new quiz for a user.
- **Fetch random multiple-choice questions**: Retrieve random questions for the quiz.
- **Submit answers for evaluation**: Submit answers to the questions and get them evaluated.
- **Retrieve results**: Show total questions answered, correctness, and evaluation.

---

## Prerequisites

Make sure you have the following installed:

- **Java Development Kit (JDK 11 or higher)**
- **Spring Boot Framework**
- **Maven**
- **H2 Database (Here used in memory)**

---

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/sagar0808/Quiz-App-SpringBoot.git
cd Quiz-App-SpringBoot
```

### 2. Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### 3. Database Configuration

1. Open the h2 console database in browser

```brower
http://localhost:8080/h2-console
```

2. Database Url

```bash
jdbc:h2:mem:test
```

3. Adding Question in Database

```sql
INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (1, 'A', 'public static void main(String[] args)', 'public void main(String args)', 'static public main(String[] args)', 'void main(String args[])', 'What is the correct method signature for the main method in Java?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (2, 'B', 'A variable that is accessible only within the class', 'A variable that is shared among all instances of a class', 'A variable that is passed to methods as an argument', 'A variable declared without initialization', 'What is a static variable in Java?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (3, 'C', 'Overriding is redefining a static method', 'Overloading occurs at runtime', 'Overloading means having multiple methods with the same name but different parameters', 'Overriding means creating a method with the same signature in a subclass', 'What is method overloading in Java?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (4, 'D', 'Interface', 'Abstract class', 'Concrete class', 'All of the above', 'Which types of classes can implement interfaces in Java?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (5, 'A', 'To improve code readability and avoid redundancy', 'To decrease code readability', 'To slow down runtime execution', 'To make Java less secure', 'Why is inheritance used in Java?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (6, 'C', 'Garbage Collection', 'Multithreading', 'Encapsulation', 'Polymorphism', 'Which OOP concept is used to restrict access to certain parts of an object and only expose necessary information?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (7, 'B', 'Throwable', 'Exception', 'RuntimeException', 'IOException', 'Which class in Java represents a checked exception?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (8, 'D', 'The class keyword', 'The extends keyword', 'The implements keyword', 'The instanceof keyword', 'Which keyword is used to check whether an object is an instance of a particular class in Java?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (9, 'A', 'Bytecode is platform-independent', 'Java runs only on Windows', 'Java compiles directly to machine code', 'Java cannot be used on mobile devices', 'Why is Java considered platform-independent?');

INSERT INTO question (ID, CORRECT_ANSWER, OPTIONA, OPTIONB, OPTIONC, OPTIOND, QUESTION_TEXT)
VALUES (10, 'C', 'Java Runtime Environment', 'Java Standard Edition', 'Java Development Kit', 'Java Enterprise Edition', 'Which Java tool is used to compile and run Java programs?');

```
---

### API Endpoints

## 1. Start New Quiz Session

Endpoint: 
- POST
```api
http://localhost:8080/api/quiz/start?userId=1010
```

## 2. Get a Random Question

Endpoint: 
- GET

```api
http://localhost:8080/api/quiz/question
```
We will get Question with option in Response Body like this
```
{
  "id": 2,
  "questionText": "What is 2 + 2?",
  "optionA": "3",
  "optionB": "4",
  "optionC": "5",
  "optionD": "6"
}
```


## 3. Submit Answer

Endpoint: 
- POST
```api
http://localhost:8080/api/quiz/submit?userId=1010
```

(Before Submiting Answer Remember Question Id and Option)

- Response Body

```response body
{
  "questionId": 2,
  "selectedOption": "B"
}
```

## 4. Get Quiz Results

Endpoint: 
- GET
```api
http://localhost:8080/api/quiz/session?userId=1010
```


