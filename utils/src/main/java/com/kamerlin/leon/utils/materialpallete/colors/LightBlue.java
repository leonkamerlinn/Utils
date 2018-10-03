package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class LightBlue extends MaterialColor {
    private static LightBlue INSTANCE;
    private LightBlue() {}
    @Override
    public int get50() {
        return R.color.material_lightblue50;
    }

    @Override
    public int get100() {
        return R.color.material_lightblue100;
    }

    @Override
    public int get200() {
        return R.color.material_lightblue200;
    }

    @Override
    public int get300() {
        return R.color.material_lightblue300;
    }

    @Override
    public int get400() {
        return R.color.material_lightblue400;
    }

    @Override
    public int get500() {
        return R.color.material_lightblue500;
    }

    @Override
    public int get600() {
        return R.color.material_lightblue600;
    }

    @Override
    public int get700() {
        return R.color.material_lightblue700;
    }

    @Override
    public int get800() {
        return R.color.material_lightblue800;
    }

    @Override
    public int get900() {
        return R.color.material_lightblue900;
    }

    @Override
    public int getA100() {
        return R.color.material_lightblueA100;
    }

    @Override
    public int getA200() {
        return R.color.material_lightblueA200;
    }

    @Override
    public int getA400() {
        return R.color.material_lightblueA400;
    }

    @Override
    public int getA700() {
        return R.color.material_lightblueA700;
    }

    public static LightBlue getInstance() {
        if (INSTANCE == null) {
            synchronized (LightBlue.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LightBlue();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return LIGHT_BLUE;
    }
}
