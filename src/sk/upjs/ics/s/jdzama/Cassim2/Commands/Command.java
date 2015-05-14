package sk.upjs.ics.s.jdzama.Cassim2.Commands;

import java.util.List;


public interface Command {    
    
    public Command execute();
    
    @Override
    public String toString();

    public int getType();
}
