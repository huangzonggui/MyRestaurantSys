package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Userinfo;
import model.dishInfo;
import util.ServiceException;
import util.orderutil;



public class dishesInfoDaoImpl implements dishesInfoDao {

	@Override
	public int insert(dishInfo dish) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="insert into dishesinfo values(?,?,?,?,?,?,?)";
		int n=0;
		
			try {
				pt=conn.prepareStatement(sql);
				pt.setInt(1, dish.getDishesId());
				pt.setString(2,dish.getDishesName());
				pt.setString(3,dish.getDishesDiscript());
				pt.setString(4,dish.getDishesImg());
				pt.setString(5,dish.getDishesTxt());
				pt.setInt(6, dish.getRecommend());
				pt.setFloat(7, dish.getDishesPrice());
				
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
	public int update(dishInfo dish) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="update dishesinfo set dishesName=?,dishesDiscript=?,dishesImg=?,dishesTxt=?,recommend=?,dishesPrice=? where dishesId=?";
		int n=0;
		
			try {
				pt=conn.prepareStatement(sql);
				
				pt.setString(1, dish.getDishesName());
				pt.setString(2, dish.getDishesDiscript());
				pt.setString(3, dish.getDishesImg());
				pt.setString(4, dish.getDishesTxt());
				pt.setInt(5, dish.getRecommend());
				pt.setFloat(6, dish.getDishesPrice());
				pt.setInt(7, dish.getDishesId());
				
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
	public int delete(int dishesId) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="delete from dishesinfo where dishesId=?";
		int n=0;
			try {
				pt=conn.prepareStatement(sql);
				pt.setInt(1, dishesId);
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
	public List<dishInfo> getList() {
		List<dishInfo> dishList=new ArrayList<dishInfo>();
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from dishesinfo";
		ResultSet rs=null;
		dishInfo dish=null;
		try {
			pt=conn.prepareStatement(sql);
			rs=pt.executeQuery();
			if(rs!=null)
				while(rs.next()){
					dish=new dishInfo(rs.getInt("dishesId"),
							rs.getString("dishesName"),
							rs.getString("dishesDiscript"),
							rs.getString("dishesImg"),
							rs.getString("dishesTxt"),
							rs.getInt("recommend"),
							rs.getFloat("dishesPrice")      );
					dishList.add(dish);
				}
		} catch (SQLException e) {
			throw new ServiceException("find failed!",e);
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}
		return dishList;
	}

	@Override
	public dishInfo FindOne(int dishesId) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from dishesinfo where dishesId=?";
		ResultSet rs=null;
		dishInfo dish=null;
			try {
				pt=conn.prepareStatement(sql);
				pt.setInt(1, dishesId);
				rs=pt.executeQuery();
				if(rs!=null&&rs.next()){
					dish=new dishInfo(rs.getInt("dishesId"),
							rs.getString("dishesName"),
							rs.getString("dishesDiscript"),
							rs.getString("dishesImg"),
							rs.getString("dishesTxt"),
							rs.getInt("recommend"),
							rs.getFloat("dishesPrice")        );
				}
			} catch (SQLException e) {
				throw new ServiceException("find failed!",e);
			}finally{
				orderutil.closeStatement(rs, pt);
				orderutil.closeConnection(conn);
			}
		return dish;
	}

	@Override
	public List<dishInfo> getList(String wClause, String orderClause,
			int pageSize, int pageNum) {
		String sql="select * from dishesinfo";
		if(wClause!=null&&wClause.length()!=0)
			sql+=" where "+wClause;
		if (orderClause!=null&&orderClause.length()!=0)
			sql+=" order by "+orderClause;
		if (pageNum>0)
			sql+=" limit "+(pageNum-1)*pageSize+","+pageSize;
		List<dishInfo> list=new ArrayList<dishInfo>();
		PreparedStatement pt=null;
		ResultSet rs=null;
		Connection con=orderutil.getConnection();
		try {
			pt=con.prepareStatement(sql);
			rs=pt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					dishInfo dish=new dishInfo(rs.getInt("dishesId"),
							rs.getString("dishesName"),
							rs.getString("dishesDiscript"),
							rs.getString("dishesImg"),
							rs.getString("dishesTxt"),
							rs.getInt("recommend"),
							rs.getFloat("dishesPrice")    );
					list.add(dish);
				}
			}
		} catch (SQLException e) {
			throw new ServiceException("find failed!",e);
		}finally
		{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(con);
		}
		
		return list;
	}
	public int total()
	{
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="SELECT COUNT(*) AS total FROM dishesinfo";
		ResultSet rs=null;
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			rs=pt.executeQuery();
			rs.next();
			n=rs.getInt("total");
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new ServiceException("delete failed!",e);
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}
		return n;
	}


}
