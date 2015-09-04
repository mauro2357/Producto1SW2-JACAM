package controlador;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Negocio.login.Persona;
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
            LogInFacade logInFacade = new LogInFacade();
            try {
				Usuario usuario = logInFacade.validar(email, pass);
				System.out.println("DEvolvio:  "+usuario.getEmail()+" "+usuario.getNombre());
				if(usuario.getEmail() != null && session.getAttribute("email")==null){
			      //si coincide usuario y password y además no hay sesión iniciada
		            session.setAttribute("email", email);
		            //redirijo a página con información de login exitoso
		            javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("Aver.jsp");
		    		rd.forward(request, response);
				}else{
					javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		    		rd.forward(request, response);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    		rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	/*javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request, response);*/
        }
        
        if(accion.equalsIgnoreCase("salir")){
      	  session.invalidate();
      	  javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request, response);
        }
	}
}
