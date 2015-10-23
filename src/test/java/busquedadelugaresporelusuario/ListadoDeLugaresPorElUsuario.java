 package busquedadelugaresporelusuario;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Negocio.busquedadelugaresporelusuario.Lugar;
import Negocio.login.Usuario;

public class ListadoDeLugaresPorElUsuario {
	Usuario usuario = null;
	
	//@Given("^El usuario va a consultar el lugar.$")
	/*public void El_usuario_va_a_consultar_el_lugar() throws Throwable {
		// Express the Regexp above with the code you wish you had
        usuario = new Usuario(); 

	}

	@When("^El lugar ya no existe.$")
	public void el_lugar_ya_no_existe() throws Throwable {
		// Express the Regexp above with the code you wish you had
        
	}

	@Then("^Se notifica que este lugar ya no existe.$")
	public void se_notifica_que_este_lugar_ya_no_existe() throws Throwable {
		// Express the Regexp above with the code you wish you had
        Assert.assertEquals("No hay lugares", usuario.getMensaje());
	}
	
	

	@When("^Encuentra el lugar.$")
	public void encuentra_el_lugar() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		usuario.consultarLugares();
		Assert.assertTrue(usuario.getLugares().size()>0);
	}

	@Then("^Visualiza sus caracteristicas.$")
	public void visualiza_sus_caracteristicas() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Lugar lugar = usuario.getLugares().get(0);
	    Assert.assertEquals("Toscana", lugar.getNombre());
	    Assert.assertEquals("informacion", lugar.getInformacion());
	}
	

	@When("^Encuentra el lugar pero este cambio su ubicacion.$")
	public void encuentra_el_lugar_pero_este_cambio_su_ubicacion() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		usuario.consultarLugares();
		
	}

	@Then("^Se notifica la nueva ubicacion y se visualizan sus caracteristicas.$")
	public void se_notifica_la_nueva_ubicacion_y_se_visualizan_sus_caracteristicas() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertEquals("El lugar que busca ha cambiado su ubicacion", usuario.getMensaje());
	}
	

	@When("^El lugar no esta registrado en la aplicacion.$")
	public void el_lugar_no_esta_registrado_en_la_aplicacion() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		usuario.consultarLugares();
	}

	@Then("^Se notifica que este lugar no ha sido registrado aun en la aplicacion.$")
	public void se_notifica_que_este_lugar_no_ha_sido_registrado_aun_en_la_aplicacion() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertEquals("El lugar que busca aun no se ha registrado en la aplicacion", usuario.getMensaje());
	    
	}
	

	@When("^Se ubican todos los lugares cercanos a el.$")
	public void se_ubican_todos_los_lugares_cercanos_a_el() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		usuario.consultarLugares();
	}

	@Then("^Se notifica un listado de los lugares encontrados.$")
	public void se_notifica_un_listado_de_los_lugares_encontrados() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertEquals("Lista de lugares", usuario.getMensaje());
	}*/

}
