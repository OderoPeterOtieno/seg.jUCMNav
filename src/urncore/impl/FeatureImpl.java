/**
 */
package urncore.impl;

import core.COREConfiguration;
import core.COREFeature;
import core.COREModel;
import core.COREModelElement;
import core.CORENamedElement;
import core.COREStrategy;
import core.CorePackage;

import grl.impl.IntentionalElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import urncore.Feature;
import urncore.UrncorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urncore.impl.FeatureImpl#getRealizedBy <em>Realized By</em>}</li>
 *   <li>{@link urncore.impl.FeatureImpl#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link urncore.impl.FeatureImpl#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends IntentionalElementImpl implements Feature {
	/**
	 * The cached value of the '{@link #getRealizedBy() <em>Realized By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedBy()
	 * @generated
	 * @ordered
	 */
	protected EList realizedBy;

	/**
	 * The cached value of the '{@link #getStrategies() <em>Strategies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategies()
	 * @generated
	 * @ordered
	 */
	protected EList strategies;

	/**
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList configurations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UrncorePackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRealizedBy() {
		if (realizedBy == null) {
			realizedBy = new EObjectWithInverseResolvingEList.ManyInverse(COREModel.class, this, UrncorePackage.FEATURE__REALIZED_BY, CorePackage.CORE_MODEL__REALIZES);
		}
		return realizedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getStrategies() {
		if (strategies == null) {
			strategies = new EObjectContainmentEList(COREStrategy.class, this, UrncorePackage.FEATURE__STRATEGIES);
		}
		return strategies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConfigurations() {
		if (configurations == null) {
			configurations = new EObjectContainmentEList(COREConfiguration.class, this, UrncorePackage.FEATURE__CONFIGURATIONS);
		}
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UrncorePackage.FEATURE__REALIZED_BY:
				return ((InternalEList)getRealizedBy()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UrncorePackage.FEATURE__REALIZED_BY:
				return ((InternalEList)getRealizedBy()).basicRemove(otherEnd, msgs);
			case UrncorePackage.FEATURE__STRATEGIES:
				return ((InternalEList)getStrategies()).basicRemove(otherEnd, msgs);
			case UrncorePackage.FEATURE__CONFIGURATIONS:
				return ((InternalEList)getConfigurations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UrncorePackage.FEATURE__REALIZED_BY:
				return getRealizedBy();
			case UrncorePackage.FEATURE__STRATEGIES:
				return getStrategies();
			case UrncorePackage.FEATURE__CONFIGURATIONS:
				return getConfigurations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UrncorePackage.FEATURE__REALIZED_BY:
				getRealizedBy().clear();
				getRealizedBy().addAll((Collection)newValue);
				return;
			case UrncorePackage.FEATURE__STRATEGIES:
				getStrategies().clear();
				getStrategies().addAll((Collection)newValue);
				return;
			case UrncorePackage.FEATURE__CONFIGURATIONS:
				getConfigurations().clear();
				getConfigurations().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UrncorePackage.FEATURE__REALIZED_BY:
				getRealizedBy().clear();
				return;
			case UrncorePackage.FEATURE__STRATEGIES:
				getStrategies().clear();
				return;
			case UrncorePackage.FEATURE__CONFIGURATIONS:
				getConfigurations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UrncorePackage.FEATURE__REALIZED_BY:
				return realizedBy != null && !realizedBy.isEmpty();
			case UrncorePackage.FEATURE__STRATEGIES:
				return strategies != null && !strategies.isEmpty();
			case UrncorePackage.FEATURE__CONFIGURATIONS:
				return configurations != null && !configurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == CORENamedElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == COREModelElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == COREFeature.class) {
			switch (derivedFeatureID) {
				case UrncorePackage.FEATURE__REALIZED_BY: return CorePackage.CORE_FEATURE__REALIZED_BY;
				case UrncorePackage.FEATURE__STRATEGIES: return CorePackage.CORE_FEATURE__STRATEGIES;
				case UrncorePackage.FEATURE__CONFIGURATIONS: return CorePackage.CORE_FEATURE__CONFIGURATIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == CORENamedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == COREModelElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == COREFeature.class) {
			switch (baseFeatureID) {
				case CorePackage.CORE_FEATURE__REALIZED_BY: return UrncorePackage.FEATURE__REALIZED_BY;
				case CorePackage.CORE_FEATURE__STRATEGIES: return UrncorePackage.FEATURE__STRATEGIES;
				case CorePackage.CORE_FEATURE__CONFIGURATIONS: return UrncorePackage.FEATURE__CONFIGURATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FeatureImpl
