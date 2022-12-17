Sumanth Mulenahalli Kalyan Kumar Lab 3 README

Below is the screenshot of the empty Input form 

![image](https://user-images.githubusercontent.com/20844481/191321626-76058424-701c-4b7b-b81d-b0eaa8916a6b.png)

If no details entered, and user still clicked submit, display errors
 
![image](https://user-images.githubusercontent.com/20844481/191323385-edfebda8-3a6c-4a02-a69a-d8262701c58c.png)

![image](https://user-images.githubusercontent.com/20844481/191325698-a84e05c7-a3ee-4ab9-8f4e-2aeec06a12eb.png)

Details entered into the form

![image](https://user-images.githubusercontent.com/20844481/191323088-f4a0304d-121e-4978-abc1-e70f5f171a83.png)

If invalid details are entered in form, error shows up

![image](https://user-images.githubusercontent.com/20844481/191321933-b2ef48fa-734c-4a7f-851f-d4581cb35d1f.png)

On entering correct details

![image](https://user-images.githubusercontent.com/20844481/191322218-2f161e54-659a-45d6-a44b-c390ba98d68e.png)

Details entered into the DB 

![image](https://user-images.githubusercontent.com/20844481/191323902-63732c19-137f-4e21-898f-76591d393497.png)

Payara server output

![image](https://user-images.githubusercontent.com/20844481/191326408-d44b41dd-7406-431d-863c-094cf9589f4e.png)

1. Your understanding of the difference between the forward and redirect operations.

   Ans: Forward is sending the data directly to other method, redirecting is sending the data and consecutive steps to new function.

2. How would you be validating user submissions without the Bean Validation API standard?

   Ans : By accessing the database tables and determining the changes.

3. How do you think this approach would scale to a real application with 100's of entities?

   Ans : Time taken for execution may increase as the number of entities increases. Dependencies can be managed.

4. Why didn't we need to include any additional dependencies (i.e. Bean Validation,JDBC) in this project?
   
   Ans : Because we use servlet, MVC for validation.
