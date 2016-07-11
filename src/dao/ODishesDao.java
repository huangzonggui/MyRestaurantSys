package dao;

import java.util.List;

import model.Orderdishes;

public interface ODishesDao {
	Orderdishes findByDishes(int dishes);
	int insert(Orderdishes odish);
	List<Orderdishes> findAll();
	int update(Orderdishes odish);
	int delete(int dishes);
	int insertList(List<Orderdishes> list);
}
