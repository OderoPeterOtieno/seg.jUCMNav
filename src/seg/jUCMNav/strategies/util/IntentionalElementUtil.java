package seg.jUCMNav.strategies.util;

import grl.Contribution;
import grl.Decomposition;
import grl.DecompositionType;
import grl.ElementLink;
import grl.Feature;
import grl.IntentionalElement;

import java.util.Iterator;

import seg.jUCMNav.extensionpoints.IGRLStrategyAlgorithm;
import seg.jUCMNav.model.ModelCreationFactory;
import seg.jUCMNav.model.util.MetadataHelper;
import seg.jUCMNav.strategies.EvaluationStrategyManager;
import urncore.Metadata;

/**
 * This class is used when we need to find out more about an IntentionalElement, especially the parent and children links
 * it is mainly used as conditions for evaluation and coloring strategy
 * @author Yanji Liu
 *
 */
public class IntentionalElementUtil {
    /**
     * Returns true if the element only contains optional destination links, returns false otherwise
     * Note: when no dest link, return false
     * @param elem
     * @return
     */
    public static boolean containsOnlyOptionalDestLink(IntentionalElement elem){
        Iterator it = elem.getLinksDest().iterator();
        if (!it.hasNext()) {
            return false;
        }
        while (it.hasNext()) {
            ElementLink link = (ElementLink) it.next();
            if (link instanceof Contribution) {
                if (!ModelCreationFactory.containsMetadata(link.getMetadata(), ModelCreationFactory.getFeatureModelOptionalLinkMetadata())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns true if the element only contains optional src links, returns false otherwise
     * Note: when no src link, return false
     * @param elem
     * @return
     */
    public static boolean containsOnlyOptionalSrcLink(IntentionalElement elem){
        Iterator it = elem.getLinksSrc().iterator();
        if (!it.hasNext()) {
            return false;
        }
        while (it.hasNext()) {
            ElementLink link = (ElementLink) it.next();
            if (link instanceof Contribution) {
                if (!ModelCreationFactory.containsMetadata(link.getMetadata(), ModelCreationFactory.getFeatureModelOptionalLinkMetadata())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns true if the element contains only optional src links or OR links, returns false otherwise
     * Note: when no src link, return false
     * @param elem
     * @return
     */
    public static boolean containsOnlyOptionalOrORSrcLink(IntentionalElement elem){
        Iterator it = elem.getLinksSrc().iterator();
        // if no parent link, return false
        if (!it.hasNext()) {
            return false;
        }
        while (it.hasNext()) {
            ElementLink link = (ElementLink) it.next();
            if (MetadataHelper.getMetaDataObj(link, "FeatureModel") == null) {
            	continue;
            }
            if (link instanceof Contribution) {
            	// if contribution link but not optional
                if (!ModelCreationFactory.containsMetadata(link.getMetadata(), ModelCreationFactory.getFeatureModelOptionalLinkMetadata())) {
                	return false;
                }
            } else if (link instanceof Decomposition) {
                // for each source
                IntentionalElement srcElem = (IntentionalElement)link.getDest();
                // if decomposition type is XOR
                if (srcElem != null) {
                    if (srcElem.getDecompositionType() != DecompositionType.OR_LITERAL && srcElem.getDecompositionType() != DecompositionType.XOR_LITERAL) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns the number of Mandatory destination links
     * @param element
     * @return
     */
    public static int getNumberOfMandatoryDestLinks(IntentionalElement element){
        int MandatoryLinks = 0;
        Iterator it = element.getLinksDest().iterator();
        while (it.hasNext()) {
            ElementLink link = (ElementLink) it.next();
            if (link instanceof Contribution) {
                if(ModelCreationFactory.containsMetadata(link.getMetadata(), ModelCreationFactory.getFeatureModelMandatoryLinkMetadata()))
                    MandatoryLinks++;
            }
        }
        return MandatoryLinks;
    }
    
    /**
     * Returns true if element has a XOR src link, and there exists a XOR brother element that has numerical evaluation at 100
     * @param elem
     * @return
     */
    public static boolean hasFullXorBrother(IntentionalElement elem) {
        Iterator it = elem.getLinksSrc().iterator();
        // if it doesn't have source, return falses
        if (!it.hasNext()) {
            return false;
        }
        while (it.hasNext()) {
            ElementLink link = (ElementLink) it.next();
            if (link instanceof Decomposition) {
                // for each source
                IntentionalElement srcElem = (IntentionalElement)link.getDest();
                // if decomposition type is XOR
                if (srcElem != null) {
                    if (srcElem.getDecompositionType() == DecompositionType.XOR_LITERAL) {
                        Iterator srcIt = srcElem.getLinksDest().iterator();
                        while (srcIt.hasNext()) {
                            ElementLink broLink = (ElementLink) srcIt.next();
                            if (broLink instanceof Decomposition) {
                                // for each brother element
                                IntentionalElement broElem = (IntentionalElement)broLink.getSrc();
                                if (!broElem.equals(elem) && hasNumericalValue(broElem, 100)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns true if element has a OR or XOR src link, and there exists a OR or XOR brother element that has numerical evaluation at 100
     * @param elem
     * @return
     */
    public static boolean hasFullOrBrother(final IntentionalElement elem) {
        Iterator it = elem.getLinksSrc().iterator();
        // if it doesn't have source, return falses
        if (!it.hasNext()) {
            return false;
        }
        while (it.hasNext()) {
            ElementLink link = (ElementLink) it.next();
            if (link instanceof Decomposition) {
                // for each source
                IntentionalElement srcElem = (IntentionalElement)link.getDest();
                // if decomposition type is XOR
                if (srcElem != null) {
                    if (srcElem.getDecompositionType() == DecompositionType.OR_LITERAL || srcElem.getDecompositionType() == DecompositionType.XOR_LITERAL) {
                        Iterator srcIt = srcElem.getLinksDest().iterator();
                        while (srcIt.hasNext()) {
                            ElementLink broLink = (ElementLink) srcIt.next();
                            if (broLink instanceof Decomposition) {
                                // for each brother element
                                IntentionalElement broElem = (IntentionalElement)broLink.getSrc();
                                if (!broElem.equals(elem) && hasNumericalValue(broElem, 100)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Returns true if elem has given numerical value
     * Note: Null numerical value will be treated as 0
     * @param elem
     * @param value
     * @return
     */
    public static  boolean hasNumericalValue(IntentionalElement elem, int value) {
        String metaDataStr, valueStr;
        if (elem == null) return false;
        Metadata metaNumerical = MetadataHelper.getMetaDataObj(elem, EvaluationStrategyManager.METADATA_NUMEVAL);
        if (metaNumerical == null) metaDataStr = "0";
        else metaDataStr = metaNumerical.getValue();
        valueStr = Integer.toString(value);
        return metaDataStr.equals(valueStr);
    }

    /**
     * Returns true if this feature is auto selectable
     * autoselectable criteria is if it has a src link of mandatory/AND, and that linked parent feature is selected/parent feature is root
     * @param element
     * @return
     */
	public static boolean isAutoSelectable(IntentionalElement elem) {
		if (!(elem instanceof Feature)) return false;
		if (hasNumericalValue(elem, IGRLStrategyAlgorithm.FEATURE_SELECTED)) {
			return false;
		}
		if (isRootFeature(elem)) {
			return false;
		}
		Iterator it = elem.getLinksSrc().iterator();

        while (it.hasNext()) {
            ElementLink link = (ElementLink) it.next();
            if (link instanceof Contribution) {
            	// if has mandatory source link
                if (ModelCreationFactory.containsMetadata(link.getMetadata(), ModelCreationFactory.getFeatureModelMandatoryLinkMetadata())) {
                	IntentionalElement srcElem = (IntentionalElement)link.getDest();
                	if (srcElem != null && (srcElem instanceof Feature)) {
                		if ((hasNumericalValue(srcElem, IGRLStrategyAlgorithm.FEATURE_SELECTED)) || isRootFeature(srcElem)){
                    		return true;
                    	}
                	}
                }
            } else if (link instanceof Decomposition) {
                // for each source
                IntentionalElement srcElem = (IntentionalElement)link.getDest();
                // if has AND source link
                if (srcElem != null) {
                    if (srcElem.getDecompositionType() == DecompositionType.AND_LITERAL && (srcElem instanceof Feature)) {
                    	if ((hasNumericalValue(srcElem, IGRLStrategyAlgorithm.FEATURE_SELECTED)) || isRootFeature(srcElem)){
                    		return true;
                    	}
                    }
                }
            }
        }
		return false;
	}
	
	/**
	 * check if an intentional element is a root feature or not
	 * @param elem
	 * @return true, is a root feature, otherwise (not a feature or not a root) false
	 */
	public static boolean isRootFeature(IntentionalElement elem) {
		if (!(elem instanceof Feature)) return false;
		Iterator it = elem.getLinksSrc().iterator();
		while (it.hasNext()) {
			ElementLink srcLink = (ElementLink) it.next();
			if (srcLink.getDest() instanceof Feature) {
				return false;
			}
		}
		return true;
	}
}
