package logic;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Time;
import java.util.Calendar;
import java.util.Properties;

public class LoginSecure {


//   propiedades necesarias para mandar el correo

    private final String user = "cashflowprojectx@gmail.com";
    private final String password = "1deNoviembre";
    private final String host = "smtp.gmail.com";
    private final int port = 587;
    Calendar calendario;
    private int codigo;
    private int timeGenerationcode = -1;
    private final Session sesion;
    Properties propiedades;


//  genera el codigo y establece el timepo en el que se genero para asi poder verificar la hora si es compatible
    private int GenerationCodeSecure() {

        int generado = (int) (Math.random() * 10000);
        System.out.println(generado);
        timeGenerationcode = calendario.get(Calendar.MINUTE);
        System.out.println(timeGenerationcode);
        return generado;

    }

    public LoginSecure() {
//      inicializo el timer
        calendario = Calendar.getInstance();

//      aqui se asignan las propiedades para el envio de correo
        propiedades = new Properties();
        propiedades.put("mail.smtp.host", host);
        propiedades.put("mail.smtp.port", port);
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");

//      aqui se le pasan las credenciales a la sesion y se unsa el authentidficador de javax.mail para conectarse
//      correctamente si no se pone no permite acceder a el gmail
        sesion = Session.getInstance(propiedades, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }

//  este metodo envia el mail a quien quiera iniciar sesion
    public void SendMail(String destinatario) {

        System.out.println("inicio el envio");
        codigo = GenerationCodeSecure();
        try {

//          se crea el mensaje y se le asigna a quien y a donde se enviara desde la lina 46-51
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(user));
            mensaje.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
//          aqui se le asigna el cuerpo a el mensaje
            mensaje.setSubject("SecureCode");
            mensaje.setText("" + codigo);

            Transport.send(mensaje);

            System.out.println("hecho");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

// este metodo checa si el codigo  introducido es el correcto
    public boolean CheckSecureCode(int codeIn) {
        boolean onTime = timeCheck();
        if (onTime == true) {
            if (codeIn == codigo) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

//  este metodo checa si esta en tiempo la introduccion de la contraseña
    private boolean timeCheck() {


        if (timeGenerationcode == -1) {
            timeGenerationcode = calendario.get(Calendar.MINUTE);
            System.out.println(timeGenerationcode);
        }
        if (calendario.get(Calendar.MINUTE) > timeGenerationcode) {
            GenerationCodeSecure();
            System.out.println("entro dentro del tiempo");
            return true;
        } else {
            System.out.println("no entro dentro del tiempo");
            return false;
        }
    }


}
