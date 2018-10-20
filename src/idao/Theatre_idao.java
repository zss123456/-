package idao;
import bean.Theatre_bean;

import java.util.ArrayList;
public interface Theatre_idao {
        public abstract int insert(Theatre_bean a)throws Exception;
        public abstract int delete(Theatre_bean b)throws Exception;
        public abstract int update(Theatre_bean c,int id)throws Exception;
        public abstract Theatre_bean find(Theatre_bean d)throws Exception;
        public abstract ArrayList<Theatre_bean> findAll()throws Exception;
}
