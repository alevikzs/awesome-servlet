package org.awesome.servlet;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.Statement;

abstract public class Model implements Modelable, Cloneable {

    private int id;

    private Statement statement;

    public Model() throws Exception {
        this.statement = DbStatement.get();
    }

    abstract protected String getTable();

    abstract protected String[] getColumns();

    public int getId() {
        return this.id;
    }

    private Statement getStatement() {
        return this.statement;
    }

    public void delete() throws Exception {
        String sql = "DELETE FROM " + this.getTable() + " WHERE id = " + this.getId();

        this.getStatement().execute(sql);
    }

    private void insert() throws Exception {
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (int i = 0; i < this.getColumns().length; i++) {
            if (i != 0) {
                columns.append(", ");
                values.append(", ");
            }

            String column = this.getColumns()[i];
            columns.append(column);

            values.append("'");
            values.append(this.getColumnValue(column));
            values.append("'");
        }

        String sql = "INSERT INTO " + this.getTable() + " (" + columns + ") VALUES (" + values + ")";

        this.getStatement().execute(sql);
    }

    private void update() throws Exception {
        StringBuilder updates = new StringBuilder();

        for (int i = 0; i < this.getColumns().length; i++) {
            if (i != 0) {
                updates.append(", ");
            }

            String column = this.getColumns()[i];

            updates.append(column);
            updates.append(" = ");
            updates.append("'");
            updates.append(this.getColumnValue(column));
            updates.append("'");
        }

        String sql  = "UPDATE " + this.getTable() + " SET " + updates + " WHERE id = " + this.getId();

        this.getStatement().execute(sql);
    }

    public Model save() throws Exception {
        if (this.getId() > 0) {
            this.update();
        } else {
            this.insert();
        }

        return this;
    }

    public Model load(Integer id) throws Exception {
        String sql = "SELECT * FROM " + this.getTable() + " WHERE id = " + id;

        ResultSet result = this.getStatement().executeQuery(sql);

        while (result.next()) {
            this.map(result, this);
        }

        if (this.getId() != 0) {
            return this;
        } else {
            return null;
        }
    }

    public Models findAll() throws Exception {
        Models models = new Models();

        String sql = "SELECT * FROM " + this.getTable();

        ResultSet result = this.getStatement().executeQuery(sql);

        while (result.next()) {
            Model model = (Model) this.clone();

            model = this.map(result, model);

            models.add(model);
        }

        return models;
    }

    private String getColumnValue(String column) throws Exception {
        Field field = this.getClass().getDeclaredField(column);
        field.setAccessible(true);

        return (String) field.get(this);
    }

    private void setColumnValue(String column, String value) throws Exception {
        Field field = this.getClass().getDeclaredField(column);
        field.setAccessible(true);

        field.set(this, value);
    }

    private Model map(ResultSet result, Model model) throws Exception {
        model.id = result.getInt("id");

        for (int i = 0; i < model.getColumns().length; i++) {
            String column = model.getColumns()[i];
            String value = result.getString(column);

            model.setColumnValue(column, value);
        }

        return model;
    }

}