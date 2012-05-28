package com.ffbit.jpql.domain;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.ffbit.jpql.AbstractPersistenceTest;

public class EmployeeJpqlTest extends AbstractPersistenceTest {
    
    private Employee john;
    private Employee jack;
    
    @Before
    public void setUp() {
        super.setUp();
        
        john = new Employee("John Doe", 1000);
        jack = new Employee("Jack Line", 1010);
        
        em.persist(john);
        em.persist(jack);
    }

    @Test
    public void itShouldRetrieveAllEmplloyees() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e",
                Employee.class);
        List<Employee> employees = query.getResultList();

        assertArrayEquals(new Employee[] { john, jack }, employees.toArray());
    }

    @Test
    public void itShoulRetrieveAllEmployeeNames() {
        TypedQuery<String> query = em.createQuery(
                "SELECT e.name FROM Employee e", String.class);
        List<String> names = query.getResultList();

        assertArrayEquals(new String[] { john.getName(), jack.getName() },
                names.toArray());
    }

}
