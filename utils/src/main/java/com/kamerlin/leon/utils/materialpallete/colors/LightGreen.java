package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class LightGreen extends MaterialColor {
    private static LightGreen INSTANCE;
    private LightGreen() {}
    @Override
    public int get50() {
        return R.color.material_lightgreen50;
    }

    @Override
    public int get100() {
        return R.color.material_lightgreen100;
    }

    @Override
    public int get200() {
        return R.color.material_lightgreen200;
    }

    @Override
    public int get300() {
        return R.color.material_lightgreen300;
    }

    @Override
    public int get400() {
        return R.color.material_lightgreen400;
    }

    @Override
    public int get500() {
        return R.color.material_lightgreen500;
    }

    @Override
    public int get600() {
        return R.color.material_lightgreen600;
    }

    @Override
    public int get700() {
        return R.color.material_lightgreen700;
    }

    @Override
    public int get800() {
        return R.color.material_lightgreen800;
    }

    @Override
    public int get900() {
        return R.color.material_lightgreen900;
    }

    @Override
    public int getA100() {
        return R.color.material_lightgreenA100;
    }

    @Override
    public int getA200() {
        return R.color.material_lightgreenA200;
    }

    @Override
    public int getA400() {
        return R.color.material_lightgreenA400;
    }

    @Override
    public int getA700() {
        return R.color.material_lightgreenA700;
    }

    public static LightGreen getInstance() {
        if (INSTANCE == null) {
            synchronized (LightGreen.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LightGreen();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return LIGHT_GREEN;
    }
}
