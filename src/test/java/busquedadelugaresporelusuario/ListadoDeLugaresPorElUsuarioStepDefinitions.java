 package busquedadelugaresporelusuario;

import java.util.ArrayList;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import datos.ValidarRepository;
import Negocio.gestion.Persona;
import Negocio.gestion.Usuario;
import Negocio.lugar.Lugar;

public class ListadoDeLugaresPorElUsuarioStepDefinitions {
	Persona usuario = null;
	ValidarRepository validar = new ValidarRepository();
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	
	@Given("^El usuario va a consultar el lugar.$")
	public void El_usuario_va_a_consultar_el_lugar() throws Throwable {
		// Express the Regexp above with the code you wish you had
		this.usuario = validar.consultarPersona("pedro128@hotmail.com", "pam"); 
		lugares=usuario.consultarLugar("nombre", "UCO");
	}

	@When("^El lugar ya no existe.$")
	public void el_lugar_ya_no_existe() throws Throwable {
		// Express the Regexp above with the code you wish you had
        lugares.isEmpty();
	}

	@Then("^Se notifica que este lugar ya no existe.$")
	public void se_notifica_que_este_lugar_ya_no_existe() throws Throwable {
		// Express the Regexp above with the code you wish you had
        Assert.assertEquals("No hay lugares","No hay lugares");
	}
	
	

	@When("^Encuentra el lugar.$")
	public void encuentra_el_lugar() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertTrue(lugares.size()>0);
	}

	@Then("^Visualiza sus caracteristicas.$")
	public void visualiza_sus_caracteristicas() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Assert.assertEquals("UCO", lugares.get(0).getNombre());
	    Assert.assertEquals("informacion", lugares.get(0).getCatenom());
	}
	

	@When("^Encuentra el lugar pero este cambio su ubicacion.$")
	public void encuentra_el_lugar_pero_este_cambio_su_ubicacion() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertTrue(lugares.size()>0);
		
	}

	@Then("^Se notifica la nueva ubicacion y se visualizan sus caracteristicas.$")
	public void se_notifica_la_nueva_ubicacion_y_se_visualizan_sus_caracteristicas() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertEquals("ubicacion","ubicacion" );
	}


}
