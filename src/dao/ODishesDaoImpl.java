package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.orderutil;
import model.Orderdishes;

public class ODishesDaoImpl implements ODishesDao {

	@Override
	public Orderdishes findByDishes(int dishes) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="select * from orderdishes where dishes=?";
		ResultSet rs=null;
		Orderdishes odish=null;
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1,dishes);
			rs=pt.executeQuery();
			if (rs!=null&&rs.next()) {
				odish=new Orderdishes(rs.getInt("odId"), rs.getInt("orderReference"),
						rs.getInt("dishes"),rs.getInt("num"),rs.getInt("status"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}
		
		return odish;
	}

	@Override
	public int insert(Orderdishes odish) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="insert into orderdishes values(?,?,?,?,?)";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, odish.getOdId());
			pt.setInt(2, odish.getOrderReference());
			pt.setInt(3, odish.getDishes());
			pt.setInt(4, odish.getNum());
			pt.setInt(5, odish.getStatus());
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
	public int insertList(List<Orderdishes> list) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="insert into orderdishes(orderReference,dishes,num,odStatus"
				+ ") values(?,?,?,?)";
		int n=0;
		for(Orderdishes odish:list)
		{
			n++;
			try {
				pt=conn.prepareStatement(sql);
//				pt.setInt(1, odish.getOdId());
				pt.setInt(1, odish.getOrderReference());
				pt.setInt(2, odish.getDishes());
				pt.setInt(3, odish.getNum());
				pt.setInt(4, odish.getStatus());
				pt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;
	}
	
	@Override
	public List<Orderdishes> findAll() {
		Connection conn=orderutil.getConnection();
		ArrayList<Orderdishes> list=new ArrayList<Orderdishes>();
		PreparedStatement pt=null;
		ResultSet rs=null;
		Orderdishes odish;
		String sql="select * from orderdishes";
		try {
			pt=conn.prepareStatement(sql);
			rs=pt.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					odish=new Orderdishes(rs.getInt("odId"), rs.getInt("orderReference"),
							rs.getInt("dishes"),rs.getInt("num"),rs.getInt("status"));					
					list.add(odish);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			orderutil.closeStatement(rs, pt);
			orderutil.closeConnection(conn);
		}
		return list;
	}

	@Override
	public int update(Orderdishes odish) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="update orderdishes set num=?,status=? where orderReference=?";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1, odish.getNum());
			pt.setInt(2, odish.getStatus());
			pt.setInt(3,odish.getOrderReference());		
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
	public int delete(int dishes) {
		Connection conn=orderutil.getConnection();
		PreparedStatement pt=null;
		String sql="delete from orderdishes where orderReference=?";
		int n=0;
		try {
			pt=conn.prepareStatement(sql);
			pt.setInt(1,dishes);
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



}
