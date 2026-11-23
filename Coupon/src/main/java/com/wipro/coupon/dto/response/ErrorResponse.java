package com.wipro.coupon.dto.response;

public class ErrorResponse {

    private String errorMessage;
    private String status;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMessage,
                         String status) {
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(
            String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
