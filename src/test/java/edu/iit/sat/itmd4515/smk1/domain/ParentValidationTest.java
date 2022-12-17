/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Sumanth M K
 */
public class ParentValidationTest {
    
    private static Validator validator;
    
    @BeforeAll
    public static void beforeAll(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @BeforeEach
    public void beforeEach(){}
    
        @Test
    public void invalidNametoFail(){
        Parent test = new Parent(" ");
        Set<ConstraintViolation<Parent>> violations = validator.validate(test);
        for (ConstraintViolation<Parent> violation : violations) {
            System.out.println(violation.toString());
        }
        assertEquals(1, violations.size());
        //assertEquals("size must be between 3 and 255", violations.iterator().next().getMessage());
        assertEquals("must not be blank", violations.iterator().next().getMessage());
        
    }
    
    @Test
    public void validNametoPass(){
       Parent test = new Parent("TestParent1");
        Set<ConstraintViolation<Parent>> violations = validator.validate(test);
        for (ConstraintViolation<Parent> violation : violations) {
            System.out.println(violation.toString());
        }
        assertEquals(0, violations.size());
    }
    
        @AfterEach
    public void AfterEach(){}
    
    
    @AfterAll
    public static void afterAll(){}
}
