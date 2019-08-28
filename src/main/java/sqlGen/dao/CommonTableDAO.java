package sqlGen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class CommonTableDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, String> getAllTableOption() {
		String queryString = "SELECT [TABLE_NAME] FROM [INFORMATION_SCHEMA].[TABLES]";
		return this.jdbcTemplate.query(queryString, new ResultSetExtractor<Map<String, String>>() {
			@Override
			public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				HashMap<String, String> tableNameMap = new HashMap<String, String>();
				while (rs.next()) {
					tableNameMap.put(rs.getString(1), rs.getString(1));
				}
				return tableNameMap;
			}
		});
	}

	public List<String> getTableColumns(String tableName) {
		StringBuilder queryBuilder = new StringBuilder(" SELECT [COLUMN_NAME] \n");
		queryBuilder.append(" FROM [TestDB].[INFORMATION_SCHEMA].[COLUMNS] \n");
		queryBuilder.append("  where [TABLE_NAME] = ? ");
		return null;
	}

}