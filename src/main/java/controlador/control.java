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
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		Persona persona = (Persona)session.getAttribute("persona");
		//System.out.println("PERSONAAAAA:"+persona.getEmail());
		String email = persona.getEmail();
        String accion = request.getParameter("clugar");
        accion = accion.toLowerCase();
        String latitud, longitud;
        ArrayList<Lugar> lugares = new ArrayList<Lugar>();
        LugaresFacade lugaresFacade = new LugaresFacade(persona);
        String pagina=null;
        switch (accion){
        	case"nombre":
        		pagina=busquedaPorNombre(accion, request, persona);  		
        		break;
        	case"tipos":
        		pagina=busquedaPorTipo(accion, request, persona);  		
        		break;
        	case"todo":
        		pagina=todosLosLugares(accion, request, persona);  		
        		break;
        	case "agregar":
        		pagina=agregaFavorito(request, persona);
        		break;
        	case "quitar":
        		pagina=quitaFavorito(request, persona);
	    		break;
        	case "favoritos":
        		pagina=Favoritos(request, persona);
        		break;		
        }
        javax.servlet.RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
        
	}
	public String Favoritos(HttpServletRequest request, Persona persona){
		LugaresFacade lugaresFacade = new LugaresFacade(persona);
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		lugares.clear();
		String email = persona.getEmail();
		String df;
		try{
			lugares=lugaresFacade.consultarLugares("favoritos", email);
			
			if(lugares.isEmpty()){
				df="usuario.jsp";
			}
			else{
			request.setAttribute("busqueda","Lugares Favoritos");
			request.setAttribute("quitar", "quitar");
			request.setAttribute("lugares", lugares);
			df="mostrar.jsp";
			}
			
		}
		catch (Exception e) {
			df="usuario.jsp";
			e.printStackTrace();
		}
		return df;
	}
	public String quitaFavorito(HttpServletRequest request, Persona persona){
		LugaresFacade lugaresFacade = new LugaresFacade(persona);
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String latitud, longitud;
		latitud = request.getParameter("latitud");
		longitud = request.getParameter("longitud");
		String coord=latitud+" "+longitud;
	try {
		lugaresFacade.quitarFavorito(coord);
		request.setAttribute("lugares", lugares);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return"usuario.jsp";
	}
	public String agregaFavorito(HttpServletRequest request, Persona persona){
		LugaresFacade lugaresFacade = new LugaresFacade(persona);
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String latitud, longitud;
		latitud = request.getParameter("latitud");
		longitud = request.getParameter("longitud");
		String coorde=latitud+" "+longitud;
	try {
		lugaresFacade.agregarFavorito(coorde);
		request.setAttribute("lugares", lugares);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return"usuario.jsp";
	}
	public String todosLosLugares(String accion, HttpServletRequest request,Persona persona){
		LugaresFacade lugaresFacade = new LugaresFacade(persona);
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		lugares.clear();
		String df;
		try{
			lugares=lugaresFacade.consultarLugares("todos", null);
			if(lugares.isEmpty()){
				df="usuario.jsp";
			}
			else{
				request.setAttribute("busqueda","Todos los Lugares");
			request.setAttribute("lugares", lugares);
			df="mostrar.jsp";
			}
		}
		catch (Exception e) {
			df="usuario.jsp";
			e.printStackTrace();
		}
		return df;
	}
	public String busquedaPorNombre(String accion, HttpServletRequest request,Persona persona){
		LugaresFacade lugaresFacade = new LugaresFacade(persona);
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		lugares.clear();
		String df;
		String nombre=request.getParameter("nombrelugar");	
		try{
			lugares=lugaresFacade.consultarLugares(accion, nombre);
			if(lugares.isEmpty()){
				df="usuario.jsp";
			}
			else{
				request.setAttribute("busqueda",nombre);
				request.setAttribute("lugares", lugares);
				df="mostrar.jsp";
			}
		}
		catch (Exception e) {
			df="usuario.jsp";
			e.printStackTrace();
		}
		return df;
	}
	public String busquedaPorTipo(String accion, HttpServletRequest request,Persona persona){
		LugaresFacade lugaresFacade = new LugaresFacade(persona);
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		lugares.clear();
		String df;
		String categoria=request.getParameter("tipo");
		try{
			lugares=lugaresFacade.consultarLugares("categoria", categoria);
			if(lugares.isEmpty()){
				df="usuario.jsp";
			}
			else{
			request.setAttribute("busqueda",categoria);
			request.setAttribute("lugares", lugares);
			df="mostrar.jsp";

			}
		}
		catch (Exception e) {
			df="usuario.jsp";
			e.printStackTrace();
		}
		return df;
	}

}
