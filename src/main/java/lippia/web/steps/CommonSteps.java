package lippia.web.steps;

        import com.crowdar.core.PageSteps;
        import io.cucumber.java.en.*;
        import lippia.web.services.CommonService;

public class CommonSteps extends PageSteps {

    @Given("El usuario se encuentra en la web Automation Practice")
    public void elUsuarioSeEncuentraEnLaWebAutomationPractice() {
        CommonService.navegarWeb();
    }

    @When("^el usuario clickea el link \"(.*)\"$")
    public void elUsuarioClickeaElLink(String textoLink) {CommonService.clickLink(textoLink); }

    @When("^el usuario clickea el menú \"(.*)\"$")
    public void elUsuarioClickeaElBotónDelMenú(String menu) { CommonService.clickMenu(menu); }

    @When("^el usuario clickea el botón \"(.*)\"$")
    public void elUsuarioClickeaElBotón(String boton) { CommonService.clickBoton(boton); }

    @Then("^se muestra mensaje de éxito \"(.*)\"$")
    public void seMuestraMensajeDeExito(String mensaje) {
        CommonService.verificarMensajeExito(mensaje);
    }

    @When("^el usuario clickea \"Atrás\" en el navegador")
    public void elUsuarioClickeaAtrásEnElNavegador() { CommonService.volverAtrasNavegador();}

    @Then("^se muestra mensaje de error \"(.*)\"$")
    public void seMuestraMensajeDeError(String mensaje) {
        CommonService.verificarMensaje(mensaje);
    }
}
