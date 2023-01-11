Check generator is console application that creates checks like in shop.
The data about products (name, price, participation in action) and customer discount cards is being got from PostgreSQL database. 
To set DB params you may use class ConnectionToDB
Constructor(dbURL + dbName, dbUser, dbPassword).

appTables.sql - file, to create DB for this app is attached.

App runs from JAVA CLASS CheckRunner.

After running the program in class CheckRunner,
you should type in console:
"new" - to create new receipt;
"exit" - to exit from program;

after starting of new check creation, you'll be
asked to choose the way of data input,
just type:
"auto" - and information for check creation will be
automatically uploaded;
"txt" - for txt - file;
"json" - if you decide to upload json - file, and it has
several order examples, you'll be asked to choose which one
would you like to upload;
"console" - to input order from console.

The set of parameters should have product id – quantity  card – curd number.
Example: 4-8 5-2 1-1 3-1 card-000012

Some products are participating in promotion: if their amount in the check is more than 5, there is 10% discount on this item. The discount on the customer's card is also taken into account. 
This all is reflected in the check.

Files input1.txt and input2.json are attached to test how the program works with files.

Patterns Factory, Builder, Decorator are used I this application.

