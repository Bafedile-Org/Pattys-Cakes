package za.co.pattybakery;

import za.co.pattybakery.exception.PaymentException;

public interface Payment {

    String AMOUNT_ERROR_MSG = "Amount Can Not Be Less Than Zero!!!!";
    String EMAIL_ERROR_MSG = "Delivery Email Can Not Be Null!!!";

    public void setAmount(Double amount) throws PaymentException;

    public Double getAmount();

    public void setEmail(String email) throws PaymentException;

    public String getEmail();
}
