package pp5.services;

import java.util.HashMap;

/**
 * Created by Rafał on 2016-02-27.
 */
public class DotpayCompletePayment {
//    private String pin;
//    private DotpayCompletePaymentForm form;
//
//    private final String STATUS_OK = "OK";
//    private final String STATUS_FAIL = "FAIL";
//    private final String OPERATION_STATUS_COMPLETED = "completed";
    private HashMap<String,String> req;

    public DotpayCompletePayment(HashMap<String,String> req) {
        this.req = req;
    }

}
