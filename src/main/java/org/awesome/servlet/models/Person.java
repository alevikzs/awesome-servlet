package org.awesome.servlet.models;

import org.awesome.servlet.Model;

public class Person extends Model {

    private String firstName;

    private String lastName;

    public Person() throws Exception {
        super();
    }

    public Person(String firstName, String lastName) throws Exception {
        super();

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public String getTable() {
        return "persons";
    }

    protected String[] getColumns() {
        String[] columns = {"firstName", "lastName"};

        return columns;
    }

}