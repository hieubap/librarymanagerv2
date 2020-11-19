package com.example.final_library.exception.generalexception;

public class ServerError extends RuntimeException {
    public ServerError(){
        super("Server not response");
    }
}
