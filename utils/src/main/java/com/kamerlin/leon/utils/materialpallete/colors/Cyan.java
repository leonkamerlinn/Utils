package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Cyan extends MaterialColor {
    private static Cyan INSTANCE;
    private Cyan() {}
    @Override
    public int get50() {
        return R.color.material_cyan50;
    }

    @Override
    public int get100() {
        return R.color.material_cyan100;
    }

    @Override
    public int get200() {
        return R.color.material_cyan200;
    }

    @Override
    public int get300() {
        return R.color.material_cyan300;
    }

    @Override
    public int get400() {
        return R.color.material_cyan400;
    }

    @Override
    public int get500() {
        return R.color.material_cyan500;
    }

    @Override
    public int get600() {
        return R.color.material_cyan600;
    }

    @Override
    public int get700() {
        return R.color.material_cyan700;
    }

    @Override
    public int get800() {
        return R.color.material_cyan800;
    }

    @Override
    public int get900() {
        return R.color.material_cyan900;
    }

    @Override
    public int getA100() {
        return R.color.material_cyanA100;
    }

    @Override
    public int getA200() {
        return R.color.material_cyanA200;
    }

    @Override
    public int getA400() {
        return R.color.material_cyanA400;
    }

    @Override
    public int getA700() {
        return R.color.material_cyanA700;
    }

    public static Cyan getInstance() {
        if(INSTANCE == null) {
            synchronized (Cyan.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Cyan();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return CYAN;
    }
}
