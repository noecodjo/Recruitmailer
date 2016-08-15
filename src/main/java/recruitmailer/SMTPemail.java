package recruitmailer;
import org.simplejavamail.mailer.config.TransportStrategy;

/*This is the smtp email account used to blast the email to recruiters*/
public class SMTPemail {
 
	private String userName;
	private String passWord;
	private String host;
	private int port;
	private TransportStrategy transportStrategy ;
	
	public SMTPemail(String username,String password,String host,int port,TransportStrategy transportstrategy){
		this.userName = username;
		this.passWord = password;
		this.host =host;
		this.port =port;
		this.transportStrategy = transportstrategy;
	}
	
	public String getPassword() {
		return passWord;
	}
	public void setPassword(String password) {
		passWord = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public TransportStrategy getTransportStrategy() {
		return transportStrategy;
	}
	public void setTransportStrategy(TransportStrategy transportStrategy) {
		this.transportStrategy = transportStrategy;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
