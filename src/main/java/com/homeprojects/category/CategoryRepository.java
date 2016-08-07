package com.homeprojects.category;

import com.homeprojects.Repository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryRepository implements Repository<Category>
{
    private final JdbcTemplate template;

    public CategoryRepository (final JdbcTemplate template)
    {
        this.template = template;
    }

    public final void create(Category category)
    {
        final String sql = "insert into categories (name, created, updated) values (?, datetime(datetime(), 'localtime'), datetime(datetime(), 'localtime'))";

        this.template.update(sql, category.getName());
    }

    public final void delete(final Integer id)
    {
        final String sql = "delete from categories where id = ?";

        this.template.update(sql, id);
    }

    public Category findById(final Integer id)
    {
        final String sql = "select * from categories where id = ?";

        return (Category) this.template.queryForObject(sql, new Object[]{id}, new CategoryMapper());
    }

    public final List findAll()
    {
        final String sql = "select * from 'categories'";

        return this.template.query(sql, new CategoryMapper());
    }

    public void update(Category category)
    {
        final String sql = "update categories set name = ?, updated = datetime(datetime(), 'localtime') where id = ?";

        this.template.update(sql, category.getName(), category.getId());
    }
}
