package idao;
import java.util.ArrayList;
import bean.Login_bean;
public interface Login_idao {
                public abstract int insert(Login_bean a);
                public abstract int delete(Login_bean b);
                public abstract int update(Login_bean c,String name);
                public abstract Login_bean find(Login_bean d);
                public abstract ArrayList<Login_bean> findAll();
}
