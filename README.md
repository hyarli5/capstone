# capstone

Home Page: This page would include a brief description of the application and its features, along with an image, animation, or video to grab the user's attention. It should also provide options for users to either register or log in to their account.


Registration Page: This page would allow new users to create an account by entering their personal information, such as name, email address,  password , dateregistered. It should include validation checks to ensure that the user's password meets certain criteria, such as a minimum length or a mix of letters and numbers.


Login Page: This page would allow registered users to log in to their account by entering their email address and password. It could also include a "forgot password" feature in case the user forgets their login credentials.

Dashboard: This centralized page that provides an overview of the user's budget, including their income, expenses, categories, and budget. It could also display graphs or charts to provide a visual representation of their spending habits.

Expense Page: This page should allow users to add, view, edit, and delete their expenses, with columns Name (must be a dropdown list box ), Type, cost, DateOfExpense,and Balance=(TotalBudget - cost). It should provide alerts when spending exceeds budget and allow users to set reminders for bill payments or other deadlines. When the user enter cost and press Add Expense button, it should subtract the amount of TotalBudget and display their current balance. If the user exceeds their budget it should display a warning message.

Categories: This page should allow users to add, view, edit, and delete their categories, with columns categoryName,categoryDesc, creationDate. categoryName must be displayed in Expense Page as dropbox.

Income Page: A page that allows users to save and cancel their income sources, with columns for the incomeName, incomeAmount, savings, budget(incomeAmount- savings = budget) and creattiondate.Whenever new income is added it must update total_incomeamount, total_savings, TotalBudget  Users should be able to generate reports on their income, Savings, Balance based on date range, month and year.

Reporting Page: This page would allow users to generate various reports on their expenses, category, budget, and income. It could include filters for the report, such as by category, by date range, or by comparing expenses weekly, monthly, and yearly. The page could display the report in a visual format, such as a pie chart or line graph, and highlight expenses that exceed a certain threshold with different colors.

Income Tax and EMI Calculator: The application should include calculators for income tax and EMI to help users calculate their taxes and loan payments.(next sprint)

Simple Calculator: The application should include a simple calculator for basic mathematical calculations.(next sprint)

Logout: When the user wants to log out, the application should ask for confirmation before logging the user out of their account.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

Used react js(yet to use), html, css ,javascript, java,junit, mockito,thymeleaf, mysql, servlets, hibernate, jpa, spring mvc, spring boot, rest api, maven, git, eclipse ide, jenkins(yet to use)

 project of personal expenses management



-------------------------------------------------------------------------------------------------------------------

Integration

Used Git and need to use Jenkins for version control and continuous integration.

Used Spring Boot to create a RESTful API that provides CRUD operations for expenses, categories, income sources, and user accounts.

Used Thymeleaf to create templates that render the user interface for the application.

Integrated the front-end and back-end components by using HTTP requests to send data between the client and server.

Used JUnit and Mockito to write unit tests for the APIs.

Tested the application thoroughly by simulating different user scenarios, such as creating, updating, and deleting expenses, categories, and income sources.

Used tools like Postman to test the API endpoints and ensure that they are working correctly.

Monitored the application's performance and identify and fix any bugs or issues that arise.

Need to Deploy the application to a production environment and continue to monitor and maintain it to ensure that it is running smoothly.

---------------------------------------------------------

An User opens Category page  prepares a category_list and description(like type of category it belongs to ) than opens Income page in which he enters his incomeamount and type of income(salary, rentalincome, etc) and enters savingsamount, then the budget column needs to automatically calculate incomeamount-savingsamount = budget. if he did not enter savings or income it must be default 0 amount .must not take negative values and also must allow only decimal data type.for that it must automatically add total budget and total savings, whenever incomeamount and savingsamount is entered.
then User opens expense page to select categoryName which is a dropdown box and the list contains is the one which is category_list from Category page . he can only select from this box but cannot enter any data. he can enter type and the amount (only decimal datatype, no negative values). whenever the amount is entered it must substract the total budget in Income page. if the amount entered  is above 200 dollars it must ask for confirmation. if the total budget in income page is <=5000 dollars it must give warnings. it must generate reports weekly, monthly, yearly, by given date. and must generate charts red danger, yellow near danger level , green or blue safe.
Use html, css, javascript, bootstrap, thymeleaf, java, springmvc, springboot, jpa,Hibernate, junit, mysql, maven.

Entity classes:
User
Category
Income
Expense
Report
Repository interfaces:
UserRepository extends JpaRepository<User, Long>
CategoryRepository extends JpaRepository<Category, Long>
IncomeRepository extends JpaRepository<Income, Long>
ExpenseRepository extends JpaRepository<Expense, Long>
ReportRepository extends JpaRepository<Report, Long>
Controllers:
UserController
CategoryController
IncomeController
ExpenseController
ReportController
Services:
UserService
CategoryService
IncomeService
ExpenseService
ReportService
ServiceImpl:
UserServiceImpl
CategoryServiceImpl
IncomeServiceImpl
ExpenseServiceImpl
ReportServiceImpl
Views:
category.html
income.html
expense.html
report.html


