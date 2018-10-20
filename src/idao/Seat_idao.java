package idao;

import bean.Seat_bean;

public interface Seat_idao {
    public abstract int insert(Seat_bean a);
    public abstract int delete(Seat_bean b);
    public abstract int update(Seat_bean c,int id,String number);
    public abstract Seat_bean find(Seat_bean d);
}
