package Cassim2;


public interface Command {    
    
    Command execute();
    
    @Override
    String toString();
}
