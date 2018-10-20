package services;
import java.util.ArrayList;

import dao.Theatre_dao;
import bean.Theatre_bean;
public class Theatre_service {
       public int add(Theatre_bean a) throws Exception{
    	   Theatre_dao b=new Theatre_dao();
		return  b.insert(a);
       }
       public int del(Theatre_bean c) throws Exception{
    	   Theatre_dao d=new Theatre_dao();
    	   return d.delete(c);
       }
       public int upd(Theatre_bean e,int id) throws Exception{
    	   Theatre_dao f=new Theatre_dao();
    	   return f.update(e, id);
       }
       public Theatre_bean fin(Theatre_bean g) throws Exception{
    	   Theatre_dao h=new Theatre_dao();
    	   return h.find(g);
       }
       public ArrayList<Theatre_bean> all() throws Exception{
    	   Theatre_dao j=new Theatre_dao();
		return j.findAll();
       }
}
