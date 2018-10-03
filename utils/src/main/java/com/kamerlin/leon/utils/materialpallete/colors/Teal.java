package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Teal extends MaterialColor {
    private static Teal INSTANCE;
    private Teal() {}
    @Override
    public int get50() {
        return R.color.material_teal50;
    }

    @Override
    public int get100() {
        return R.color.material_teal100;
    }

    @Override
    public int get200() {
        return R.color.material_teal200;
    }

    @Override
    public int get300() {
        return R.color.material_teal300;
    }

    @Override
    public int get400() {
        return R.color.material_teal400;
    }

    @Override
    public int get500() {
        return R.color.material_teal500;
    }

    @Override
    public int get600() {
        return R.color.material_teal600;
    }

    @Override
    public int get700() {
        return R.color.material_teal700;
    }

    @Override
    public int get800() {
        return R.color.material_teal800;
    }

    @Override
    public int get900() {
        return R.color.material_teal900;
    }

    @Override
    public int getA100() {
        return R.color.material_tealA100;
    }

    @Override
    public int getA200() {
        return R.color.material_tealA200;
    }

    @Override
    public int getA400() {
        return R.color.material_tealA400;
    }

    @Override
    public int getA700() {
        return R.color.material_tealA700;
    }

    public static Teal getInstance() {
        if (INSTANCE == null) {
            synchronized (Teal.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Teal();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return TEAL;
    }
}
