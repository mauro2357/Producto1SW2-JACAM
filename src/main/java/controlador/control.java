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

import Negocio.busquedadelugaresporelusuario.Lugar;
import presentacion.consultaLugaresFacade;

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
		String email = (String)session.getAttribute("email");
        String accion = request.getParameter("clugar");
        ArrayList<Lugar> lugares = new ArrayList<Lugar>();
        
        if(accion.equalsIgnoreCase("nombre")){
        	lugares.clear();
        	String nombre=request.getParameter("nombrelugar");
        	consultaLugaresFacade consultarLugar = new consultaLugaresFacade();
        	try {
				lugares=consultarLugar.consultarLugarPorNombre(nombre);
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
    		//rd.forward(request, response);
        }
		if(accion.equalsIgnoreCase("tipos")){
			lugares.clear();
			String tipo = request.getParameter("tipo");
			consultaLugaresFacade consultarLugar = new consultaLugaresFacade();
			try {
				lugares=consultarLugar.consultarLugarPorCategorias(tipo);
				if(lugares.isEmpty()){
					PrintWriter out=response.getWriter();
					   out.println("Error, no se encontro el lugar.");
				}
				else{
				request.setAttribute("lugares", lugares);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
    		rd.forward(request, response);
		}
		if(accion.equalsIgnoreCase("todo")){
			lugares.clear();
			consultaLugaresFacade consultarLugar = new consultaLugaresFacade();
			try {
				lugares=consultarLugar.consultarTodosLugares();
				if(lugares.isEmpty()){
					PrintWriter out=response.getWriter();
					   out.println("Error, no hay lugares.");
				}
				else{
				request.setAttribute("lugares", lugares);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("mostrar.jsp");
    		rd.forward(request, response);
		}
	}

}
