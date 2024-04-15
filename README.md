# QuizApplicationAPIs
 Welcome to the QuizApplicationAPIs documentation! This API provides endpoints to perform CRUD operations on  questions and generate random quiz questions from database based on the category of the questions.It also provides an API to calculate the result of the quiz.

# Technologies Used
# Java: 
Core programming language for backend development.

# Spring Boot: 
Framework for building robust and scalable Java applications.
Port Number-8080

# Spring Security: 
Provides authentication and authorization functionalities.

# Hibernate:
Object-relational mapping library for data persistence.

# MySQL:
Relational database management system for storing account information and transaction records.
Port Number:3306

# Maven:
Dependency management tool for Springboot projects.

# Lombok:
To reduce the boiler plate content.

# API Endpoints
# PostMapping(/api/questions): 
To create new question
# GetMapping(/api/questions/{category})
To get all questions with the given category name
# PutMapping(/api/questions/{id})
To update the question with the given questionId
# GetMapping(/api/questions)
To get all questions present in database
# DeleteMapping(/api/questions/{id})
To delete the question with given questionId
# PostMapping(/quiz/create?category=Java&numQ=5&title=Java)
To generate the 5 questions in the  quiz randomly
# GetMapping(/quiz/{id})
To get the quiz with the quizId
# PostMapping(/quiz/submit/{id})
To generate the result of the quiz
