package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ServiceException;
import util.orderutil;
import model.orderInfo;

public class orderinfoDaoImpl implements orderinfoDao {

	@Override
	public int insert(orderInfo order) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="insert into orderinfo(orderBeginDate,orderEnd,waiterId,orderState,tableId) values(?,?,?,?,?)";
		int n=0;
			try {
				pt=conn.prepareStatement(sql);
				
				pt.setString(1, order.getOrderBeginDate());
				pt.setString(2, order.getOrderEndDate());
				pt.setInt(3, order.getWaiterId());
				pt.setInt(4, order.getOrderState());
				pt.setInt(5, order.getTableId());
				n=pt.executeUpdate();
			} catch (SQLException e) {
				throw new ServiceException("insert failed!",e);
			}finally{
				orderutil.closeStatement(null, pt);
				orderutil.closeConnection(conn);
			}
		return n;
	}

	@Override
	public int update(orderInfo order) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="update orderinfo set waiterId=?,orderState=?,tableId=? where orderId=?";
		int n=0;
		
			try {
				pt=conn.prepareStatement(sql);
				pt.setInt(1, order.getWaiterId());
				pt.setInt(2, order.getOrderState());
				pt.setInt(3, order.getTableId());
				pt.setInt(4, order.getOrderId());
				n=pt.executeUpdate();
			} catch (SQLException e) {
				throw new ServiceException("update failed",e);
			}finally{
				orderutil.closeStatement(null, pt);
				orderutil.closeConnection(conn);
			}
		return n;
	}

	@Override
	public int delete(int orderId) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="delete from orderInfo where orderId=?";
		int n=0;
			try {
				pt=conn.prepareStatement(sql);
				pt.setInt(1, orderId);
				n=pt.executeUpdate();
			} catch (SQLException e) {
				throw new ServiceException("delete failed",e);
			}finally{
				orderutil.closeStatement(null, pt);
				orderutil.closeConnection(conn);
			}			
		return n;
	}

	@Override
	public orderInfo findOne(int orderId) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from orderInfo where orderId=?";
		ResultSet rs=null;
		orderInfo order=null;
			try {
				pt=conn.prepareStatement(sql);
				pt.setInt(1, orderId);
				rs=pt.executeQuery();
				if(rs!=null&&rs.next()){
					order=new orderInfo(rs.getInt("orderId"),rs.getInt("waiterId"),
							rs.getInt("orderState"),rs.getInt("tableId"),
							rs.getString("orderBeginDate"),
							rs.getString("orderEnd"));
				}
			} catch (SQLException e) {
				throw new ServiceException("find failed!",e);
			}finally{
				orderutil.closeStatement(rs, pt);
				orderutil.closeConnection(conn);
			}
		return order;
	}

	@Override
	public List<orderInfo> getList() {
		List<orderInfo> orderList=new ArrayList<orderInfo>();
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from orderInfo";
		ResultSet rs=null;
		orderInfo order=null;
		try {
			pt=conn.prepareStatement(sql);
			rs=pt.executeQuery();
			if(rs!=null)
				while(rs.next()){
					order=new orderInfo(rs.getInt("orderId"),rs.getInt("waiterId"),
							rs.getInt("orderState"),rs.getInt("tableId"),
							rs.getString("orderBeginDate"),
							rs.getString("orderEnd"));
					orderList.add(order);
				}
		} catch (SQLException e) {
			throw new ServiceException("find failed!",e);
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}
		return orderList;
	}

	@Override
	public int insertReId(orderInfo order) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="insert into orderinfo(orderBeginDate,orderEnd,waiterId,orderState,tableId) values(?,?,?,?,?)";
		String sql1="select orderId from orderInfo where orderBeginDate=?";
		ResultSet rs=null;
		
		int n=0;
			try {
				pt=conn.prepareStatement(sql);
				pt.setString(1, order.getOrderBeginDate());
				pt.setString(2, order.getOrderEndDate());
				pt.setInt(3, order.getWaiterId());
				pt.setInt(4, order.getOrderState());
				pt.setInt(5, order.getTableId());
				pt.executeUpdate();
			} catch (SQLException e) {
				throw new ServiceException("insert failed!",e);
			} 	
				
		
		
		try {
			pt=conn.prepareStatement(sql1);
			pt.setString(1, order.getOrderBeginDate());
			rs=pt.executeQuery();
			if(rs!=null&&rs.next()){
				n=rs.getInt("orderId");
			}
		} catch (Exception e1) {
			throw new ServiceException("ReturnId failed",e1);
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}

		return n;
		
	}
	
	

}
