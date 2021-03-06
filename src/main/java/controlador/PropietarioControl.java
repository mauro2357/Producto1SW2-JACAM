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
import Negocio.lugar.Coordenadas;
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
		System.out.println("PERSONA:"+propietario.getEmail());
		String email = propietario.getEmail();
        String accion = request.getParameter("ok");
        String nombre, latitud, longitud, descripcion,id;
        int telefono, categoria;
        accion=accion.toLowerCase();
        javax.servlet.RequestDispatcher rd;
        switch(accion){
        
        case "registrarlugar":
        	
        	nombre = request.getParameter("NombreLugar");
        	telefono = Integer.parseInt(request.getParameter("telefono"));
        	latitud = request.getParameter("latitud");
        	longitud = request.getParameter("longitud");
        	categoria = Integer.parseInt(request.getParameter("categoria"));
        	descripcion = request.getParameter("descripcion");
        	int registro=0;
        	try {
        		
        		LugaresFacade lugarFacade = new LugaresFacade(propietario);
        		registro=lugarFacade.RegistrarLugar(nombre, telefono,latitud,longitud,categoria, descripcion);
				//System.out.println("Su lugar ha sido registrado en la BD");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("int resgistro: "+registro);
        	session.setAttribute("registro", registro);
        	session.setAttribute("persona", propietario);
        	rd = request.getRequestDispatcher("propietario.jsp");
    		rd.forward(request, response);
    		break;
        case "actualizar":
        	id= (String)request.getParameter("lug_id");
        	nombre = request.getParameter("nombrelugar");
        	System.out.println(nombre);
        	telefono=Integer.parseInt(request.getParameter("telefono"));
        	latitud = request.getParameter("latitud");
        	System.out.println(latitud);
        	longitud = request.getParameter("longitud");
        	System.out.println(longitud);
        	categoria = Integer.parseInt(request.getParameter("categoria"));
        	descripcion = request.getParameter("descripcion");
        	System.out.println(descripcion);
        	try {
        		LugaresFacade lugarFacade = new LugaresFacade(propietario);
				lugarFacade.ActualizarDatos(id,nombre, telefono, latitud,longitud,categoria, descripcion);

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
        	
        	id= (String)request.getParameter("lug_id");
        	//System.out.println("PARA ELIMINR:"+latitud+" "+longitud);
        	System.out.println("PARA ELIMINR:"+id);
        	//String coorde = latitud+" "+longitud;
        	try {
        		LugaresFacade lugarFacade = new LugaresFacade(propietario);
				lugarFacade.EliminarLugar(id);
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

