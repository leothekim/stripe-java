package com.stripe.model;


import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

public class BankAccount extends APIResource implements PaymentSource {
	String id;
	String country;
	String last4;
	String bankName;
	Boolean validated;
	String currency;
	String status;
	String fingerprint;
	Boolean defaultForCurrency;
	String object;
	String customer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLast4() {
		return last4;
	}

	public void setLast4(String last4) {
		this.last4 = last4;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Boolean getValidated() {
		return validated;
	}

	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public Boolean getDefaultForCurrency() {
		return defaultForCurrency;
	}

	public void setDefaultForCurrency(Boolean defaultForCurrency) {
		this.defaultForCurrency = defaultForCurrency;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getInstanceURL() {
		if (this.getCustomer() != null) {
			return String.format("%s/%s/bank_accounts/%s", classURL(Customer.class), this.getCustomer(), this.getId());
		} else {
			return null;
		}
	}

	public PaymentSource update(Map<String, Object> params) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		return update(params, null);
	}

	public PaymentSource update(Map<String, Object> params, final RequestOptions options) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, this.getInstanceURL(), params, BankAccount.class, options);
	}

	public DeletedStripeObject delete() throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		return delete(null);
	}

	public DeletedStripeObject delete(RequestOptions options) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		return request(RequestMethod.DELETE, this.getInstanceURL(), null, DeletedBankAccount.class, options);
	}
}
