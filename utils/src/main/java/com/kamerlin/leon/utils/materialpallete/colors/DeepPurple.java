package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class DeepPurple extends MaterialColor {
    private static DeepPurple INSTANCE;
    private DeepPurple() {}
    @Override
    public int get50() {
        return R.color.material_deeppurple50;
    }

    @Override
    public int get100() {
        return R.color.material_deeppurple100;
    }

    @Override
    public int get200() {
        return R.color.material_deeppurple200;
    }

    @Override
    public int get300() {
        return R.color.material_deeppurple300;
    }

    @Override
    public int get400() {
        return R.color.material_deeppurple400;
    }

    @Override
    public int get500() {
        return R.color.material_deeppurple500;
    }

    @Override
    public int get600() {
        return R.color.material_deeppurple600;
    }

    @Override
    public int get700() {
        return R.color.material_deeppurple700;
    }

    @Override
    public int get800() {
        return R.color.material_deeppurple800;
    }

    @Override
    public int get900() {
        return R.color.material_deeppurple900;
    }

    @Override
    public int getA100() {
        return R.color.material_deeppurpleA100;
    }

    @Override
    public int getA200() {
        return R.color.material_deeppurpleA200;
    }

    @Override
    public int getA400() {
        return R.color.material_deeppurpleA400;
    }

    @Override
    public int getA700() {
        return R.color.material_deeppurpleA700;
    }

    public static DeepPurple getInstance() {
        if (INSTANCE == null) {
            synchronized (DeepPurple.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeepPurple();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return DEEP_PURPLE;
    }
}
