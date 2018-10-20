package bean;

public class Film_bean {
          private String director;
          private String type;
          private String region;
          private String language;
          private String time;
          private String performer;
          private String name;
          private  byte[] url;
          public Film_bean(){
        	  
          }
          public Film_bean(String director,String type,String region,String language,String time,String performer,String name,byte[] url){
        	  this.director=director;
        	  this.language=language;
        	  this.name=name;
        	  this.performer=performer;
        	  this.region=region;
        	  this.time=time;
        	  this.type=type;
        	  this.url=url;
          }
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getPerformer() {
			return performer;
		}
		public void setPerformer(String performer) {
			this.performer = performer;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public byte[] getUrl() {
			return url;
		}
		public void setUrl(byte[] url) {
			this.url = url;
		}
}