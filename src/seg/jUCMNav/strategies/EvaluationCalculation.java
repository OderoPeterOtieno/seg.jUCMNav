package seg.jUCMNav.strategies;

import grl.IntentionalElement;

/**
 * Data container object used by the propagation mechanism.
 * 
 * @author Jean-Francois Roy, Yanji Liu
 * 
 */
public class EvaluationCalculation {
    private IntentionalElement element;
    private int linkCalc;
    private int totalLinkDest;
    private int totalLinkSrc;
    private boolean linkSrc;

    public EvaluationCalculation(IntentionalElement element, int totalLink) {
        this(element, totalLink, false);
    }
    
    public EvaluationCalculation(IntentionalElement element, int totalLink, boolean linkSrc) {
    	this.element = element;
    	this.linkCalc = 0;
    	this.linkSrc = linkSrc;
    	if (linkSrc) {
            this.totalLinkSrc = totalLink;
    	} else {
            this.totalLinkDest = totalLink;
    	}
    }
    
    public boolean hasExceededTotalLink() {
    	if (linkSrc)
    		return this.linkCalc <= this.totalLinkSrc;
    	else 
    		return this.linkCalc >= this.totalLinkDest;
    }
    
    public void incrementLinkCalc() {
    	this.linkCalc++;
    }

	public IntentionalElement getElement() {
		return this.element;
	}
	
	public boolean isLinkSrc() {
		return this.linkSrc;
	}
}
