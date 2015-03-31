package Cassim2.Commands;


public interface Command {    
    
    public Command execute();
    
    @Override
    public String toString();

    public int getType();
}
