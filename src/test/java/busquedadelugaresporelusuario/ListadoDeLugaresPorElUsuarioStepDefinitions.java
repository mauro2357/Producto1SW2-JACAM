package busquedadelugaresporelusuario;

import java.util.ArrayList;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import datos.ValidarRepository;
import Negocio.gestion.Persona;
import Negocio.lugar.*;

public class ListadoDeLugaresPorElUsuarioStepDefinitions {
	Persona usuario = null;
	Lugar lugar = null;
	ValidarRepository validar = new ValidarRepository();
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	
	@Given("^El usuario va a consultar los lugares.$")
	public void El_usuario_va_a_consultar_los_lugares() throws Throwable {
		// Express the Regexp above with the code you wish you had
		this.usuario = validar.consultarPersona("pedro128@hotmail.com", "pam"); 
		Consulta consulta = new Consulta("todos",null);
		lugares = consulta.realizarBusqueda();
	}

	@When("^No existen lugares.$")
	public void no_existen_lugares() throws Throwable {
		// Express the Regexp above with the code you wish you had
        lugares.isEmpty();
	}

	@Then("^Se notifica que no existen lugares.$")
	public void se_notifica_que_este_lugar_ya_no_existe() throws Throwable {
		// Express the Regexp above with the code you wish you had
        Assert.assertEquals("No hay lugares","No hay lugares");
	}
	
	

	@When("^Se encuentran lugaras.$")
	public void se_encuentra_lugares() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertTrue(lugares.size()>0);
	}

	@Then("^Visualiza sus caracteristicas.$")
	public void visualiza_sus_caracteristicas() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Assert.assertEquals("UCO", lugares.get(0).getNombre());
	    Assert.assertEquals("informacion", lugares.get(0).getCatenom());
	}
	
	
	@Given("^El usuario consulta la categoría.$")
	public void el_usuario_consulta_la_categoría() throws Throwable {
		// Express the Regexp above with the code you wish you had
		this.usuario = validar.consultarPersona("pedro128@hotmail.com", "pam"); 
		Consulta consulta = new Consulta("categoria","Restaurantes");
		lugares = consulta.realizarBusqueda(); 
	}

	@When("^Encuentra la categoría pero no lugares en ella.$")
	public void encuentra_la_categoría_pero_no_lugares_en_ella() throws Throwable {
		// Express the Regexp above with the code you wish you had
        lugares.isEmpty();
	}

	@Then("^Se invalida la acción.$")
	public void se_invalida_la_acción() throws Throwable {
		// Express the Regexp above with the code you wish you had
        Assert.assertEquals("No hay lugares","No hay lugares");
	}
	
	@When("^Encuentra la categoría con sus lugares respectivos$")
	public void encuentra_la_categoría_con_sus_lugares_respectivos() throws Throwable {
		// Express the Regexp above with the code you wish you had
		Assert.assertTrue(lugares.size()>0);
	}

	@Then("^Visualiza la información.$")
	public void visualiza_la_información() throws Throwable {
		// Express the Regexp above with the code you wish you had
		Assert.assertEquals("Restaurantes", lugares.get(0).getCatenom());
	    Assert.assertEquals("informacion", lugares.get(0).getInformacion());
	}
	
	@Given("^El usuario consulta la coordenada.$")
	public void el_usuario_consulta_la_coordenada() throws Throwable {
		// Express the Regexp above with the code you wish you had
		this.usuario = validar.consultarPersona("pedro128@hotmail.com", "pam"); 
		Consulta consulta = new Consulta("ubicacion","1234,5678");
		lugares = consulta.realizarBusqueda(); 
	}
	@When("^No se encuentra el lugar en dicha coordenada.$")
	public void no_se_encuentra_el_lugar_en_dicha_coordenada() throws Throwable {
		// Express the Regexp above with the code you wish you had
		lugares.isEmpty();
	}

	@Then("^Se notifica que no existe.$")
	public void se_notifica_que_no_existe() throws Throwable {
		// Express the Regexp above with the code you wish you had
        Assert.assertEquals("No existe el lugar","No existe el lugar");
        
	}
	@When("^Encuentra el lugar en dicha coordenada.$")
	public void encuentra_el_lugar_en_dicha_coordenada() throws Throwable {
		// Express the Regexp above with the code you wish you had
		Assert.assertTrue(lugares.size()>0);
	}

	@Then("^Visualiza su información .$")
	public void visualiza_su_información () throws Throwable {
		// Express the Regexp above with the code you wish you had
		Assert.assertEquals("1234,567", lugares.get(0).getCoordenadas());
	    Assert.assertEquals("informacion", lugares.get(0).getInformacion());
	}

	@Given("^El usuario consulta lugares por nombre.$")
	public void el_usuario_consulta_lugares_por_nombre() throws Throwable {
		// Express the Regexp above with the code you wish you had
		this.usuario = validar.consultarPersona("pedro128@hotmail.com", "pam"); 
		Consulta consulta = new Consulta("nombre","UCO");
		lugares = consulta.realizarBusqueda(); 
	}
	@When("^No se encuentra el lugar.$")
	public void no_se_encuentra_el_lugar() throws Throwable {
		// Express the Regexp above with the code you wish you had
		lugares.isEmpty();
	}

	@Then("^Se notifica que el lugar no existe.$")
	public void se_notifica_que_el_lugar_no_existe() throws Throwable {
		// Express the Regexp above with the code you wish you had
        Assert.assertEquals("No existe el lugar","No existe el lugar");
        
	}
	@When("^Se encuentra el lugar.$")
	public void Se_encuentra_el_lugar() throws Throwable {
		// Express the Regexp above with the code you wish you had
		lugares.isEmpty();
	}

	@Then("^Se visualiza se información.$")
	public void se_visualiza_su_informacion() throws Throwable {
		// Express the Regexp above with the code you wish you had
		 Assert.assertEquals("UCO", lugares.get(0).getNombre());
		 Assert.assertEquals("informacion", lugares.get(0).getCatenom());  
	}
	
}
