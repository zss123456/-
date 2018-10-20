package services;
import java.util.*;

import org.apache.tomcat.util.codec.binary.Base64;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Film_base_bean;
import bean.Film_bean;
public class Film_base_service {
       public JSONArray findAll(ArrayList<Film_bean> t){
		     int i;
		     JSONArray g=new JSONArray();
		     ArrayList<Film_base_bean> c=new ArrayList<>();
		     for(i=0;i<t.size();i++){
		    	  Film_base_bean f=new Film_base_bean();
		    	  f.setDirector(t.get(i).getDirector());
		    	  f.setLanguage(t.get(i).getLanguage());
		    	  f.setName(t.get(i).getName());
		    	  f.setPerformer(t.get(i).getPerformer());
		    	  f.setRegion(t.get(i).getRegion());
		    	  f.setTime(t.get(i).getTime());
		    	  f.setType(t.get(i).getType());
		    	  f.setUrl(byteToBase(t.get(i).getUrl()));
		    	  c.add(f);
		     }
		     for(i=0;i<c.size();i++){
		    	 JSONObject x=new JSONObject();
		    	 x.put("director", c.get(i).getDirector());
		    	 x.put("name", c.get(i).getName());
		    	 x.put("type", c.get(i).getType());
		    	 x.put("time", c.get(i).getTime());
		    	 x.put("performer", c.get(i).getPerformer());
		    	 x.put("region", c.get(i).getRegion());
		    	 x.put("language", c.get(i).getLanguage());
		    	 x.put("url", c.get(i).getUrl());
		    	 g.add(x);
		     }
    	    
    	 return g;
    	   
       }
       public static String byteToBase(byte[] b){
    	   return Base64.encodeBase64String(b);
       }
}
