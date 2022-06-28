package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.HomeService;


public class HomeSteps extends PageSteps {

    @Then("^se visualiza los tres nuevos ingresos$")
    public void seVisualizaLosTresNuevosIngresos() {HomeService.verificaIngresos(); }

    @When("el usuario selecciona un nuevo ingreso")
    public void elUsuarioSeleccionaUnNuevoIngreso() {HomeService.seleccionarIngresos(); }
}
