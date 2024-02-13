package com.nacher.calc.ui;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: x037663
 * Date: 24-jun-2009
 * Time: 13:27:03
 * To change this template use File | Settings | File Templates.
 */
public class GUIConstraints {
    public static final int FLE = GridBagConstraints.FIRST_LINE_END;
    public static final int FLS = GridBagConstraints.FIRST_LINE_START;
    public static final int LLE = GridBagConstraints.LAST_LINE_END;
    public static final int LLS = GridBagConstraints.LAST_LINE_START;
    public static final int LE = GridBagConstraints.LINE_END;
    public static final int LS = GridBagConstraints.LINE_START;
    public static final int NTS = GridBagConstraints.NORTHEAST;
    public static final int NTW = GridBagConstraints.NORTHWEST;
    public static final int PE = GridBagConstraints.PAGE_END;
    public static final int PS = GridBagConstraints.PAGE_START;
    public static final int STW = GridBagConstraints.SOUTHWEST;
    public static final int NONE = GridBagConstraints.NONE;
    public static final int BOTH = GridBagConstraints.BOTH;
    public static final int SOUT = GridBagConstraints.SOUTH;
    public static final int CENT = GridBagConstraints.CENTER;
    public static final int WEST = GridBagConstraints.WEST;
    public static final int EAST = GridBagConstraints.EAST;
    public static final int SOEA = GridBagConstraints.SOUTHEAST;
    public static final int HORI = GridBagConstraints.HORIZONTAL;
    public static final int VERT = GridBagConstraints.VERTICAL;
    public static final int RELA = GridBagConstraints.RELATIVE;
    public static final int REMA = GridBagConstraints.REMAINDER;
    public static final int NORTH = GridBagConstraints.NORTH;

    private int[][] gMain;
    private double[][] wMain;

    public GUIConstraints(int[][] gMain, double[][] wMain) {
        this.gMain = gMain;
        this.wMain = wMain;
    }

    public int[][] getgMain() {
        return gMain;
    }

    public double[][] getwMain() {
        return wMain;
    }
}

