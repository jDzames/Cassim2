package Cassim2;

public class FileWritingException extends RuntimeException {

    String sprava;
    
    public FileWritingException() {
    }

    public FileWritingException(String sprava) {
        this.sprava=sprava;
    }

    public String getSprava() {
        return sprava;
    }
    
}
