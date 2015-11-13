package registrodepersonasenlaaplicación;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import Negocio.gestion.Persona;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import datos.ValidarRepository;

public class RegistroPersonaStepDefinitions {
	Persona persona = null;
	public String email = null;
	public String clave = null;
	ValidarRepository validar = new ValidarRepository();
	public int registro;

	@Given("^la persona desea registrarse.$")
	public void la_persona_desea_registrarse() throws Throwable {
		registro = validar.registrar(persona);

	}

	@When("^la persona llena el formulario.$")
	public void la_persona_llena_el_formulario() throws Throwable {
	    email = persona.getNombre();
	    clave = persona.getClave();
	    persona = validar.consultarPersona(email, clave);
	}

	@Then("^ingresa como usuario o propietario y visualiza su información.$")
	public void ingresa_como_usuario_o_propietario_y_visualiza_su_información(int arg1) 
			throws Throwable {
		Assert.assertEquals(persona,validar.consultarPersona("pedro128@hotmail.com", "pam"));
		
	}
}
