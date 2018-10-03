package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Orange extends MaterialColor {
    private static Orange INSTANCE;
    private Orange() {}

    @Override
    public int get50() {
        return R.color.material_orange50;
    }

    @Override
    public int get100() {
        return R.color.material_orange100;
    }

    @Override
    public int get200() {
        return R.color.material_orange200;
    }

    @Override
    public int get300() {
        return R.color.material_orange300;
    }

    @Override
    public int get400() {
        return R.color.material_orange400;
    }

    @Override
    public int get500() {
        return R.color.material_orange500;
    }

    @Override
    public int get600() {
        return R.color.material_orange600;
    }

    @Override
    public int get700() {
        return R.color.material_orange700;
    }

    @Override
    public int get800() {
        return R.color.material_orange800;
    }

    @Override
    public int get900() {
        return R.color.material_orange900;
    }

    @Override
    public int getA100() {
        return R.color.material_orangeA100;
    }

    @Override
    public int getA200() {
        return R.color.material_orangeA200;
    }

    @Override
    public int getA400() {
        return R.color.material_orangeA400;
    }

    @Override
    public int getA700() {
        return R.color.material_orangeA700;
    }

    public static Orange getInstance() {
        if (INSTANCE == null) {
            synchronized (Orange.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Orange();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return ORANGE;
    }
}
