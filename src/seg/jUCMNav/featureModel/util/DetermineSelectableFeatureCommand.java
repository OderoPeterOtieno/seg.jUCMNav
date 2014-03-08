package seg.jUCMNav.featureModel.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import grl.Feature;
import grl.IntentionalElement;
import seg.jUCMNav.strategies.util.IntentionalElementUtil;
import urn.URNspec;

public class DetermineSelectableFeatureCommand {
	
	public static List<Feature> determineSelectableForAllFeatures(URNspec urnSpec) {
		
		Iterator it = urnSpec.getGrlspec().getIntElements().iterator();
		List<Feature> selectableFeatures = new ArrayList<Feature>();
		 while (it.hasNext()) {
			 IntentionalElement intlElem = (IntentionalElement) it.next();
			 if (intlElem instanceof Feature) {
				 if (IntentionalElementUtil.containsOnlyOptionalOrORSrcLink(intlElem)) {
					 // add to result list and set selectable to true
					 selectableFeatures.add((Feature)intlElem);
					 ((Feature) intlElem).setSelectable(true);
				 }
			 }
		 }
		 return selectableFeatures;
	}
}
