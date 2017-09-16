Instruction for build and run the application as Spring boot


1) Make sure you have JDK 1.8 installed on your system
2) Clone from Git Hub Repo
3) Open windows console and change to the project root directory 
	cd <Your Local GIT Clone Dir>\demo_web_mvc\hbm_demo
4) Execute command to set the local JAVA_HOME environment variable to point at your JDK installation directory
	set JAVA_HOME=<Full Path To Your JDK Folder>
	e.g     set JAVA_HOME=C:\JDK
5) To build the project execute this command
	mvn.cmd clean compile package -f demo_root_mod/pom.xml 
6) Now you can run the program by execute the command (Just make sure on your local pc no other application 
   holding/listening on TCP port 8080, can check that with command: netstat -a -p tcp)
	startApp.cmd 
7) The application will attemp to create a local derby database folder in your current folder
	<Your Local GIT Clone Dir>\demo_web_mvc\hbm_demo\demo_db
8) Wait for the application to finish startup sequence
	-First it will create the database
	-It will execute the database schema creation script to create tables,indexes, key and sequence
	-Finally it will execute sameple data loading into the database.
9) After application completed the setup process, the application can now be access with a web browser at 
this address
	http://local:8080/
10) The first page will be the index page of the application which contain link to other demo page. 

At the moment the demo just do read from database only, no functionality to add or edit data.
However if you wish to load more of your own test data. That can be done following step below

a) update the sample_data.sql with test data by adding sql insert lines. The file is located in this directory

<Your Local GIT Clone Dir>\demo_web_mvc\demo_jpa_mod\src\main\java\META-INF\sample_data.sql
b) Save your changes to the file

c) Kill the app if it is still running so the JVM won't blocking file from being updated

d) Execute step 5 above to rebuild the packages (make sure your current working directory unchange). 

e) Start the application again like in step 6)

f) Repeat step 9 to test the application. 

***Note: Every time you stop and start the server again the application will automatically drop all your 
database schema and data and then recreate the schema and reload the sample data from the above file packed 
with demo_jpa_mod.jar This way you will alway start new

g) Schema script for the database creation and drop also in the same place as the Sample_data.sql. 
There 2 files name  create_schema.ddl for creating db schema objects and one named drop_schema.ddl for use
tp drop the db schema. Be mindful when you change those script the order of those entries in those files 
are important as it is related to the relationship between schema objects which have a particular order of
creation and different order when drop.




Application Demo 3 functions

1) shows all the current Person in the Person db table.
2) if a person has Claim records associated then it will show a button with a number indicate how many 
claims the Person have. Click on the button will expand the the table row to show a floating table which float 
below the selected Person record row. This collapsible table will show all the details of Claims the person have.
This demonstate a few web technologies

-Bootstrap CSS & Script
-JQueries to retrieve live data from server and dynamically update the front end.
-AJAX and JSON data exchange between server and UI front end.
-Great Thymeleaf Template engine and application framework. 
-Spring MVC.
-Spring Data JPA access framework.
-Last pure JPA with Hibernate provider.

I did a bit of configuration work to modify the module structure so that it can be deployed as WAR into 
a full JEE web app server like WebSphere.

3) Show a list of current Claims exist on  Claim table.


Due to time contrainsts I  have + with terrible flu so I didn't add unit test in, but that is not too hard
as the maven project structure I created already add in ability to test JUnit if you drop the source in 
the application test folders and maven will kick of the unit test during the build.






 