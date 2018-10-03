package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Pink extends MaterialColor {
    private static Pink INSTANCE;
    private Pink() {}
    @Override
    public int get50() {
        return R.color.material_pink50;
    }

    @Override
    public int get100() {
        return R.color.material_pink100;
    }

    @Override
    public int get200() {
        return R.color.material_pink200;
    }

    @Override
    public int get300() {
        return R.color.material_pink300;
    }

    @Override
    public int get400() {
        return R.color.material_pink400;
    }

    @Override
    public int get500() {
        return R.color.material_pink500;
    }

    @Override
    public int get600() {
        return R.color.material_pink600;
    }

    @Override
    public int get700() {
        return R.color.material_pink700;
    }

    @Override
    public int get800() {
        return R.color.material_pink800;
    }

    @Override
    public int get900() {
        return R.color.material_pink900;
    }

    @Override
    public int getA100() {
        return R.color.material_pinkA100;
    }

    @Override
    public int getA200() {
        return R.color.material_pinkA200;
    }

    @Override
    public int getA400() {
        return R.color.material_pinkA400;
    }

    @Override
    public int getA700() {
        return R.color.material_pinkA700;
    }

    public static Pink getInstance() {
        if (INSTANCE == null) {
            synchronized (Pink.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Pink();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return PINK;
    }
}
