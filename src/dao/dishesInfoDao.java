package dao;

import java.util.List;

import model.dishInfo;

public interface dishesInfoDao {
	int insert(dishInfo dish);
	int update(dishInfo dish);
	int delete(int dishesId);
	List<dishInfo> getList();	
	dishInfo FindOne(int dishesId);
	
	List<dishInfo> getList(String wClause,String orderClause,int pageSize,int pageNum);
	int total();
	
}
