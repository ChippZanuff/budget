package com.homeprojects;

import java.util.List;

public interface Repository <T>
{
    void create (String name);

    void delete (Integer id);

    T findById (Integer id);

    List<T> findAll ();

    void update (String name, Integer id);
}
