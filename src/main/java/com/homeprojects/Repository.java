package com.homeprojects;

import java.util.List;

public interface Repository <T>
{
    void create (T object);

    void delete (Integer id);

    T findById (Integer id);

    List<T> findAll ();

    void update (T object);
}
