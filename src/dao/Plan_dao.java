package dao;
import idao.Plan_idao;
import dao.Link;
import java.sql.*;
import java.util.ArrayList;
import bean.Plan_bean;
import bean.Plan_to_bean;
import bean.Plan_too_bean;
public class Plan_dao implements Plan_idao{

	@Override
	public int insert(Plan_bean a) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			if(!isInsert(a))
				return 2;
			conn=dao.Link.getConnection();
			String sql="insert into plan values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, a.getP_name());
			ps.setInt(2, a.getP_id());
			ps.setString(3, a.getP_start());
			ps.setString(4, a.getP_end());
			ps.setString(5, a.getP_time());
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
	public int delete(Plan_bean b) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="delete from plan where P_id=? and P_start=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, b.getP_id());
			ps.setString(2, b.getP_start());
			n=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			dao.Link.free(rs, ps, conn);
		}
		if(n==1)
			return 1;
		else
			return 0;
	}

	@Override
	public int update(Plan_bean c,int id,String time) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="update plan set P_name=?,P_id=?,P_start=?,P_end=?,P_time=? where P_id=? and P_start=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getP_name());
			ps.setInt(2, c.getP_id());
			ps.setString(3, c.getP_start());
			ps.setString(4, c.getP_end());
			ps.setString(5, c.getP_time());
			ps.setInt(6, id);
			ps.setString(7, time);
			n=ps.executeUpdate();
			if(n==1)
				return 1;
			else
				return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public Plan_bean find(Plan_bean d) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=dao.Link.getConnection();
			String sql="select * from plan where P_id=? and p_start=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, d.getP_id());
			ps.setString(2, d.getP_start());
			rs=ps.executeQuery();
			if(rs.next()){
				Plan_bean x=new Plan_bean();
				x.setP_name(rs.getString(1));
				x.setP_id(rs.getInt(2));
				x.setP_start(rs.getString(3));
				x.setP_end(rs.getString(4));
				x.setP_time(rs.getString(5));
				return x;
			}
			else
				return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			dao.Link.free(rs, ps, conn);
		}
	}

	@Override
	public ArrayList<Plan_bean> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Plan_bean> a=new ArrayList<>();
		try{
			conn=dao.Link.getConnection();
			String sql="select * from plan";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Plan_bean x=new Plan_bean();
				x.setP_name(rs.getString(1));
				x.setP_id(rs.getInt(2));
				x.setP_start(rs.getString(3));
				x.setP_end(rs.getString(4));
				x.setP_time(rs.getString(5));
				a.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		return a;
	}

	@Override
	public ArrayList<Plan_to_bean> findTo() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Plan_to_bean> a=new ArrayList<>();
		try{
			conn=dao.Link.getConnection();
			String sql="select F_name,F_time from film";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Plan_to_bean x=new Plan_to_bean();
				x.setF_name(rs.getString(1));
				x.setF_time(rs.getString(2));
				a.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		return a;
	}

	@Override
	public ArrayList<Plan_too_bean> findToo() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Plan_too_bean> a=new ArrayList<>();
		try{
			conn=dao.Link.getConnection();
			String sql="select T_id from theatre";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Plan_too_bean x=new Plan_too_bean();
				x.setT_id(rs.getInt(1));
				a.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		return a;
	}
	public static boolean isInsert(Plan_bean y){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=dao.Link.getConnection();
			String sql="select P_id,P_start from plan";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				if(y.getP_id()==rs.getInt(1)&&y.getP_start().equals(rs.getString(2))){
					return false;
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		
	}

	
 
}
