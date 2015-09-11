package controlador;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.login.Persona;
import Negocio.login.Propietario;
import Negocio.login.Usuario;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		
		HttpSession session = request.getSession();
        String email, pass;
        String accion = request.getParameter("ok");
        if(accion.equalsIgnoreCase("Entrar")){
        	email = request.getParameter("mail");
            pass = request.getParameter("password");
            System.out.println(email+"   "+pass);
            //Usuario usuario;
            //Propietario propietario;
            int validar;
            LogInFacade logInFacade = new LogInFacade();
            //try {
				validar = logInFacade.validarPro(email, pass);
				//propietario = logInFacade.validarPro(email, pass);
				System.out.println("DEvolvio al enlace propieta:  ");
				if(validar == 1 && session.getAttribute("email")==null){
					session.setAttribute("email", email);
					request.setAttribute("propietario", "propietario");
					javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
		    		rd.forward(request, response);
				}else{
					validar=logInFacade.validarUs(email, pass);
					if(validar == 1 && session.getAttribute("email")==null){
						
						session.setAttribute("email", email);
						request.setAttribute("usuario", "usuario");
						javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
			    		rd.forward(request, response);
						
					}
					else{
						javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			    		rd.forward(request, response);
					}
				}
				
			/*} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        }
        if(accion.equalsIgnoreCase("RegistrarLugar")){
        	int id = 0;
        	String nombre = request.getParameter("NombreLugar");
        	int telefono = Integer.parseInt(request.getParameter("telefono"));
        	String coordenadas = request.getParameter("coordenadas");
        	String propietario = request.getParameter("propietario");
        	int categoria = Integer.parseInt(request.getParameter("categoria"));
        	String descripcion = request.getParameter("descripcion");
        	for(int i = 1; i<=5; i++){
        	     id = ((int)(Math.random()*6 + 1));
        	}
        	try {
				RegistrarLugarFacade registrarLugarFacade = new RegistrarLugarFacade(id, nombre, telefono, coordenadas, propietario, categoria, descripcion);
				//System.out.println("Su lugar ha sido registrado en la BD");
				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
	    		rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	/*javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request, response);*/
        }
        
        if (accion.equalsIgnoreCase("Actualizar")){
            
        	String nombre = request.getParameter("NombreLugar");
        	int telefono = Integer.parseInt(request.getParameter("telefono"));
        	String coordenadas = request.getParameter("coordenadas");
        	String propietario = request.getParameter("propietario");
        	int categoria = Integer.parseInt(request.getParameter("categoria"));
        	String descripcion = request.getParameter("descripcion");
        	try {
				ActualizarDatosFacade actualizarLugarFacade = new ActualizarDatosFacade( nombre, telefono, coordenadas, propietario, categoria, descripcion);
				//System.out.println("Su lugar ha sido registrado en la BD");
				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
	    		rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(accion.equalsIgnoreCase("EliminarLugar")){
        	int id=0;
        	String coordenadas = request.getParameter("coordenadas");
        	try {
				EliminarLugarFacade eliminarLugarFacade = new EliminarLugarFacade(coordenadas, id);
				//System.out.println("Su lugar ha sido registrado en la BD");
				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
	    		rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(accion.equalsIgnoreCase("Crear")){
        	String emaill=request.getParameter("correo");
        	String nombre=request.getParameter("nombre");
        	String password=request.getParameter("clave1");
        	String tipo=request.getParameter("tipo");
        	int si;
        	RegistrarFacade registro = new RegistrarFacade();
        	if(tipo.equalsIgnoreCase("propietario")){
        		si=registro.registrarPropietario(emaill, password, nombre);
        		if(si==1 && session.getAttribute("email")==null){
        			session.setAttribute("email", emaill);
					request.setAttribute("propietario", "propietario");
        			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
        			rd.forward(request, response);
        		}
        		else{
        			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        			rd.forward(request, response);
        		}
        		
        	}
        	if(tipo.equalsIgnoreCase("usuario")){
        		si=registro.registrarUsuario(emaill, password, nombre);
        		if(si==1 && session.getAttribute("email")==null){
        		session.setAttribute("email", emaill);
				request.setAttribute("propietario", "propietario");
        		javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
	    		rd.forward(request, response);
        		}else{
        			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        			rd.forward(request, response);
        		}
        	}
        }
        
        if(accion.equalsIgnoreCase("salir")){
      	  session.invalidate();
      	  javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request, response);
        }
	}
}
