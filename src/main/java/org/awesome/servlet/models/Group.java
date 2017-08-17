package org.awesome.servlet.models;

import org.awesome.servlet.Model;

public class Group extends Model {

    private String name;

    private String description;

    public Group() throws Exception {
        super();
    }

    public Group(String name, String description) throws Exception {
        super();

        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public Group setName(String name) {
        this.name = name;

        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public Group setDescription(String description) {
        this.description = description;

        return this;
    }

    public String getTable() {
        return "groups";
    }

    protected String[] getColumns() {
        String[] columns = {"name", "description"};

        return columns;
    }

}