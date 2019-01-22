package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class BlueGrey extends MaterialColor {
    private static BlueGrey INSTANCE;
    private BlueGrey(){}

    @Override
    public int get50() {
        return R.color.material_bluegrey50;
    }

    @Override
    public int get100() {
        return R.color.material_bluegrey100;
    }

    @Override
    public int get200() {
        return R.color.material_bluegrey200;
    }

    @Override
    public int get300() {
        return R.color.material_bluegrey300;
    }

    @Override
    public int get400() {
        return R.color.material_bluegrey400;
    }

    @Override
    public int get500() {
        return R.color.material_bluegrey500;
    }

    @Override
    public int get600() {
        return R.color.material_bluegrey600;
    }

    @Override
    public int get700() { return R.color.material_bluegrey700; }

    @Override
    public int get800() {
        return R.color.material_bluegrey800;
    }

    @Override
    public int get900() {
        return R.color.material_bluegrey900;
    }

    @Override
    public int getA100() {
        return R.color.material_bluegrey100;
    }

    @Override
    public int getA200() {
        return R.color.material_bluegrey200;
    }

    @Override
    public int getA400() {
        return R.color.material_bluegrey400;
    }

    @Override
    public int getA700() {
        return R.color.material_bluegrey700;
    }

    public static BlueGrey getInstance() {
        if (INSTANCE == null) {
            synchronized (BlueGrey.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BlueGrey();
                }
            }
        }

        return INSTANCE;

    }

    @Override
    public String toString() {
        return BLUE_GREY;
    }
}
