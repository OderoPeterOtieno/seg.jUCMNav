package seg.jUCMNav.editors.resourceManagement;

import java.io.File;
import java.util.Iterator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import core.COREConcern;
import seg.jUCMNav.Messages;
import seg.jUCMNav.model.ModelCreationFactory;


/**
 * This class is used to load and save the {@link COREConcern} model from the file system.
 * 
 * This class is inspired from the IBM RedBook Eclipse Development using the Graphical Editing Framework and the Eclipse Modeling Framework
 * 
 */
public class CoreModelManager extends EmfModelManager {
    /**
     * Creates a new COREConcern.
     * 
     * @param path
     *            where should it be created
     * @return a new COREConcern
     */
    public COREConcern createCOREConcern(File path) {
        createResource(path);

        COREConcern coreConcern = ModelCreationFactory.getNewCoreConcern();

        resource.getContents().add(coreConcern);
        return coreConcern;
    }

    /**
     * Creates a new COREConcern.
     * 
     * @param path
     *            where should it be created
     * @param COREConcern
     *            the file's contents
     * @return a new COREConcern
     */
    public COREConcern createCOREConcern(File path, COREConcern coreConcern) {
        createResource(path);
        resource.getContents().add(coreConcern);
        return coreConcern;
    }

    /**
     * Creates a new COREConcern.
     * 
     * @param path
     *            where should it be created
     * @return a new COREConcern
     */
    public COREConcern createCOREConcern(IPath path) {
        createResource(path);

        COREConcern coreConcern = ModelCreationFactory.getNewCoreConcern();

        resource.getContents().add(coreConcern);
        return coreConcern;
    }

    /**
     * Creates a new COREConcern.
     * 
     * @param path
     *            where should it be created
     * @param COREConcern
     *            the file's contents
     * @return a new COREConcern
     */
    public COREConcern createCOREConcern(IPath path, COREConcern coreConcern) {
        createResource(path);
        resource.getContents().add(coreConcern);
        return coreConcern;
    }

    /**
     * The file extension for core.
     */
    protected String getFileExtension() {
        return Messages.getString("CoreModelManager.CoreExtention"); //$NON-NLS-1$
    }

    /**
     * Gets the top level model elements.
     * 
     * @return top level model elements
     */
    public COREConcern getModel() {
        if (null == model) {
            EList l = resource.getContents();
            Iterator i = l.iterator();
            while (i.hasNext()) {
                Object o = i.next();
                if (o instanceof COREConcern)
                    model = (COREConcern) o;
            }

            if (model == null)return null;
        }
        return (COREConcern) model;
    }

    /**
     * Initialize EMF
     */
    protected void init() {
    }
}