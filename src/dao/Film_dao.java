package dao;
import java.sql.*;
import java.util.*;
import bean.Film_bean;
import idao.Film_idao;
import dao.Link;
public class Film_dao implements Film_idao{

	@Override
	public int insert(Film_bean a) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="insert into film values(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, a.getDirector());
			ps.setString(2, a.getType());
			ps.setString(3, a.getRegion());
			ps.setString(4, a.getLanguage());
			ps.setString(5, a.getTime());
			ps.setString(6, a.getPerformer());
			ps.setString(7, a.getName());
			ps.setBytes(8, a.getUrl());
			n=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		if(n==1)
			return 1;
		else
			return 0;
	}

	@Override
	public int delete(Film_bean b) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="delete from film where F_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, b.getName());
			n=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		if(n==1)
			return 1;
		else
		return 0;
	}

	@Override
	public int update(Film_bean c, String name) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		try{
			conn=dao.Link.getConnection();
			String sql="update film set F_director=?,F_type=?,F_region=?,F_language=?,F_time=?,F_performer=?,F_name=?,F_url=? where F_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getDirector());
			ps.setString(2, c.getType());
			ps.setString(3, c.getRegion());
			ps.setString(4, c.getLanguage());
			ps.setString(5, c.getTime());
			ps.setString(6, c.getPerformer());
			ps.setString(7, c.getName());
			ps.setBytes(8, c.getUrl());
			ps.setString(9, name);
		    n=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		if(n==1)
			return 1;
		else
		return 0;
	}

	@Override
	public Film_bean find(Film_bean d) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Film_bean q=new Film_bean();
		try{
			conn=dao.Link.getConnection();
			String sql="select * from film where F_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, d.getName());
			rs=ps.executeQuery();
			if(rs.next()){
				q.setDirector(rs.getString(1));
				q.setType(rs.getString(2));
				q.setRegion(rs.getString(3));
				q.setLanguage(rs.getString(4));
				q.setTime(rs.getString(5));
				q.setPerformer(rs.getString(6));
				q.setName(rs.getString(7));
				q.setUrl(rs.getBytes(8));
				return q;
			}
			else
				return null;
		}catch(Exception e){
			System.out.print("error");
			return null;
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		
	}

	@Override
	public ArrayList<Film_bean> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Film_bean> a=new ArrayList<>();
		try{
			conn=dao.Link.getConnection();
			String sql="select * from film";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Film_bean x=new Film_bean();
				x.setDirector(rs.getString(1));
				x.setType(rs.getString(2));
				x.setRegion(rs.getString(3));
				x.setLanguage(rs.getString(4));
				x.setTime(rs.getString(5));
				x.setPerformer(rs.getString(6));
				x.setName(rs.getString(7));
				x.setUrl(rs.getBytes(8));
				a.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dao.Link.free(rs, ps, conn);
		}
		return a;
	}

}
