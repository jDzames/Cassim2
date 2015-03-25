
package Cassim2;

import java.util.Stack;
import java.util.concurrent.Callable;


public class AutomaticSolution implements Callable<AutoSolObj>{
    private final Stack<Command> undoStack;

    public AutomaticSolution(Stack<Command> undoStack) {
        this.undoStack = undoStack;
    }

    @Override
    public AutoSolObj call() throws Exception {
        
        
        return new AutoSolObj();
    }


}
