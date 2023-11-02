package gov.ifms.ots.exception;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OtsException extends Exception{

     String exceptionMsg;

    public OtsException(){}
    public OtsException(String exception){
        this.exceptionMsg=exception;
    }
    public OtsException(String message,String exception){
        super(message) ;
        this.exceptionMsg=exception;
    }
    public void setExceptionMsg(String exception){
        this.exceptionMsg=exception;
    }
    public String getExceptionMsg(){
        return this.exceptionMsg;
}


}
