package controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import consultas.bdinstrucciones;

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
		HttpSession sesion = request.getSession();
        String email, pass;
        String accion = request.getParameter("ok");
        if(accion.equalsIgnoreCase("entrar")){    	  
        	email = request.getParameter("mail").toLowerCase();
        	pass = request.getParameter("password");
        	System.out.println(email);
        	System.out.println(pass);
        	bdinstrucciones ins = new bdinstrucciones();
        	int ver = ins.validarUs(email, pass);        
	        //deberíamos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo código
	        if(ver==1 && sesion.getAttribute("email") == null){
	            //si coincide usuario y password y además no hay sesión iniciada
	            sesion.setAttribute("email", email);
	            //redirijo a página con información de login exitoso
	            javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("exito.jsp");
	    		rd.forward(request, response);
	        }else{
	            //lógica para login inválido
	        	String invalido = "Usuario o contraseña incorrectos";
	        	System.out.println(invalido);
	        	request.setAttribute("loginvalido", invalido);
	        	javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    		rd.forward(request, response);
	        }
      }
      if(accion.equalsIgnoreCase("crear")){
    	  String correo= request.getParameter("correo").toLowerCase();
          String clave = request.getParameter("clave2");
          String nombre = request.getParameter("nombre");
          String tipo = request.getParameter("tipo");
          System.out.println(tipo);
          bdinstrucciones ins = new bdinstrucciones();
          if(tipo.equalsIgnoreCase("usuario") ){
        	  int ver = ins.crearUs(correo, clave, nombre);
        	  if(ver==1 && sesion.getAttribute("email") == null){
        		  sesion.setAttribute("email", correo);  		  	
    		  		ins.crearUs(correo, clave, nombre); 
    		  		javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("exito.jsp");
    	      		rd.forward(request, response);
        	  }
        	  
          }
          if(tipo.equalsIgnoreCase("propietario") ){
        	  int ver = ins.crearPr(correo, clave, nombre);
        	  if(ver==1 && sesion.getAttribute("email") == null){
        		  sesion.setAttribute("email", correo);  		  	
    		  		ins.crearPr(correo, clave, nombre); 
    		  		javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("exito.jsp");
    	      		rd.forward(request, response);
        	  }
        	  
          }    
	            
    	  else{
    		  	System.out.println("servlet, bad");
    		  	String reginv = "El email"+correo+" ya esta en uso.";
    		  	request.setAttribute("reginvalido", reginv);
    		  	javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        		rd.forward(request, response);          
    	 }
}
      
      
      
      if(accion.equalsIgnoreCase("salir")){
    	  sesion.invalidate();
    	  javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
  		  rd.forward(request, response);
      }
	}
}
