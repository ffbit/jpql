package com.ffbit.jpql;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractPersistenceTest {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @BeforeClass
    public void setUpClass() {
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
    public void tearDownClass() {
        emf.close();
    }
    
}
