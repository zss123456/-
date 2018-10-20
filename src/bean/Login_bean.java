package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login_bean {
         private  String username;
         private  String userpassword;
         private  String telephone;
         private  String email;
 		public Login_bean(){
       	 
        }

         public String getTelephone() {
			return telephone;
		}


		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
         
         public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUserpassword() {
			return userpassword;
		}
		public void setUserpassword(String userpassword) {
			this.userpassword = userpassword;
		}
		public static boolean isLogin(String username,String userpassword) throws SQLException{
 		    boolean f=false;
 		    Connection conn = null;
 		    PreparedStatement ps=null;
 		    ResultSet rs=null;
 		    conn=dao.Link.getConnection();
 		    String sql="select * from login where username=? and userpassword=?";
 		    ps=conn.prepareStatement(sql);
 		    ps.setString(1, username);
 		    ps.setString(2, userpassword);
 		    rs=ps.executeQuery();
 		    if(rs.next()){
 		    	f=true;
 		    }
 		    dao.Link.free(rs, ps, conn);
 			return f;
 		}
}