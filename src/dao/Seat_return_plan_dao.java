package dao;
import java.sql.*;

import bean.Plan_bean;

import java.util.ArrayList;
public class Seat_return_plan_dao {
                  public ArrayList<Plan_bean> Seat_Plan(Plan_bean b){
                	  
              		Connection conn=null;
            		PreparedStatement ps=null;
            		ResultSet rs=null;
            		ArrayList<Plan_bean> a=new ArrayList<>();
            		try{
            			conn=dao.Link.getConnection();
            			String sql="select * from plan where P_name=?";
            			ps=conn.prepareStatement(sql);
            			ps.setString(1, b.getP_name());
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
}
