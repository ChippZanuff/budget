package com.homeprojects.category;

public class Category
{
    private String created;
    private String updated;
    private Integer id;
    private String name = "";

    public Category (Integer id, String name, String created, String updated)
    {
        this.id = id;
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    public Category(String name)
    {
        this.name = name;
    }

    public Integer getId ()
    {
        return this.id;
    }

    public String getName ()
    {
        return this.name;
    }

    public String getCreated ()
    {
        return this.created;
    }

    public String getUpdated ()
    {
        return this.updated;
    }
}
