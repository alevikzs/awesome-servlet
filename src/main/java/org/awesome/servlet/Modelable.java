package org.awesome.servlet;

public interface Modelable {

    int getId();

    Modelable save() throws Exception;

    void delete() throws Exception;

}