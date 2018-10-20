package services;
import java.util.*;
import dao.Login_dao;
import bean.Login_bean;
public class Login_service {
    public int add(Login_bean a){
  	  Login_dao b=new Login_dao();
  	  return b.insert(a);
    }
    public int del(Login_bean c){
  	  Login_dao d=new Login_dao();
  	  return d.delete(c);
    }
    public int upd(Login_bean e,String name){
  	  Login_dao f=new Login_dao();
  	  return f.update(e, name);
    }
    public Login_bean fin(Login_bean g){
  	  Login_dao h=new Login_dao();
  	  return h.find(g);
    }
    public ArrayList<Login_bean> all(){
  	  Login_dao q=new Login_dao();
  	  return q.findAll();
    }
}
