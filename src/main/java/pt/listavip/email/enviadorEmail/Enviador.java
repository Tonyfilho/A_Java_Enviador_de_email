package pt.listavip.email.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class Enviador {
	public void enviarEmail(String nome, String emailConvidado) {
		   try {
	            Email email = new SimpleEmail();
	            email.setHostName("smtp.googlemail.com");
	            email.setSmtpPort(465);
	            email.setAuthenticator(new DefaultAuthenticator("blogatec@gmail.com", "blogatec#0619"));/* aqui
	            no colocamos nosso email de autenticação, bem como nossa senha*/
	            email.setSSLOnConnect(true);

	            email.setFrom("blogatec@gmail.com");
	            email.setSubject("Você se cadastrou no projeto Blog Atec!");
	            email.setMsg("Olá " + nome + ". Você acaba de ser cadastrado no Blog da Atec.");
	            email.addTo(emailConvidado);
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
		
		
	}

}// fim da class
