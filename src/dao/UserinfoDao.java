package dao;

import java.util.List;

import model.Userinfo;

public interface UserinfoDao {
	Userinfo findByAccount(String account);
	int insert(Userinfo user);
	List<Userinfo> findAll();
	List<Userinfo> findAll(String wClause,String orderClause,int pageSize,int pageNum);
	int update(Userinfo user);
	int updatePW(String account,String userPass);
	int updateRole(String account, int role);
	int delete(String account); 
	int locked(String account);
	int total();
}
