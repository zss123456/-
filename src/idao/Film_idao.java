package idao;
import java.util.ArrayList;

import bean.Film_bean;
public interface Film_idao {
                public abstract int insert(Film_bean a);
                public abstract int delete(Film_bean b);
                public abstract int update(Film_bean c,String name);
                public abstract Film_bean find(Film_bean d);
                public abstract ArrayList<Film_bean> findAll();
}
