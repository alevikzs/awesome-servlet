package org.awesome.servlet;

import java.lang.reflect.Field;
import java.sql.Statement;

abstract public class Model implements Modelable {

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
            updates.append(this.getColumnValue(column));
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

    private String getColumnValue(String column) throws Exception {
        Field field = this.getClass().getDeclaredField(column);
        field.setAccessible(true);

        return (String) field.get(this);
    }

}