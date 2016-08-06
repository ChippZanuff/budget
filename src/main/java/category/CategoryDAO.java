package category;

import java.util.List;

public interface CategoryDAO
{
    void create(String name);

    void delete(Integer integer);

    Category getCategory(Integer integer);

    List<Category> listCategories();

    void update(String name,Integer integer);
}
