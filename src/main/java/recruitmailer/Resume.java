package recruitmailer;

public class Resume {
 private String name;
 private String fileLocation;
 
 public Resume(String name, String filelocation){
	 this.name = name;
	 this.fileLocation = filelocation;
 }
 
public String getFilelocation() {
	return fileLocation;
}
public void setFilelocation(String filelocation) {
	this.fileLocation = filelocation;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
 
}
