package tasks.interfaces;

import java.util.List;

public interface ICrudTasks<T> {
	boolean create(T obj);
	boolean update(T obj);
	void delete(int id);
	List<T> read(int id);
	List<T> readAll(int user);
}
