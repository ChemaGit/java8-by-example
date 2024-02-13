package com.nacher.calc.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: x037663
 * Date: 24-jun-2009
 * Time: 13:34:44
 * To change this template use File | Settings | File Templates.
 */
public class SwingUtils {
    public static GridBagConstraints customConstraint(int fill, int insetsLeft, int insetsRight, int insetsTop, int insetsBottom,
                                                               int gridx, int gridy, int gridWidth, int gridHeight,
                                                               int ipadx, int ipady){
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = fill;
        constraint.insets.left = insetsLeft;
        constraint.insets.right = insetsRight;
        constraint.insets.top = insetsTop;
        constraint.insets.bottom = insetsBottom;
        constraint.gridx = gridx;
        constraint.gridy = gridy;
        constraint.gridwidth = gridWidth;
        constraint.gridheight = gridHeight;
        constraint.ipadx = ipadx;
        constraint.ipady = ipady;
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.weightx = 0;
        constraint.weighty = 0;
        return constraint;
    }

    public static GridBagConstraints buildDefaultConstraint(){
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets.left = 2;
        constraint.insets.right = 2;
        constraint.insets.top = 2;
        constraint.insets.bottom = 2;
        return constraint;
    }

    public static void addGB(Container cont, Component comp, GridBagConstraints constraints, int x, int y){
        constraints.gridx=x;
        constraints.gridy=y;
        cont.add(comp,constraints);
    }

    public static JDialog buildDialog(Component parent, String title,boolean modal){
        Window window=SwingUtilities.getWindowAncestor(parent);
        JDialog retorno=null;
        if(window instanceof Dialog){
            retorno=new JDialog((Dialog)window,title,modal);
        }else if(window instanceof Frame){
            retorno=new JDialog((Frame)window,title,modal);
        }
        return retorno;
    }
}
