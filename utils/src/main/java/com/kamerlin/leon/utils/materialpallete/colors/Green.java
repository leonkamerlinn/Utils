package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Green extends MaterialColor {
    private static Green INSTANCE;
    private Green() {}
    @Override
    public int get50() {
        return R.color.material_green50;
    }

    @Override
    public int get100() {
        return R.color.material_green100;
    }

    @Override
    public int get200() {
        return R.color.material_green200;
    }

    @Override
    public int get300() {
        return R.color.material_green300;
    }

    @Override
    public int get400() {
        return R.color.material_green400;
    }

    @Override
    public int get500() {
        return R.color.material_green500;
    }

    @Override
    public int get600() {
        return R.color.material_green600;
    }

    @Override
    public int get700() {
        return R.color.material_green700;
    }

    @Override
    public int get800() {
        return R.color.material_green800;
    }

    @Override
    public int get900() {
        return R.color.material_green900;
    }

    @Override
    public int getA100() {
        return R.color.material_greenA100;
    }

    @Override
    public int getA200() {
        return R.color.material_greenA200;
    }

    @Override
    public int getA400() {
        return R.color.material_greenA400;
    }

    @Override
    public int getA700() {
        return R.color.material_greenA700;
    }

    public static Green getInstance() {
        if (INSTANCE == null) {
            synchronized (Green.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Green();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return GREEN;
    }
}
