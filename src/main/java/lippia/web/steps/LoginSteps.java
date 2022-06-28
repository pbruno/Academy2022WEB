package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.LoginService;

public class LoginSteps extends PageSteps {

    @When("^el usuario ingresa su username (.*) y password (.*)$")
    public void elUsuarioIngresaSuUsernameUserYPasswordPass(String username, String password) {
        LoginService.completarUserPass(username, password);
    }

    @Then("^se verifica que ingreso correctamente a la web$")
    public void elUsuarioVerificaQueIngresoCorrectamenteALaWeb() {
        LoginService.verificarLogin();
    }

    @Given("^el usuario (.*) está logueado en la web Automation Practice$")
    public void elUsuarioEstáLogueadoEnLaWebAutomationPractice(String user) { LoginService.login(user);
    }

    @Then("^la contraseña se visualiza enmascarada$")
    public void laContraseñaSeVisualizaConMasc() {
        LoginService.verificaMascara();
    }

}
