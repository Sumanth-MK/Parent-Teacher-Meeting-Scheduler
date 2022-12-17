Sumanth Mulenahalli Kalyan Kumar - Final Project Readme


--------------------------Project Summary -------------------- 

The project is called "School Meeting Scheduler". The project is used by parents and teachers to access the school
system and view the Parent Teacher meetings scheduled. The teacher can login and perform actions like view student details, add a new student, 
and Schedule a Meeting with the parent of the students. The parent can login and view the meeting details .
This was fulfilled using 4 entities Student,Parent,Teacher and Meeting. Meeting entity contains all the details like Date,Time, and the type 
of Meeting, which describes the purpose of the Meeting. Student will have details like ID, Name, DOB, Course taken, and the GPA.
There are 3 security groups called Parent, Admin, and Teacher. Admin will have the highest privileges, and can create Teacher and Parent.

----------------------Design -----------------------

Below is the ER diagram for the project. 

![Final Project design](https://user-images.githubusercontent.com/20844481/206887774-873bc3de-d804-4cc6-990b-11e9b13330d8.png)

Many to Many Bi-directional relation between Student and a Teacher – One student can be 
enrolled under many teachers and one teacher can have many students.

Many to One Bi-directional relation between Student and Parent – One student can have father/mother 
as parents in the school.

One to Many Uni-directional relation between Student and Meeting – One student can have 
multiple meetings setup.

------------------- Requirements-----------------------

For this project we are using Apache netbeans as IDE, payara server, Mysql for database and persistence JPA, Maven, Jakarta validation, 
Junit Jupite, Jboss Logging and opentest4j

-----------------------------Screen Captures--------------------------------------

1. First login page after running the project

![image](https://user-images.githubusercontent.com/20844481/206887565-2fb8e1a8-36d4-4066-8a42-724930763914.png)

Admin Screenshots

1. First page after admin login

![image](https://user-images.githubusercontent.com/20844481/206887597-6a2ce501-8421-48c3-b0de-902849bcf00d.png)

2. On clicking Admin tab on the nav-bar

![image](https://user-images.githubusercontent.com/20844481/206887610-10c9ae35-1731-451d-9d88-2da86ef71cf9.png)

2a. On Clicking Add New Parent

![image](https://user-images.githubusercontent.com/20844481/206887641-f252e50e-d4bd-4839-83f1-abece141d556.png)

2b. If no data entered

![image](https://user-images.githubusercontent.com/20844481/206887666-17e8b865-96e1-45dc-98ad-37450154d37e.png)


2c. On Clicking Add New Teacher

![image](https://user-images.githubusercontent.com/20844481/206887698-c94d2fdc-0a74-4acf-8558-f2bd0f60a284.png)


3. On logging in with parent1

![image](https://user-images.githubusercontent.com/20844481/206887737-b09892f5-d2fc-4b30-98b3-504909d17270.png)

3a. On clicking Parent tab on the nav-bar

![image](https://user-images.githubusercontent.com/20844481/206887752-8831bcbf-fec8-480a-9476-1302effbde46.png)


4. On logging in with teacher1

![image](https://user-images.githubusercontent.com/20844481/206887798-48ab5dd8-1557-4091-bc23-44e054685ba8.png)

4a. On clicking the teacher tab on the nav-bar

![image](https://user-images.githubusercontent.com/20844481/206887812-50988405-a700-4ed0-a24f-a92c87a36ee2.png)

4b. On clicking the Add new Student 

![image](https://user-images.githubusercontent.com/20844481/206887832-d43a3638-31eb-4899-a1a8-b082b6f9023e.png)

4c. If no data added, 

![image](https://user-images.githubusercontent.com/20844481/206887855-28ab8d2d-ebed-4db7-862f-2ad6acafa309.png)


4d. If data is added successfully, 

![image](https://user-images.githubusercontent.com/20844481/206887886-a61c637e-c927-4cdc-88da-f676296d9c7e.png)

4e. On clicking the read option in the student table

![image](https://user-images.githubusercontent.com/20844481/206887905-273e8b5c-3355-41bc-9572-ae589e395775.png)


4f. On clicking the update option in the student table

![image](https://user-images.githubusercontent.com/20844481/206887929-9e2e2136-d12c-470d-bef5-59549d81c62a.png)

4g. On clicking the delete option in the student table

![image](https://user-images.githubusercontent.com/20844481/206887951-a6eb24c1-0d88-4fe4-8c0d-96e5fdcd2d1f.png)

4h. On clicking the Schedule Meeting 

![image](https://user-images.githubusercontent.com/20844481/206887986-2cf89c15-b60c-4ec6-899f-624da08174b6.png)

4i. After scheduling the meeting

![image](https://user-images.githubusercontent.com/20844481/206888018-b096608a-83fa-4f73-8c32-6b5938b8f2a1.png)

4j. On clicking View Meeting

![image](https://user-images.githubusercontent.com/20844481/206888056-8119e424-ec36-491d-a08e-f63b2408fa3d.png)

4k. On clicking Modify Meeting

![image](https://user-images.githubusercontent.com/20844481/206888089-a888d910-5fed-4380-b15e-a439ebf88422.png)

4l. After modifying the meeting

![image](https://user-images.githubusercontent.com/20844481/206888116-fda36ed9-30fb-4798-9d8b-835bb135c472.png)

4m. On clicking Delete Meeting 

![image](https://user-images.githubusercontent.com/20844481/206888131-f3ffc3d7-1176-4cf8-8e5a-ae6eac5832cb.png)

4n. After deleting the meeting

![image](https://user-images.githubusercontent.com/20844481/206888145-d2b9842d-15a5-4295-bef6-cddf3ebc0fa4.png)

5. After clicking Logout

![image](https://user-images.githubusercontent.com/20844481/206888159-ccc3d060-b235-4a23-bb0b-e91f0b0683c9.png)


-----------------Expected Results/Known Issues--------------------

Every expected results are shown in the screen captures. An issue in the system is that someone should know atleast know one of the credentials, since this is an internal and secure system, and ther is no signup functionality.

Below are the steps 
1. Run the project from Netbeans. Make sure your MySQL server and Payara server are up and running.
2. This will launch a browser. Enter the credentials mentioned below, based on the user role that you need to login
      Username - Password
      admin - admin
      teacher1 - teacher1
      teacher2 - teacher2
      parent1 - parent1
      parent2 - parent2
      parent3 - parent3
      parent4 - parent4
      parent5 - parent5
      parent6 - parent6
 
3. If you are logged into admin, use the Add new Parent/Add new Teacher buttons to create new parents or teachers respectively. Here you can also view every meeting and student details.
4. If you are logged into teacher, use the Add new student button to a new student and use different functionality like view, update and delete students. You can also schedule a meeting fot the logged in teached with the selected student.
5. If you are logged into parent, use the parent tab on the top to display all the meetings scheduled for the logged in parent

---------------------Development Insights ------------------

Any information pertaining to the hotel, the administrator, the client, and all booking-related information will be displayed in this area.
I was able to improve my understanding of JAVA EE standards, database persistence, security, and presentation components thanks to this particular course and the project. I gained a thorough understanding of the JPA Query Language, JPA annotations, authorization, and authentication. I also discovered how to create web services based on EJB components, among many other ideas. Despite the fact that I am extremely new to Java, I really liked the ideas and the method you taught. I am confident that I will use Java and many other ideas successfully in the future and that I will continue to study more about hibernate after completing the project and the tasks.
Thank you very much, professor. I will definitely benefit from the lectures you taught in the future.



