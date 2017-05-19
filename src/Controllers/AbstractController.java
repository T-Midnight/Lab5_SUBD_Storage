package Controllers;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<T> {

	public AbstractController(){}
	
	public abstract void add(T entity) throws SQLException;

	public abstract void delete(T entity) throws SQLException;

	public abstract void update(T entity) throws SQLException;

	public abstract List<T> selectAll() throws SQLException;
	
}
