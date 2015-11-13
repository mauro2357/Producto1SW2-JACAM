package gestióndeinformacióndeusuario;

import java.util.ArrayList;

import org.junit.Assert;

import Negocio.Localizacion.ubicacion;
import Negocio.gestion.Persona;
import Negocio.gestion.Usuario;
import Negocio.lugar.Lugar;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import datos.LugarRepository;
import datos.ValidarRepository;

public class RegistrarEliminarFavoritosStepDefinitions {
	Persona usuario = null;
	Usuario usu = null;
	ValidarRepository validar = new ValidarRepository();
	LugarRepository lugar = new LugarRepository();
	Lugar lugar1 = null;
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	@Given("^El usuario consulta un lugar$")
	public void el_usuario_consulta_un_lugar() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		usuario =validar.consultarPersona("pedro128@hotmail.com", "pam"); 
	}

	@When("^Encuentra el lugar y se almacena en su lista de favoritos$")
	public void encuentra_el_lugar_y_se_almacena_en_su_lista_de_favoritos() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		lugares = usuario.consultarLugar("nombre", "View");
		 Assert.assertEquals("View", lugares.get(0).getNombre());
		Lugar lugar1 = lugares.get(0);
	    lugar.RegistroFavorito("pedro128@hotmail.com", lugar1);
	}

	@Then("^visualiza con mayor facilidad la información.$")
	public void Visualiza_con_mayor_facilidad_la_información() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Assert.assertEquals("View", lugar1.getNombre());
	    Assert.assertEquals("informacion", lugar1.getInformacion());
	}

	@Given("^El desea eliminar un lugar$")
	public void el_usuario_desea_eliminar_un_lugar() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		usuario =validar.consultarPersona("pedro128@hotmail.com", "pam"); 
	}

	@When("^Elige el lugar a eliminar$")
	public void elige_el_lugar_a_eliminar() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		lugares = usuario.consultarLugar("nombre", "UCO");
		Assert.assertEquals("UCO", lugares.get(0).getNombre());
		
	}

	@Then("El lugar se elimina")
	public void el_lugar_se_elimina() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Lugar lugar1 = lugares.get(0);	
		lugar.quitarFavorito("pedro128@hotmail.com", lugar1);
	}


}
