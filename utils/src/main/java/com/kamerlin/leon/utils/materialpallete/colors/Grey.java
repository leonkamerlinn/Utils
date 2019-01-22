package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Grey extends MaterialColor {
    private static Grey INSTANCE;
    private Grey() {}
    @Override
    public int get50() {
        return R.color.material_grey50;
    }

    @Override
    public int get100() {
        return R.color.material_grey100;
    }

    @Override
    public int get200() {
        return R.color.material_grey200;
    }

    @Override
    public int get300() {
        return R.color.material_grey300;
    }

    @Override
    public int get400() {
        return R.color.material_grey400;
    }

    @Override
    public int get500() {
        return R.color.material_grey500;
    }

    @Override
    public int get600() {
        return R.color.material_grey600;
    }

    @Override
    public int get700() {
        return R.color.material_grey700;
    }

    @Override
    public int get800() {
        return R.color.material_grey800;
    }

    @Override
    public int get900() {
        return R.color.material_grey900;
    }

    @Override
    public int getA100() {
        return R.color.material_grey100;
    }

    @Override
    public int getA200() {
        return R.color.material_grey200;
    }

    @Override
    public int getA400() {
        return R.color.material_grey400;
    }

    @Override
    public int getA700() {
        return R.color.material_grey700;
    }

    public static Grey getInstance() {
        if (INSTANCE == null) {
            synchronized (Grey.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Grey();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return GREY;
    }
}
