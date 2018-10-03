package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Lime extends MaterialColor {
    private static Lime INSTANCE;
    private Lime() {}
    @Override
    public int get50() {
        return R.color.material_lime50;
    }

    @Override
    public int get100() {
        return R.color.material_lime100;
    }

    @Override
    public int get200() {
        return R.color.material_lime200;
    }

    @Override
    public int get300() {
        return R.color.material_lime300;
    }

    @Override
    public int get400() {
        return R.color.material_lime400;
    }

    @Override
    public int get500() {
        return R.color.material_lime500;
    }

    @Override
    public int get600() {
        return R.color.material_lime600;
    }

    @Override
    public int get700() {
        return R.color.material_lime700;
    }

    @Override
    public int get800() {
        return R.color.material_lime800;
    }

    @Override
    public int get900() {
        return R.color.material_lime900;
    }

    @Override
    public int getA100() {
        return R.color.material_limeA100;
    }

    @Override
    public int getA200() {
        return R.color.material_limeA200;
    }

    @Override
    public int getA400() {
        return R.color.material_limeA400;
    }

    @Override
    public int getA700() {
        return R.color.material_limeA700;
    }

    public static Lime getInstance() {
        if (INSTANCE == null) {
            synchronized (Lime.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Lime();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return LIME;
    }
}
