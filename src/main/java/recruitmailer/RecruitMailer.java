package recruitmailer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import javax.activation.FileDataSource;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.TransportStrategy;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


public class RecruitMailer {
 
	public static final String HOST = "YOUR_SMTP_HOST";
	public static final Integer PORT = 587; // change with the appropriate port
	public static final String USER_NAME = "YOUR_EMAIL";
	public static final String PASSWORD = "YOUR_PASSWORD"; 
	public static final String RESUME_NAME = "NAME_OF_THE_RESUME";
	public static final String ATTACHMENT_NAME = "FILE_NAME";
	
	public static void main(String[] args){
		//create an employee
		// First name, Lastname, Current salary, Expected Salary, Notice Period.
		Employee emp = new Employee("YOUR_FIRSTNAME","YOUR_LASTNAME",7000,12000,1);
		

		try {
			//Read Json File
			JsonReader reader = new JsonReader(new FileReader("./list.json"));
			Job[] jobs = new Gson().fromJson(reader, Job[].class);
		
			//compose mail
			for(Job job:jobs){
				Email email = new EmailBuilder()
					    .from(emp.getFirstname(),USER_NAME)
					    .to(job.email, job.email)
					    .subject(job.role)
					    .text("Dear Sirs,\n\n"
					    		+ "I herein attach my resume for the "+ job.role + " Position. \n\n"
					    		+ "Thank you, \n\n"
					    		+ "Regards,\n"
					    		+ emp.getfullName())
					    .addAttachment(RESUME_NAME, new FileDataSource(ATTACHMENT_NAME))
					    .build();
				//send unsecured mail 
				Mailer mailer=	new Mailer(HOST, PORT, USER_NAME, PASSWORD,TransportStrategy.SMTP_TLS);
				mailer.sendMail(email);
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		

	
	}
	
	
}
