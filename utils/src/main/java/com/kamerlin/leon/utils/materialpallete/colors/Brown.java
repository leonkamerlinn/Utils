package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Brown extends MaterialColor {
    private static Brown INSTANCE;
    private Brown() {

    }

    @Override
    public int get50() {
        return R.color.material_brown50;
    }

    @Override
    public int get100() {
        return R.color.material_brown100;
    }

    @Override
    public int get200() {
        return R.color.material_brown200;
    }

    @Override
    public int get300() {
        return R.color.material_brown300;
    }

    @Override
    public int get400() {
        return R.color.material_brown400;
    }

    @Override
    public int get500() {
        return R.color.material_brown500;
    }

    @Override
    public int get600() {
        return R.color.material_brown600;
    }

    @Override
    public int get700() {
        return R.color.material_brown700;
    }

    @Override
    public int get800() {
        return R.color.material_brown800;
    }

    @Override
    public int get900() {
        return R.color.material_brown900;
    }

    @Override
    public int getA100() {
        return R.color.material_brown100;
    }

    @Override
    public int getA200() {
        return R.color.material_brown200;
    }

    @Override
    public int getA400() {
        return R.color.material_brown400;
    }

    @Override
    public int getA700() {
        return R.color.material_brown700;
    }

    public static Brown getInstance() {
        if (INSTANCE == null) {
            synchronized (Brown.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Brown();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return BROWN;
    }
}
