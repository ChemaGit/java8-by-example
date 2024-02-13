package com.nacher.calc.controller;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 * Created by IntelliJ IDEA.
 * User: x037663
 * Date: 25-jun-2009
 * Time: 11:35:30
 * To change this template use File | Settings | File Templates.
 */
public class AbstractModel {
    /**
     * Convenience class that allow others to observe changes to the model properties
     */
    protected PropertyChangeSupport propertyChangeSupport;

    /**
     * Default constructor. Instantiates the PropertyChangeSupport class.
     */

    public AbstractModel() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    /**
     * Adds a property change listener to the observer list.
     * @param l The property change listener
     */
    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    /**
     * Removes a property change listener from the observer list.
     * @param l The property change listener
     */
    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }


    /**
     * Fires an event to all registered listeners informing them that a property in
     * this model has changed.
     * @param propertyName The name of the property
     * @param oldValue The previous value of the property before the change
     * @param newValue The new property value after the change
     */
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
}
