package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.RegistrationConstants;

public class RegistrationService extends ActionManager {


    public static void completarEmailPass(String email, String pass) {
        setInput(RegistrationConstants.INPUT_REGEMAIL_ID, email);
        setInput(RegistrationConstants.INPUT_REGPASSWORD_ID, pass);
    }

}
