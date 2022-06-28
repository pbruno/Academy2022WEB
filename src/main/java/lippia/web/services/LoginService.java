package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.CommonConstants;
import lippia.web.constants.LoginConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static lippia.web.services.CommonService.clickBoton;

public class LoginService extends ActionManager {

    //Login
    public static void login(String usuario) {
        String user = PropertyManager.getProperty(usuario);
        String pwd = PropertyManager.getProperty("pwd");
        navigateTo(PropertyManager.getProperty("web.base.url"));
        click(CommonConstants.BTN_MYACCOUNT_ID);
        completarUserPass(user, pwd);
        clickBoton("Login");
        verificarLogin();
    }

    public static void completarUserPass(String username, String password) {
        setInput(LoginConstants.INPUT_USERNAME_ID, username);
        setInput(LoginConstants.INPUT_PASSWORD_ID, password);
    }

    public static void verificarLogin() {
        waitVisibility(LoginConstants.BTN_LOGOUT_XPATH);
        Assert.assertTrue(isVisible(LoginConstants.BTN_LOGOUT_XPATH));
    }

    public static void verificaMascara() {
        String type_pass = getAttribute(LoginConstants.INPUT_PASSWORD_ID, "type");
        Assert.assertEquals(type_pass, "password","La cotraseña no está enmascarada");
    }
}

