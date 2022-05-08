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
- Employees can login to their account. XX getEmployeeServletX
- Employees can register for a new account. XX postEmployeeServletX
- Employees can submit a ticket (with price and description) for reimbursement. XX postTicketServletX
- Employees can view their past tickets. XX getPastTicketsX
- Employees can view pending tickets. XX getPostTicketsX
- Employees can view tickets ordered by date. XXX
- Managers can login to their account. XX getManagerServlet
- Managers can view all pending requests. XX getManagerPostTickets
- Managers can view past tickets for all employees in the company. XX getManagerPastTickets
- Managers can accept/deny reimbursement requests. XX putManagerPostTickets