package services;

import bean.Seat_bean;
import dao.Seat_dao;

public class Seat_service {
	 public int add(Seat_bean a){
   	  Seat_dao b=new Seat_dao();
   	  return b.insert(a);
     }
     public int del(Seat_bean c){
   	  Seat_dao d=new Seat_dao();
   	  return d.delete(c);
     }
     public int upd(Seat_bean e,int id,String number){
   	  Seat_dao f=new Seat_dao();
   	  return f.update(e, id,number);
     }
     public Seat_bean fin(Seat_bean g){
   	  Seat_dao h=new Seat_dao();
   	  return h.find(g);
     }
}
