package rest.application.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import servicios.ConsultaLugaresService;
import servicios.GestionLugaresService;
import servicios.GestionPersonasService;
@ApplicationPath("resources")
public class MyAplication extends Application {
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(ConsultaLugaresService.class);
		s.add(GestionLugaresService.class);
		s.add(GestionPersonasService.class);
		return s;
	}
}
