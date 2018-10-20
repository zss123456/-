package idao;
import java.util.ArrayList;

import bean.Plan_bean;
import bean.Plan_to_bean;
import bean.Plan_too_bean;
public interface Plan_idao {
	          
                public abstract int insert(Plan_bean a);
                public abstract int delete(Plan_bean b);
                public abstract int update(Plan_bean c,int id,String time);
                public abstract Plan_bean find(Plan_bean d);
                public abstract ArrayList<Plan_bean> findAll();
                public abstract ArrayList<Plan_to_bean>findTo();
                public abstract ArrayList<Plan_too_bean>findToo();
}
