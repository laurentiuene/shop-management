# Shop management application

### Build

Before running the application it's mandatory to run a clean install so that temporary files of 
the mapstruct mappers are created.
>mvn clean install

### Run 

The application has an in-memory database that is re-instantiated at runtime. All tables with 
inserted data are present in the **data.sql** file located in the resources directory.

In order to access any of the endpoints in the application, you first have to call the 
**/authenticate** endpoint with the correct credentials
> Admin -> user: manager; password: password   
> User -> user: employee; password: password

You then use the newly created jwt in the header of every other call in the application. 
The only two endpoints that are accessible for only one of the users are **/product/all** and 
**/customer/all**. 

The **/product/all** endpoint requires you to be logged in with an user with ADMIN authority.  
The **/customer/all** endpoint requires you to be logged in with an user with USER authority.