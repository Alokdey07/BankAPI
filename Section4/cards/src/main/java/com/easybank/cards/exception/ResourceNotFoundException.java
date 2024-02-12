package com.easybank.cards.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName,String fileName, String fieldValue){
        super(String.format("'%s not found with the given input date %s : %s,",resourceName,fieldValue,fieldValue));
    }
}
