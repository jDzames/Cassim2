package sk.upjs.ics.s.jdzama.Cassim2.exceptions;

public class FileWritingException extends RuntimeException {

    public String sprava;
    
    public FileWritingException() {
    }

    public FileWritingException(String sprava) {
        this.sprava=sprava;
    }

    public String getSprava() {
        return sprava;
    }
    
}
