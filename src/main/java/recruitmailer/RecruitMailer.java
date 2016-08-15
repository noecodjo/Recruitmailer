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
 

	public final static String LIST = "./list.json";

	public static void main(String[] args){
		//create an employee
		// First name, Lastname, Current salary, Expected Salary, Notice Period.

		Employee emp = new Employee("YOUR_FIRSTNAME","YOUR_LASTNAME","YOUR_EMAIL",7000, 12000,1);
		SMTPemail smtp = new SMTPemail("YOUR_EMAIL","YOUR_PASSWORD","YOUR_SMTP_HOST",587,TransportStrategy.SMTP_TLS);
		Resume resume = new Resume("YOUR_RESUME_NAME", "YOUR_RESUME_FILE_NAME");

		try {
			//Read Json File
			JsonReader reader = new JsonReader(new FileReader(LIST));
			JobPost[] jobs = new Gson().fromJson(reader, JobPost[].class);
		
			//compose mail
			for(JobPost job:jobs){
				Email email = new EmailBuilder()
					    .from(emp.getFirstname(),emp.getEmail())
					    .to(job.email, job.email)
					    .subject(job.role)
					    .text("Dear Sirs,\n\n"
					    		+ "I herein attach my resume for the "+ job.role + " Position. \n\n"
					    		+ "Thank you, \n\n"
					    		+ "Regards,\n"
					    		+ emp.getfullName())

					    .addAttachment(resume.getName(), new FileDataSource(resume.getFilelocation()))

					    .build();
				//send unsecured mail 
				Mailer mailer=	new Mailer( smtp.getHost(),smtp.getPort(), smtp.getUserName(),smtp.getPassword(),smtp.getTransportStrategy());
				mailer.sendMail(email);
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		

	
	}
	
	
}
