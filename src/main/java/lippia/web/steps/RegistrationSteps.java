package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.CommonService;
import lippia.web.services.RegistrationService;
import lippia.web.services.ShopService;

public class RegistrationSteps extends PageSteps {

    @And("^el usuario ingresa su email \"(.*)\" y password \"(.*)\"$")
    public void elUsuarioIngresaSuEmailEmailYPasswordPass(String email, String pass) {
        RegistrationService.completarEmailPass(email, pass);
    }

}
