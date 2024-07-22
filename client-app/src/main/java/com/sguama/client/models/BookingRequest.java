package com.sguama.client.models;

public class BookingRequest {

    private Long flightId;
    private String userName;

    public BookingRequest() {
    }

    public BookingRequest(Long flightId, String userName) {
        this.flightId = flightId;
        this.userName = userName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
