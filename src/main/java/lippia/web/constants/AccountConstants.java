package lippia.web.constants;

public class AccountConstants {

    /* Address */
    public static final String LINK_ADDRESS_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a";
    public static final String LINK_EDITBILL_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/div/div/div[1]/header/a";
    public static final String LINK_EDITSHIP_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a";
    public static final String BTN_SAVEADDSHIP_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/div/form/p[10]/input[1]";
    public static final String BTN_SAVEADDBILL_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/div/form/p[12]/input[1]";

    public static final String INPUT_NOMBRESHIP_ID = "id:shipping_first_name";
    public static final String INPUT_APELLIDOSHIP_ID = "id:shipping_last_name";
   // public static final String INPUT_PAISSHIPSHIP_ID = "xpath:"//*[@id="s2id_shipping_country"]";
    public static final String INPUT_CALLESHIP_ID = "id:shipping_address_1";
    public static final String INPUT_LOCALIDADSHIP_ID = "id:shipping_city";
    //public static final String INPUT_PROVINCIASHIP_ID = "id:username";
    public static final String INPUT_ZIPSHIP_ID = "id:shipping_postcode";
    public static final String INPUT_NOMBREBILL_ID = "id:billing_first_name";
    public static final String INPUT_APELLIDOBILL_ID = "id:billing_last_name";
    public static final String INPUT_EMAILBILL_ID = "id:billing_email";
    public static final String INPUT_PHONEBILL_ID = "id:billing_phone";
    //public static final String INPUT_PAISBILL_ID = "id:username";
    public static final String INPUT_CALLEBILL_ID = "id:billing_address_1";
    public static final String INPUT_LOCALIDADBILL_ID = "id:billing_city";
    //public static final String INPUT_PROVINCIABILL_ID = "id:username";
    public static final String INPUT_ZIPBILL_ID = "id:billing_postcode";
    public static final String TEXT_ADDRESSCHANGE_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/div[1]";

    public static final String INPUT_PROVISEARCH_XPATH = "xpath://*[@id=\"select2-chosen-2\"]";


    /* Account Details */
    public static final String LINK_ACCOUNTDETAILS_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/nav/ul/li[5]/a";
    public static final String INPUT_NOMBRE_ID = "id:account_first_name";
    public static final String INPUT_APELLIDO_ID = "id:account_last_name";
    public static final String INPUT_CURRENTPASS_ID = "id:password_current";
    public static final String INPUT_NEWPASS_ID = "id:password_1";
    public static final String INPUT_NEWPASSCONFIRM_ID = "id:password_2";
    public static final String BTN_SAVEPASS_XPATH = "xpath://*[@id=\"page-36\"]/div/div[1]/div/form/p[4]/input[3]";
}