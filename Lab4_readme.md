Sumanth Mulenahalli Kalyan Kumar Lab4 Readme

Paragraph that describes the business domain you have chosen to work with, and why.

Business Domain Name - Education
    Education domain is a very huge system that is built and managed. These days with everything 
being online, the students are in need of an online portal to submit their assignments, notes and the teachers are finding
it hard to inform the grades offline. This system will help in providing solutions to all of these.


There is only one entity required for Lab 4, but what other entities from your business domain can you think of? 
    I would think of 2 more entities
        1. Teacher - Teacher will have an ID,name,DOB and all the subjects that they'll be teaching. They might relate to
            student by grading the tests, posting the assignments.
        2. Co-ordinators - This is an entity which uses this system for announcements and alert the students for any information



**Test Cases:**
**Test Create**
#Create
   public void createTest(){
        Student test = new Student("TestStudent", LocalDate.of(1996, Month.JULY, 5), StudentClass.FIRST);
        tx.begin();
        em.persist(test);
        tx.commit();
        
        Student createStudent = em.createQuery("select s from Student s where s.name = 'TestStudent' ",Student.class).getSingleResult();
        assertNotNull(createStudent);
        assertTrue(createStudent.getUsn()>0);
        tx.begin();
        em.remove(createStudent);
        tx.commit();
    }
 //In this block we are creating a new row and checking if its available  
 ----------------------------------------------------------------------------------------------------
**Test Read**
 #Read
    public void readTest(){
    
        // read an entity from the database
        Student readStudent = em.createQuery("select s from Student s where s.name = 'Test' ",Student.class).getSingleResult();
        // assert if we read the right one
        assertEquals("Test",readStudent.getName());
    
    } 
//In this block we are using select query to find the given value from the table
-----------------------------------------------------------------------------------------------------
**Test Update**
#Update
    @Test
    public void updateTest(){
        
        Student updateStudent = em.createQuery("select s from Student s where s.name = 'Test' ",Student.class).getSingleResult();
        tx.begin();
        updateStudent.setSclass(StudentClass.SECOND);
        tx.commit();
        
        Student compare = em.find(Student.class, updateStudent.getUsn());
        assertEquals(StudentClass.SECOND,compare.getSclass());
    }
//In this block we are updating a row in the table and checking if it gets updated in the database
----------------------------------------------------------------------------------------------------
**Test Delete**
#Delete
    public void deleteTest(){
        Student deletestudent = new Student("Test", LocalDate.of(1996, Month.JULY, 5), StudentClass.FIRST);
        tx.begin();
        em.persist(deletestudent);
        tx.commit();
        
        assertNotNull(deletestudent.getUsn());
        
        tx.begin();
        em.remove(deletestudent);
        tx.commit();
    
        Student studentDeleted = em.find(Student.class, deletestudent.getUsn());
        assertNull(studentDeleted);
    
    }      
//In this block we are creating a new row and deleting it.
-----------------------------------------------------------------------------------------------
**Test Invalid Name**
    public void invalidNametoFail(){
        Student test = new Student("", LocalDate.of(1996, Month.JULY, 5), StudentClass.FIRST);
        Set<ConstraintViolation<Student>> violations = validator.validate(test);
        for (ConstraintViolation<Student> violation : violations) {
            System.out.println(violation.toString());
        }
        assertEquals(2, violations.size());
        assertEquals("must not be blank", violations.iterator().next().getMessage());
    }
  
//In this block we are passing empty name in the column Name and checking for violation
  -----------------------------------------------------------------------------------------------
**Test Valid Name**
    public void validNametoPass(){
        Student test = new Student("Test1", LocalDate.of(1996, Month.JULY, 5), StudentClass.FIRST);
        Set<ConstraintViolation<Student>> violations = validator.validate(test);
        for (ConstraintViolation<Student> violation : violations) {
            System.out.println(violation.toString());
        }
        assertEquals(0, violations.size());
    }
  //In this block we are passing the correct value and checking for violation
  ----------------------------------------------------------------------------------------------------------
  **Test Invalid Date**
    public void invalidDateOfBirthtoFail(){
        Student test = new Student("Test", LocalDate.of(2022, Month.DECEMBER, 5), StudentClass.FIRST);
        Set<ConstraintViolation<Student>> violations = validator.validate(test);
        for (ConstraintViolation<Student> violation : violations) {
            System.out.println(violation.toString());
        }
        assertEquals(1, violations.size());
    }
    
  //Future date is passed in Date of Birth column
  ---------------------------------------------------------------------------------------------------------------
 ***Test Valid Date***
    public void validDateofBirthtoPass(){
         Student test = new Student("Test", LocalDate.of(1996, Month.JULY, 5), StudentClass.FIRST);
        Set<ConstraintViolation<Student>> violations = validator.validate(test);
        for (ConstraintViolation<Student> violation : violations) {
            System.out.println(violation.toString());
        }
        assertEquals(0, violations.size());
    
    }
    
  //Past or present date is passed
  -------------------------------------------------------------------------------------------------------------------
    
    Screenshot of All 8 test cases passed
    
    ------------------------------------------------------------------------------------------------------------------
    
    ![image](https://user-images.githubusercontent.com/20844481/192433788-f3763b62-a8e9-4167-9a6c-71dbcc9d7471.png)
    
    ![image](https://user-images.githubusercontent.com/20844481/192433954-03b051d1-aaca-413c-8981-b1a3731d0c92.png)


