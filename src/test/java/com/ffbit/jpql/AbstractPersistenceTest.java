package com.ffbit.jpql;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractPersistenceTest {
    
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("test");
    }
    
    @Before
    public void setUp() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    @After
    public void tearDown() {
        em.getTransaction().rollback();
        em.close();
    }
    
    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }
    
}
