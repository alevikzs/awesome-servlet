package org.awesome.servlet;

import java.util.HashSet;

public interface Modelable {

    int getId();

    Modelable save() throws Exception;

    Modelable load(Integer id) throws Exception;

    HashSet findAll() throws Exception;

    void delete() throws Exception;

}