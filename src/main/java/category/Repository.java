package category;

import category.Category;

import java.util.List;

public interface Repository
{
    void create (String name);

    void delete (Integer id);

    Category findById (Integer id);

    List<Category> findAll ();

    void update (String name, Integer id);
}
