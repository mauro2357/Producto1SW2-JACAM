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
		request.setAttribute("error1", null);
		request.setAttribute("error2", null);
		 javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);		
		HttpSession session = request.getSession();
        String email, pass;
        String accion = request.getParameter("ok");
        if(accion.equalsIgnoreCase("Entrar")){
        	email=request.getParameter("correo");
            pass = request.getParameter("password");
            System.out.println(email+"   "+pass);
            //Usuario usuario;
            //Propietario propietario;
            Persona persona;
            LogInFacade logInFacade = new LogInFacade();
            //try {
				persona = logInFacade.validar(email, pass);
				//propietario = logInFacade.validarPro(email, pass);
				if(persona!=null && session.getAttribute("persona")==null){
					session.setAttribute("persona", persona);
					if(persona.getTipo().equalsIgnoreCase("propietario")){
						request.setAttribute("propietario", "propietario");
						javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
						rd.forward(request, response);
						
					}
					if(persona.getTipo().equalsIgnoreCase("usuario")){
						//session.setAttribute("email", email);
						request.setAttribute("usuario", "usuario");
						javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
			    		rd.forward(request, response);
					}
					
				}
				else{
					request.setAttribute("error1","error1");
					javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		    		rd.forward(request, response);
					
				}
					
				}
				
			/*} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        
        if(accion.equalsIgnoreCase("Crear")){
        	String emaill=request.getParameter("correo");
        	String nombre=request.getParameter("nombre");
        	String password=request.getParameter("clave1");
        	String tipo=request.getParameter("tipo");
        	
        	RegistroFacade registro = new RegistroFacade();
        	Persona persona=registro.registrar(emaill, password, nombre,tipo);
    
        		if(persona!=null && session.getAttribute("persona")==null){
        			//session.setAttribute("persona", persona);
        			if(tipo.equalsIgnoreCase("propietario")){
						request.setAttribute("propietario", "propietario");
	        			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        			rd.forward(request, response);
        			}
        			else{
        				request.setAttribute("usuario", "usuario");
	        			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        			rd.forward(request, response);			
        			}
        		}
        		else{
        			request.setAttribute("error2", "error2");
        			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        			rd.forward(request, response);
        		}
        		
        	
        	
        }
        
        
        if(accion.equalsIgnoreCase("salir")){
      	  session.invalidate();
      	  request.setAttribute("error1", null);
      	  request.setAttribute("error2", null);
      	  javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request, response);
        }
	}
}

