package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Yellow extends MaterialColor {
    private static Yellow INSTANCE;
    private Yellow() {}
    @Override
    public int get50() {
        return R.color.material_yellow50;
    }

    @Override
    public int get100() {
        return R.color.material_yellow100;
    }

    @Override
    public int get200() {
        return R.color.material_yellow200;
    }

    @Override
    public int get300() {
        return R.color.material_yellow300;
    }

    @Override
    public int get400() {
        return R.color.material_yellow400;
    }

    @Override
    public int get500() {
        return R.color.material_yellow500;
    }

    @Override
    public int get600() {
        return R.color.material_yellow600;
    }

    @Override
    public int get700() {
        return R.color.material_yellow700;
    }

    @Override
    public int get800() {
        return R.color.material_yellow800;
    }

    @Override
    public int get900() {
        return R.color.material_yellow900;
    }

    @Override
    public int getA100() {
        return R.color.material_yellowA100;
    }

    @Override
    public int getA200() {
        return R.color.material_yellowA200;
    }

    @Override
    public int getA400() {
        return R.color.material_yellowA400;
    }

    @Override
    public int getA700() {
        return R.color.material_yellowA700;
    }

    public static Yellow getInstance() {
        if (INSTANCE == null) {
            synchronized (Yellow.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Yellow();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return YELLOW;
    }
}
