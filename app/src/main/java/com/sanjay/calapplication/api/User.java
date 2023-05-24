package com.sanjay.calapplication.api;

public class User/*model class*/ {
      private  String access_token;
      private String token_type;
      private String expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }
    public String getToken_type() {
        return token_type;
    }
    public void setAccess_token()
    {
        this.access_token = access_token;
    }
    public void setToken_type(){
        this.token_type = token_type;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}
