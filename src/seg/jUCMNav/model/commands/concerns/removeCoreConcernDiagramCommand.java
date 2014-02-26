package seg.jUCMNav.model.commands.concerns;

import org.eclipse.gef.commands.Command;

import core.COREConcern;
import seg.jUCMNav.Messages;
import seg.jUCMNav.model.commands.JUCMNavCommand;
import urncore.IURNDiagram;

/**
 * Command to remove a diagram from a core concern
 */
public class removeCoreConcernDiagramCommand extends Command implements JUCMNavCommand {

    // the diagram to which to be removed from the concern
    private IURNDiagram diagram;
    // the concern
    private COREConcern coreConcern;


    /**
     * @param diagram
     *            to which a concern is assigned
     * @param concern
     *            to assign (can be null in which case the existing concern is removed)
     */
    public removeCoreConcernDiagramCommand(IURNDiagram diagram, COREConcern coreConcern) {
        this.diagram = diagram;
        this.coreConcern = coreConcern;
        setLabel(Messages.getString("RemoveCoreConcernDiagramCommand.RemoveCoreConcernDiagramCommand")); //$NON-NLS-1$
    }

    /**
     * checks all conditions of testPreConditions that can be checked before execute()
     * 
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute() {
        return testConditionNotNull();
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute() {
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo() {
        testPreConditions();
        coreConcern.getModels().remove(diagram);
        testPostConditions();
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo() {
        testPostConditions();
        coreConcern.getModels().add(diagram);
        testPreConditions();
    }

    /**
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPostConditions()
     */
    public void testPostConditions() {
        assert testConditionNotNull() : "post diagram not null "; //$NON-NLS-1$
        assert !coreConcern.getModels().contains(diagram) : "diagram was removed"; //$NON-NLS-1$
    }

    /**
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPreConditions()
     */
    public void testPreConditions() {
        assert testConditionNotNull() : "pre diagram not null"; //$NON-NLS-1$
        assert coreConcern.getModels().contains(diagram) : "pre concern is original"; //$NON-NLS-1$
    }

    /**
     * @return true if condition is met, false otherwise
     */
    private boolean testConditionNotNull() {
        return diagram != null;
    }

}