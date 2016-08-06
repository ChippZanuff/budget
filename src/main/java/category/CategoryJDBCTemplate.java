package category;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryJDBCTemplate implements CategoryDAO
{
    private final JdbcTemplate jdbcTemplateObject;

    public CategoryJDBCTemplate(final JdbcTemplate template)
    {
        this.jdbcTemplateObject = template;
    }

    public final void create(final String name)
    {
        final String date = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss").print(new DateTime());

        final String sql = "insert into categories (name, created, updated) values (?, ?, ?)";

        this.jdbcTemplateObject.update(sql, name, date, date);
    }

    public final void delete(final Integer integer)
    {
        final String sql = "delete from categories where id = ?";

        this.jdbcTemplateObject.update(sql, integer);
    }

    public final Category getCategory(final Integer integer)
    {
        final String sql = "select * from categories where id = ?";

        return (Category) this.jdbcTemplateObject.queryForObject(sql, new Object[]{integer}, new CategoryMapper());
    }

    public final List listCategories()
    {
        final String sql = "select * from 'categories'";

        return this.jdbcTemplateObject.query(sql, new CategoryMapper());
    }

    public void update(final String name,final Integer integer)
    {
        final String date = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss").print(new DateTime());

        final String sql = "update categories set name = ?, updated = ? where id = ?";

        this.jdbcTemplateObject.update(sql, name, date, integer);

    }
}
