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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
        ArrayList<Lugar> lugares = new ArrayList<Lugar>();
        LugaresFacade lugaresFacade = new LugaresFacade(persona);
        
        switch (accion){
        	case ("nombre"):
        		lugares.clear();
        		String nombre=request.getParameter("nombrelugar");
        		
        		try{
        			lugares=lugaresFacade.consultarLugares(accion, nombre);
        			if(lugares.isEmpty()){
    					PrintWriter out=response.getWriter();
    					out.println("Error, no se encontro el lugar.");
    					javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
    		    		rd.forward(request, response);
    				}
    				else{
    				request.setAttribute("lugares", lugares);
    				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
    	    		rd.forward(request, response);
    				}
        		}
        		catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		break;
        	case ("tipos"):
        		lugares.clear();
        		String categoria=request.getParameter("tipo");
        		try{
        			lugares=lugaresFacade.consultarLugares("categoria", categoria);
        			if(lugares.isEmpty()){
    					PrintWriter out=response.getWriter();
    					out.println("Error, no se encontro el lugar.");
    					javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
    		    		rd.forward(request, response);
    				}
    				else{
    				request.setAttribute("lugares", lugares);
    				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
    	    		rd.forward(request, response);
    				}
        		}
        		catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		break;
        	case ("todo"):
        		lugares.clear();
        		try{
        			lugares=lugaresFacade.consultarLugares("todos", null);
        			if(lugares.isEmpty()){
    					PrintWriter out=response.getWriter();
    					out.println("Error, no se encontro el lugar.");
    					javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
    		    		rd.forward(request, response);
    				}
    				else{
    				request.setAttribute("lugares", lugares);
    				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
    	    		rd.forward(request, response);
    				}
        		}
        		catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		break;
        	case "agregar":
        		String coorde = request.getParameter("favorito");
			try {
				lugaresFacade.agregarFavorito(coorde);
				request.setAttribute("lugares", lugares);
				javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
	    		rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        		
	    		break;
        }
        
	}

}
