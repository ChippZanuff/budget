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

    public final void create(final String name)
    {
        final String sql = "insert into categories (name, created, updated) values (?, current_timestamp, current_timestamp)";

        this.template.update(sql, name);
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

    public void update(final String name,final Integer id)
    {
        final String sql = "update categories set name = ?, updated = current_timestamp where id = ?";

        this.template.update(sql, name, id);

    }
}
