package com.ffbit.jpql.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;

/**
 * Represents the Employee domain entity.
 * 
 * @author ffbit
 */

@Entity
@Table(name = "EMPLOYEES")
@Access(AccessType.PROPERTY)
public class Employee {

    private Integer id;
    private String name;
    private double salary;

    /**
     * The default non-arguments constructor regarding to JPA requirements
     */
    protected Employee() {

    }

    /**
     * A constructor created for handy usage.
     * 
     * @param name
     *            Employee's name
     * @param salary
     *            Employee's salary
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;

        return Objects.equal(name, other.name)
                && Objects.equal(salary, other.salary);
    }

}
