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
- Employees can login to their account. XX getEmployeeServlet
- Employees can register for a new account. XX putEmployeeServlet
- Employees can submit a ticket (with price and description) for reimbursement. XX putTicketServlet
- Employees can view their past tickets. XX getPastTickets
- Employees can view pending tickets. XX getPostTickets
- Employees can view tickets ordered by date. XO DEFAULT FOR BOTH
- Managers can login to their account. XX getManagerServlet
- Managers can view all pending requests. XX getManagerPostTickets
- Managers can view past tickets for all employees in the company. XX getManagerPastTickets
- Managers can accept/deny reimbursement requests. XX putManagerPostTickets