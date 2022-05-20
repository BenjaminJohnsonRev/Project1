# Project1
---Explanation and Overview:
Ben and Haruya's Project1 for Revature. It is an Expense Reimbursement Management System (ERMS) that seeks to allow 
employees to submit ticket for potential reimbursements. Managers will then approve or deny these tickets.

---Project Guidelines:

# Project One
For Project One, you are required to build a REST API that satisifies the requirements set forth in the Expense Reimbursement Management System document. Your ERMS must abide by following:

## Technology

* RESTful API built with Servlets
* Unit testing with JUnit
* Data stored in PostgreSQL database

## Other

* Complete approval process
* Discrete Data Access layer
* At least 90% test coverage for the data and service layers
* All Data Structures used must be custom-implemented (no using Java Collections)
* Demonstrate API using Postman

You will have 5 minutes to demo this to me and the rest of the cohort.

Due Date: 5-9-22


#### User Stories
- Employees can login to their account. 
- Employees can register for a new account.
- Employees can submit a ticket (with price and description) for reimbursement.
- Employees can view their past tickets. 
- Employees can view pending tickets. 
- Employees can view tickets ordered by date. 
- Managers can login to their account.
- Managers can view all pending requests. 
- Managers can view past tickets for all employees in the company.
- Managers can accept/deny reimbursement requests.

---Features:

- Employees can login to their account.
- Employees can register for a new account.
- Employees can submit a ticket (with price and description) for reimbursement.
- Employees can view their past tickets.
- Employees can view pending tickets.
- Employees can view tickets ordered by date.
- Managers can login to their account.
- Managers can view all pending requests.
- Managers can view past tickets for all employees in the company.
- Managers can accept/deny reimbursement requests.

---Technologies Used:

- Mockito
- JUnit
- Jupiter
- JDBC
- PostgreSQL

---How to set up / get started using it:

- Configure dbConfig.properties file and dbConfigTest.properties file with appropriate url, username, and password.
- This will allow you to connect to a database. Make sure your database exists before attempting to connect to it.
example: 
url=jdbc:postgresql://localhost:5432/project1 
username: postgres 
password: password
- Populate tables in your database. An SQL script is included in the project files under the name 'script.txt'.
- Simply copy and paste the contents of this script into a database visualization program like DBeaver.
- DBeaver is recommended to make implementing this script easy.
- Edit the Tomcat run configuration. Ensure you have Apache Tomcat version 8.5.78 installed. 
- Run Tomcat webapp.


---Usage of the Project

- Use a Servlet testing program like Postman to send HTTP requests easily.
- See postman.txt for parameters and json to use with Postman requests.

---Contributors

- Benjamin Johnson
- Haruya Maeda

---License information

MIT License

Copyright (c) 2022 Benjamin Johnson, Haruya Maeda

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


