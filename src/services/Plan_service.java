package services;
import java.util.*;

import dao.Plan_dao;
import bean.Plan_bean;
import bean.Plan_to_bean;
import bean.Plan_too_bean;
public class Plan_service {
          public int add(Plan_bean a){
        	  Plan_dao b=new Plan_dao();
        	  return b.insert(a);
          }
          public int del(Plan_bean c){
        	  Plan_dao d=new Plan_dao();
        	  return d.delete(c);
          }
          public int upd(Plan_bean e,int id,String time){
        	  Plan_dao f=new Plan_dao();
        	  return f.update(e,id,time);
          }
          public Plan_bean fin(Plan_bean g){
        	  Plan_dao h=new Plan_dao();
        	  return h.find(g);
          }
          public ArrayList<Plan_bean> all(){
        	  Plan_dao q=new Plan_dao();
        	  return q.findAll();
          }
          public ArrayList<Plan_to_bean>to(){
        	  Plan_dao q=new Plan_dao();
			return q.findTo();
          }
          public ArrayList<Plan_too_bean>too(){
        	  Plan_dao q=new Plan_dao();
			return q.findToo();
          }
          
}