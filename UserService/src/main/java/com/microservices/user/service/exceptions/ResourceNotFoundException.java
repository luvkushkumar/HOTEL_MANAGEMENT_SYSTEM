package com.microservices.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException()
    {
        super("Resource Not Found on the server");
    }

    public  ResourceNotFoundException(String message)
    {
        super(message);
    }

}
