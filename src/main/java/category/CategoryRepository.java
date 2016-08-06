package category;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryRepository implements Repository
{
    private final JdbcTemplate template;

    public CategoryRepository (final JdbcTemplate template)
    {
        this.template = template;
    }

    public final void create(final String name)
    {
        final String date = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss").print(new DateTime());

        final String sql = "insert into categories (name, created, updated) values (?, ?, ?)";

        this.template.update(sql, name, date, date);
    }

    public final void delete(final Integer id)
    {
        final String sql = "delete from categories where id = ?";

        this.template.update(sql, id);
    }

    public final Category findById(final Integer id)
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
        final String date = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss").print(new DateTime());

        final String sql = "update categories set name = ?, updated = ? where id = ?";

        this.template.update(sql, name, date, id);

    }
}
