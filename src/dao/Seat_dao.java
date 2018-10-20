package dao;
import idao.Seat_idao;

import java.sql.*;

import bean.Seat_bean;
public class Seat_dao implements Seat_idao{

	@Override
	public int insert(Seat_bean a) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="insert into seat values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, a.getS_id());
			ps.setString(2, a.getS_number());
			ps.setString(3, a.getS_state());
			ps.setString(4, a.getS_time());
			ps.setString(5, a.getS_start());
			n=ps.executeUpdate();
			if(n==1)
				return 1;
			else
				return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public int delete(Seat_bean b) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="delete from seat where S_id=? and S_number=? and S_start=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,b.getS_id());
			ps.setString(2, b.getS_number());
			ps.setString(3, b.getS_start());
			n=ps.executeUpdate();
			if(n==1)
				return 1;
			else
				return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public int update(Seat_bean c, int id, String number) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="update seat set state=? where S_id=? and S_number=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getS_state());
			ps.setInt(2, id);
			ps.setString(3, number);
			n=ps.executeUpdate();
			if(n==1)
				return 1;
			else
				return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public Seat_bean find(Seat_bean d) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Seat_bean c=new Seat_bean();
		try{
			conn=dao.Link.getConnection();
			String sql="select * from seat where S_id=? and S_number=? and S_start=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, d.getS_id());
			ps.setString(2, d.getS_number());
			ps.setString(3, d.getS_start());
			rs=ps.executeQuery();
			if(rs.next()){
			    c.setS_id(rs.getInt(1));
			    c.setS_number(rs.getString(2));
			    c.setS_state(rs.getString(3));
			    c.setS_time(rs.getString(4));
			    c.setS_start(rs.getString(5));
			    return c;
			}
			else
				return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
	}

}
