package controlador;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.gestion.Usuario;
import Negocio.lugar.Lugar;
import presentacion.*;

/**
 * Servlet implementation class enlace
 */
@WebServlet("/enlace")
public class enlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public enlace() {
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
        String email, pass;
        String accion = request.getParameter("ok");
        String pagina=null;
        switch(accion){
        case"Entrar":
        	pagina=Login(request, session);
        	break;
        case"Crear":
        	pagina=NuevaPersona(request,session);
        	break;
        case"Salir":
        	pagina="index.jsp";
        	session.invalidate();
        	break;
        }
        
        javax.servlet.RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
	public String Login(HttpServletRequest request, HttpSession session){
		String email, pass;
		email = request.getParameter("correo");
        pass = request.getParameter("password");
        System.out.println(email+"   "+pass);
        Persona persona;
        LogInFacade logInFacade = new LogInFacade();
        String df=null;
		persona = logInFacade.validar(email, pass);
		if(persona!=null && session.getAttribute("persona")==null){
			session.setAttribute("persona", persona);
			if(persona.getTipo().equalsIgnoreCase("propietario")){
				request.setAttribute("propietario", "propietario");
				df="propietario.jsp";	
			}
			if(persona.getTipo().equalsIgnoreCase("usuario")){
				request.setAttribute("usuario", "usuario");
				df="usuario.jsp";
			}
				
			}
			else{
				JOptionPane.showMessageDialog(null,"Email o contraseña incorrectos.");
				df="index.jsp";
			}

		return df;
	}
	public String NuevaPersona(HttpServletRequest request, HttpSession session){
		String emaill=request.getParameter("correo");
    	String nombre=request.getParameter("nombre");
    	String password=request.getParameter("clave1");
    	String tipo=request.getParameter("tipo");
    	String df;
    	RegistroFacade registro = new RegistroFacade();
    	Persona persona=registro.registrar(emaill, password, nombre,tipo);
    	
    		if(persona!=null && session.getAttribute("persona")==null){
    			session.setAttribute("persona", persona);
    			if(tipo.equalsIgnoreCase("propietario")){
					request.setAttribute("propietario", "propietario");
					df=Login(request, session);
    			}
    			else{
    				request.setAttribute("usuario", "usuario");
    				df=Login(request, session);
    			}
    		}
    		else{
    			//request.setAttribute("error2", "error2");
    			JOptionPane.showMessageDialog(null,"El email se encuentra ocupado, intente nuevamente.");
    			df="index.jsp";
    		}
    		
    		return df;
	}
}

