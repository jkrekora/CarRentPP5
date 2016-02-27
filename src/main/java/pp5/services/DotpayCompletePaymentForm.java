package pp5.services;

/**
 * Created by Rafał on 2016-02-27.
 */
public class DotpayCompletePaymentForm {
    private String id;
    private String operation_number;
    private String operation_type;
    private String operation_status;
    private String operation_amount;
    private String operation_currency;
    private String operation_withdrawal_amount;
    private String operation_commission_amount;
    private String operation_original_amount;
    private String operation_original_currency;
    private String operation_datetime;
    private String operation_related_number;
    private String control;
    private String description;
    private String email;
    private String p_info;
    private String p_email;
    private String channel;
    private String channel_country;
    private String geoip_country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperation_number() {
        return operation_number;
    }

    public void setOperation_number(String operation_number) {
        this.operation_number = operation_number;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getOperation_status() {
        return operation_status;
    }

    public void setOperation_status(String operation_status) {
        this.operation_status = operation_status;
    }

    public String getOperation_amount() {
        return operation_amount;
    }

    public void setOperation_amount(String operation_amount) {
        this.operation_amount = operation_amount;
    }

    public String getOperation_currency() {
        return operation_currency;
    }

    public void setOperation_currency(String operation_currency) {
        this.operation_currency = operation_currency;
    }

    public String getOperation_withdrawal_amount() {
        return operation_withdrawal_amount;
    }

    public void setOperation_withdrawal_amount(String operation_withdrawal_amount) {
        this.operation_withdrawal_amount = operation_withdrawal_amount;
    }

    public String getOperation_commission_amount() {
        return operation_commission_amount;
    }

    public void setOperation_commission_amount(String operation_commission_amount) {
        this.operation_commission_amount = operation_commission_amount;
    }

    public String getOperation_original_amount() {
        return operation_original_amount;
    }

    public void setOperation_original_amount(String operation_original_amount) {
        this.operation_original_amount = operation_original_amount;
    }

    public String getOperation_original_currency() {
        return operation_original_currency;
    }

    public void setOperation_original_currency(String operation_original_currency) {
        this.operation_original_currency = operation_original_currency;
    }

    public String getOperation_datetime() {
        return operation_datetime;
    }

    public void setOperation_datetime(String operation_datetime) {
        this.operation_datetime = operation_datetime;
    }

    public String getOperation_related_number() {
        return operation_related_number;
    }

    public void setOperation_related_number(String operation_related_number) {
        this.operation_related_number = operation_related_number;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getP_info() {
        return p_info;
    }

    public void setP_info(String p_info) {
        this.p_info = p_info;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel_country() {
        return channel_country;
    }

    public void setChannel_country(String channel_country) {
        this.channel_country = channel_country;
    }

    public String getGeoip_country() {
        return geoip_country;
    }

    public void setGeoip_country(String geoip_country) {
        this.geoip_country = geoip_country;
    }
}
