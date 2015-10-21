package controlador;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.login.Persona;
import Negocio.login.Propietario;
import Negocio.login.Usuario;
import presentacion.*;

@WebServlet("/enlace")
public class enlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public enlace() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();   
        String accion = request.getParameter("ok");
        String x=null;
        String pagina=null;
        switch(accion){
        case "Entrar":{
        	pagina=entrar(session,request);
        	break;
        }
        case "RegistrarLugar":{      	
    		break;
        }
        case "Actualizar":{
        	pagina=actualizaLugar(request);
    		break;
        }
        case "EliminarLugar":{
        	pagina=eliminaLugar(request);
    		break;
        }
        case "Favorito":{
        	pagina=favorito(request);
        	break;
        }
        case "Crear":{
        	pagina=registrar(session,request);
			break;
        }
        case "Salir":{
        	pagina="index.jsp";
			session.invalidate();
			break;
        }
        }
        javax.servlet.RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
	public String entrar(HttpSession session, HttpServletRequest request){
		String email, pass;
		String df = null;
		email = request.getParameter("mail");
        pass = request.getParameter("password");
        System.out.println(email+"   "+pass);
        Persona validar;
        LogInFacade logInFacade = new LogInFacade();
			validar = logInFacade.validar(email, pass);
			System.out.println("validar O/C: "+validar.tipo);
			if(validar!=null && session.getAttribute("email")==null){
				request.getSession(false);
				session.setAttribute("email", email);
				JOptionPane.showMessageDialog(null,"bienvenido");
				if(validar.getTipo().equalsIgnoreCase("propietario")){
					request.setAttribute("propietario", "propietario");		
					df= "propietario.jsp";
				}
				else if(validar.getTipo().equalsIgnoreCase("usuario")){
					session.setAttribute("email", email);
					request.setAttribute("usuario", "usuario");
					df= "usuario.jsp";
					
				}
				
			}
			else{
				JOptionPane.showMessageDialog(null,"Usted no se encuentra registrado");
				df= "index.jsp";
			}
			return df;
		}
	public String registrar(HttpSession session, HttpServletRequest request){
		String emaill=request.getParameter("correo");
    	String nombre=request.getParameter("nombre");
    	String password=request.getParameter("clave1");
    	String tipo=request.getParameter("tipo");
    	String df;
    	int si;
    	RegistroFacade registro = new RegistroFacade();
    		si=registro.registrar(emaill, password, nombre,tipo);
    		if(si==1 && session.getAttribute("email")==null){
    			session.setAttribute("email", emaill);
    			if(tipo.equalsIgnoreCase("propietario")){
					request.setAttribute("propietario", "propietario");
					df="propietraio.jsp";
  
    			}
    			else{
    				request.setAttribute("usuario", "usuario");
    				df="usuario.jsp";		
    			}
    		}
    		else{
    			df="index.jsp";
    		}
    		return df;
    	
    	
    }
	
	public String registraLugar(HttpServletRequest request){
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
			RegistroLugarFacade registrarLugarFacade = new RegistroLugarFacade(id, nombre, telefono, coordenadas, propietario, categoria, descripcion);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	return "propietario.jsp";
    }
	public String actualizaLugar(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("NombreLugar");
    	int telefono = Integer.parseInt(request.getParameter("telefono"));
    	String coordenadas = request.getParameter("coordenadas");
    	String propietario = request.getParameter("propietario");
    	int categoria = Integer.parseInt(request.getParameter("categoria"));
    	String descripcion = request.getParameter("descripcion");
    	try {
			ActualizaDatosFacade actualizaLugarFacade = new ActualizaDatosFacade(id, nombre, telefono, coordenadas, propietario, categoria, descripcion);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "propietario.jsp";
	}
	public String eliminaLugar(HttpServletRequest request){
		int id=0;
    	String coordenadas = request.getParameter("coordenadas");
    	try {
			EliminaLugarFacade eliminarLugarFacade = new EliminaLugarFacade(coordenadas, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "propietario.jsp";
	}
	public String favorito(HttpServletRequest request){
		int id=0;
    	String email1= request.getParameter("email");
    	int id2 = Integer.parseInt(request.getParameter("id"));
    	try {
    		RegistroFavoritoFacade registroFavoritoFacade=new RegistroFavoritoFacade(id2,email1);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return"usuario.jsp";
	}

}
