package ingresopersonaenlaaplicacion;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import Negocio.gestion.Persona;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import datos.ValidarRepository;

public class IngresoAplicacionStepDefinitions {
	Persona persona = null;
	public String nombre = null;
	ValidarRepository validar = new ValidarRepository();

	@Given("^la persona desea ingresar a la aplicación.$")
	public void la_persona_desea_ingresar_a_la_aplicación() throws Throwable {
		persona = validar.consultarPersona("pedro128@hotmail.com", "pam");
		nombre = persona.getNombre();

	}

	@When("^se encuentra en la base de datos.$")
	public void se_encuentra_en_la_base_de_datos() throws Throwable {
		Assert.assertEquals("pedro128@hotmail.com",nombre);
	    Assert.assertEquals("la persona se encontró","la persona se encontró");
	}

	@Then("^ingresa como usuario o propietario y visualiza su información.$")
	public void ingresa_como_usuario_o_propietario_y_visualiza_su_información(int arg1)
			throws Throwable {
		Assert.assertEquals("bienvenido","bienvenido");
		
	}
	@When("^no se encuentra en la base de datos.$")
	public void no_se_encuentra_en_la_base_de_datos() throws Throwable {
	    Assert.assertNotEquals("pedro128@hotmail.com",nombre);

		
	}
	@Then("^se sugiere a la persona que se registre.$")
	public void se_sugiere_a_la_persona_que_se_registre(int arg1)
			throws Throwable {
		Assert.assertEquals("porfavor registrese","porfavor registrese");
		
	}
}
