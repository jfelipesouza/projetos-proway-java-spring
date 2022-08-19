package tasks.interfaces;

import java.util.List;

public interface ICrud<T> {

	boolean create(T obj);
	boolean update(T obj);
	void delete(int id);
	T read(int id);
	List<T> read();
	
}
