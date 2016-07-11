package dao;

import java.util.List;

import model.orderInfo;

public interface orderinfoDao {
	int insert(orderInfo order);
	int update(orderInfo order);
	int delete(int orderId);
	orderInfo findOne(int orderId);
	List<orderInfo> getList();
	int insertReId(orderInfo order);
}
