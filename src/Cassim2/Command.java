package Cassim2;


public interface Command {    
    
    void execute();
    
    @Override
    String toString();
}
