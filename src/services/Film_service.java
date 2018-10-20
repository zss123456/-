package services;
import java.util.*;
import dao.Film_dao;
import bean.Film_bean;
public class Film_service {
          public int add(Film_bean a){
        	  Film_dao b=new Film_dao();
        	  return b.insert(a);
          }
          public int del(Film_bean c){
        	  Film_dao d=new Film_dao();
        	  return d.delete(c);
          }
          public int upd(Film_bean e,String name){
        	  Film_dao f=new Film_dao();
        	  return f.update(e, name);
          }
          public Film_bean fin(Film_bean g){
        	  Film_dao h=new Film_dao();
        	  return h.find(g);
          }
          public ArrayList<Film_bean> all(){
        	  Film_dao q=new Film_dao();
        	  return q.findAll();
          }
}
