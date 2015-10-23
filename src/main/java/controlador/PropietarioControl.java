package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Negocio.gestion.Persona;
import Negocio.lugar.Lugar;
import presentacion.LugaresFacade;


/**
 * Servlet implementation class PropietarioControl
 */
@WebServlet("/PropietarioControl")
public class PropietarioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropietarioControl() {
        super();
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
		Persona propietario = (Persona)session.getAttribute("persona");
		System.out.println("PERSONAAAAA:"+propietario.getEmail());
		String email = propietario.getEmail();
        String accion = request.getParameter("ok");
        String nombre, coordenadas, descripcion;
        int telefono, categoria;
        accion=accion.toLowerCase();
        javax.servlet.RequestDispatcher rd;
        switch(accion){
        
        case "registrarlugar":
        	int id = 0;
        	nombre = request.getParameter("NombreLugar");
        	telefono = Integer.parseInt(request.getParameter("telefono"));
        	coordenadas = request.getParameter("coordenadas");
        	categoria = Integer.parseInt(request.getParameter("categoria"));
        	descripcion = request.getParameter("descripcion");
        	for(int i = 1; i<=5; i++){
        	     id = ((int)(Math.random()*6 + 1));
        	}
        	try {
        		LugaresFacade lugarFacade = new LugaresFacade(propietario);
        		lugarFacade.RegistrarLugar(id, nombre, telefono, coordenadas, email, categoria, descripcion);
				//System.out.println("Su lugar ha sido registrado en la BD");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	session.setAttribute("persona", propietario);
        	rd = request.getRequestDispatcher("propietario.jsp");
    		rd.forward(request, response);
    		break;
        case "actualizar":
        	nombre = request.getParameter("NombreLugar");
        	telefono = Integer.parseInt(request.getParameter("telefono"));
        	coordenadas = request.getParameter("coordenadas");
        	categoria = Integer.parseInt(request.getParameter("categoria"));
        	descripcion = request.getParameter("descripcion");
        	try {
        		LugaresFacade lugarFacade = new LugaresFacade(propietario);
				lugarFacade.ActualizarDatos(nombre, telefono, coordenadas, email, categoria, descripcion);
				//System.out.println("Su lugar ha sido registrado en la BD");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	session.setAttribute("persona", propietario);
        	rd = request.getRequestDispatcher("propietario.jsp");
    		rd.forward(request, response);
    		break;
        case ("consultarlugares"):
        	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
        	LugaresFacade lugaresFacade = new LugaresFacade(propietario);
        	try {
				lugares=lugaresFacade.consultarLugares("propietario", email);
				if(lugares.isEmpty()){
					PrintWriter out=response.getWriter();
					   out.println("Error, no hay lugares.");
					   rd = request.getRequestDispatcher("propietario.jsp");
			    		rd.forward(request, response);
				}
				else{
					request.setAttribute("lugares", lugares);
					rd = request.getRequestDispatcher("lugaresPropietario.jsp");
		    		rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        case "eliminar":
        	
        	String coorde = request.getParameter("elimina");
        	System.out.println("PARA ELIMINR:"+coorde);
        	try {
        		LugaresFacade lugarFacade = new LugaresFacade(propietario);
				lugarFacade.EliminarLugar(coorde);
				rd = request.getRequestDispatcher("propietario.jsp");
	    		rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	break;
        	
        }
	}

}
