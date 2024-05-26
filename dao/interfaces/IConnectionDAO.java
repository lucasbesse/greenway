package dao.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface IConnectionDAO {
	public void closeResultSet(ResultSet resultSet);
	public void closeStatement(Statement statement);
	public void closePreparedStatement(PreparedStatement preparedStatement);
}
