package category;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper
{

    public Category mapRow (ResultSet rs, int rowNum) throws SQLException
    {
        return new Category(rs.getInt("id"), rs.getString("name"), rs.getString("created"), rs.getString("updated"));
    }
}
