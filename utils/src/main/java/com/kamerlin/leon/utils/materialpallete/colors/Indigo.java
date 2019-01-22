package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Indigo extends MaterialColor {
    private static Indigo INSTANCE;
    private Indigo() {}
    @Override
    public int get50() {
        return R.color.material_indigo50;
    }

    @Override
    public int get100() {
        return R.color.material_indigo100;
    }

    @Override
    public int get200() {
        return R.color.material_indigo200;
    }

    @Override
    public int get300() {
        return R.color.material_indigo300;
    }

    @Override
    public int get400() {
        return R.color.material_indigo400;
    }

    @Override
    public int get500() {
        return R.color.material_indigo500;
    }

    @Override
    public int get600() {
        return R.color.material_indigo600;
    }

    @Override
    public int get700() {
        return R.color.material_indigo700;
    }

    @Override
    public int get800() {
        return R.color.material_indigo800;
    }

    @Override
    public int get900() {
        return R.color.material_indigo900;
    }

    @Override
    public int getA100() {
        return R.color.material_indigoA100;
    }

    @Override
    public int getA200() {
        return R.color.material_indigoA200;
    }

    @Override
    public int getA400() {
        return R.color.material_indigoA400;
    }

    @Override
    public int getA700() {
        return R.color.material_indigoA700;
    }

    public static Indigo getInstance() {
        if (INSTANCE == null) {
            synchronized (Indigo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Indigo();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return INDIGO;
    }
}
