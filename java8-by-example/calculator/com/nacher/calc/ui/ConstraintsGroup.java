package com.nacher.calc.ui;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: x037663
 * Date: 24-jun-2009
 * Time: 13:25:21
 * To change this template use File | Settings | File Templates.
 */
public class ConstraintsGroup extends GridBagConstraints {
    private   static final int NUM_CONSTRAINTS = 4;
    private   int number = 0;
    private   int[][] constraints;
    private   double[][] weights;
    private ConstraintsGroup() {}

    public ConstraintsGroup(int[][] constraints, double[][] weights) {
        super();
        this.constraints = constraints;
        this.weights = weights;
    }

    public void setConstraints(int element) {
        int[] location = constraints[element * NUM_CONSTRAINTS];
        int[] area = constraints[element * NUM_CONSTRAINTS + 1];
        int[] size = constraints[element * NUM_CONSTRAINTS + 2];
        int[] insets = constraints[element * NUM_CONSTRAINTS + 3];
        double[] weights = this.weights[element];
        this.weightx = weights[0];
        this.weighty = weights[1];
        this.gridx = location[0];
        this.gridy = location[1];
        this.gridwidth = area[0];
        this.gridheight = area[1];
        this.fill = size[0];
        this.anchor = size[1];

        if (insets != null) {
            this.insets = new Insets(insets[0],insets[1],insets[2],insets[3]);
        }
    }

    public GridBagConstraints getConstraints(int element) {
        setConstraints(element);
        return this;
    }
}

