package Cassim2;


public interface Command {    
    
    public Command execute();
    
    @Override
    public String toString();

    public int getType();
}
