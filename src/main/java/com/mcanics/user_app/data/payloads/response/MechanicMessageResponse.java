package com.mcanics.user_app.data.payloads.response;

public class MechanicMessageResponse {

    private String message;

    public MechanicMessageResponse(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
