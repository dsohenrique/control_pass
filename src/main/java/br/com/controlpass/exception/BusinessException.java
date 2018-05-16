
package br.com.controlpass.exception;


public class BusinessException extends Exception{

    private BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
    
    
}
