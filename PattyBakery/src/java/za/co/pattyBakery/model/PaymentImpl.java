package za.co.pattyBakery.model;

import za.co.pattyBakery.Payment;
import za.co.pattyBakery.exception.PaymentException;

public class PaymentImpl implements Payment {

    private Double amount;
    private String email;

    public PaymentImpl(Double amount, String email) throws PaymentException {
        this.setAmount(amount);
        this.setEmail(email);
    }

    @Override
    public void setAmount(Double amount) throws PaymentException {
        if (amount < 0) {
            throw new PaymentException(AMOUNT_ERROR_MSG);
        }
        this.amount = amount;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setEmail(String email) throws PaymentException {
        if (email == null) {
            throw new PaymentException(EMAIL_ERROR_MSG);
        }
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

}
