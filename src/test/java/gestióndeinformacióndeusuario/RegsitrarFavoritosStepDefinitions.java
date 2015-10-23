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
import datos.ValidarRepository;

public class RegsitrarFavoritosStepDefinitions {
	Persona usuario = null;
	ValidarRepository validar = new ValidarRepository();
	ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	@Given("^el usuario consulta un lugar$")
	public void El_usuario_consulta_un_lugar() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		usuario =validar.consultarPersona("pedro128@hotmail.com", "pam"); 
	}

	@When("^encuentra el lugar y se almacena en su lista de favoritos$")
	public void Encuentra_el_lugar_y_se_almacena_en_su_lista_de_favoritos() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		//lugar.get
		//Assert.assertTrue(usuario.getLugares().size()>0);
	    
	}

	@Then("^visualiza con mayor facilidad la información.$")
	public void Visualiza_con_mayor_facilidad_la_información() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		//Lugar lugar = usuario.getLugares().get(0);
	    //Assert.assertEquals("Toscana", lugar.getNombre());
	    //Assert.assertEquals("informacion", lugar.getInformacion());
	}


	@When("^encuentra el lugar y ya pertenece a su lista$")
	public void Encuentra_el_lugar_y_ya_pertenece_a_su_lista() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   
	    
	}

	@Then("^visualiza la información del lugar específico.$")
	public void Visualiza_la_información_del_lugar_específico() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		//Lugar lugar = usuario.getLugares().get(0);
	    //Assert.assertEquals("Toscana", lugar.getNombre());
	    //Assert.assertEquals("informacion", lugar.getInformacion());
	}


}
