package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Request;

import util.ServiceException;
import util.orderutil;
import model.Userinfo;

public class UserinfoDaoImpl implements UserinfoDao{

	@Override
	public Userinfo findByAccount(String account) {
		// TODO Auto-generated method stub
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from userinfo where userAccount=?";
		ResultSet rs=null;
		Userinfo user=null;
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1, account);
			rs=pt.executeQuery();
			if (rs!=null&&rs.next()) {
				user=new Userinfo(rs.getInt("userId"),rs.getInt("role"),rs.getInt("locked"), rs.getString("faceimg"),rs.getString("userAccount"),rs.getString("userPass"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int insert(Userinfo user) {
		// TODO Auto-generated method stub
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="insert into userinfo values(?,?,?,?,?,?)";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, user.getUserId());
			pt.setInt(3, user.getRole());
			pt.setInt(4, user.getLocked());
			pt.setString(5, user.getFaceimg());
			pt.setString(6, user.getUserAccount());
			pt.setString(2,user.getUserPass());
			n=pt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new ServiceException("insert failed",e);
		}finally{
			orderutil.closeStatement(null,pt);
			orderutil.closeConnection(conn);
		}
		return n;
	}

	@Override
	public List<Userinfo> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Userinfo> userList=new ArrayList<Userinfo>();
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from userinfo";
		ResultSet rs=null;
		Userinfo user=null;
		try {
			pt=conn.prepareStatement(sql);
			rs=pt.executeQuery(sql);
			if(rs!=null){
				while (rs.next()) {
					user = new Userinfo(rs.getInt("userId"),
							rs.getInt("role"),rs.getInt("locked"),
							rs.getString("faceimg"),rs.getString("userAccount"),rs.getString("userPass"));
					userList.add(user);
				}				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new ServiceException("findAll failed!",e);
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}
		
		return userList;
	}

	@Override
	public int update(Userinfo user) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="update userinfo set userPass=?,"
				+ "role=?,locked=?,faceimg=? where userAccount=?";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1,user.getUserPass());
			pt.setInt(2, user.getRole());
			pt.setInt(3, user.getLocked());
			pt.setString(4, user.getFaceimg());
			pt.setString(5, user.getUserAccount());
			n=pt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new ServiceException("update failed",e);
		}finally{
			orderutil.closeStatement(null, pt);
			orderutil.closeConnection(conn);
		}
		return n;
	}
	@Override
	public int updatePW(String account,String userPass) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="update userinfo set userPass=? where userAccount=?";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1,userPass);
			pt.setString(2,account);
			n=pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			orderutil.closeStatement(null, pt);
			orderutil.closeConnection(conn);
		}
		
		return n;
	}
	@Override
	public int updateRole(String account, int role) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="update userinfo set role=? where userAccount=?";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1,role);
			pt.setString(2,account);
			n=pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			orderutil.closeStatement(null, pt);
			orderutil.closeConnection(conn);
		}
		return n;
	}

	@Override
	public int delete(String account) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="delete from userinfo where userAccount=?";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1,account );
			n=pt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new ServiceException("delete failed!",e);
		}finally{
			orderutil.closeStatement(null, pt);
			orderutil.closeConnection(conn);
		}
		return n;
	}
	
	@Override
	public int locked(String account) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from userinfo where userAccount=?";
		String sql1="update userinfo set locked=? where userAccount=?";
		ResultSet rs=null;
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1, account);
			rs=pt.executeQuery();
			rs.next();
			if (rs.getInt("locked")==0) {
				pt=conn.prepareStatement(sql1);
				pt.setInt(1, 1);
				pt.setString(2,account);
				n=pt.executeUpdate();
			}else {
				pt=conn.prepareStatement(sql1);
				pt.setInt(1, 0);
				pt.setString(2,account);
				n=pt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}
		
		return n;
	}


	@Override
	public List<Userinfo> findAll(String wClause, String orderClause,
			int pageSize, int pageNum) {
		String sql="select * from userinfo";
		if(wClause!=null&&wClause.length()!=0)
			sql+=" where "+wClause;
		if (orderClause!=null&&orderClause.length()!=0)
			sql+=" order by "+orderClause;
		if (pageNum>0)
			sql+=" limit "+(pageNum-1)*pageSize+","+pageSize;
		List<Userinfo> list=new ArrayList<Userinfo>();
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
					Userinfo user=new Userinfo(rs.getInt("userId"),rs.getInt("role"),rs.getInt("locked"),rs.getString("faceimg"), rs.getString("userAccount"),rs.getString("userPass"));
					list.add(user);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(con);
		}
		
		return list;
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="SELECT COUNT(*) AS total FROM userinfo";
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
