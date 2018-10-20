package bean;

public class Theatre_bean {
	
	 private  int id;
	 private  String name;
	 private  int rows;
     private  int cols;
     private  String desc;
     public Theatre_bean(){
    	 
     }
     public Theatre_bean(int id,String name,int rows,int cols,String desc){
    	 this.cols=cols;
    	 this.desc=desc;
    	 this.id=id;
    	 this.rows=rows;
    	 this.name=name;
     }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
  

}
