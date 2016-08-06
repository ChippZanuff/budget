package category;

public class Category
{
    private final String created;
    private final String updated;
    private Integer id;
    private String name = "";

    public Category(Integer id,String name,String created,String updated)
    {
        this.id = id;
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    public Integer getId()
    {
        return this.id;
    }

    public Integer setId(Integer id)
    {
        return this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCreated()
    {
        return this.created;
    }

    public String getUpdated()
    {
        return this.updated;
    }
}
