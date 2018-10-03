package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Purple extends MaterialColor {
    private static Purple INSTANCE;
    private Purple() {}

    @Override
    public int get50() {
        return R.color.material_purple50;
    }

    @Override
    public int get100() {
        return R.color.material_purple100;
    }

    @Override
    public int get200() {
        return R.color.material_purple200;
    }

    @Override
    public int get300() {
        return R.color.material_purple300;
    }

    @Override
    public int get400() {
        return R.color.material_purple400;
    }

    @Override
    public int get500() {
        return R.color.material_purple500;
    }

    @Override
    public int get600() {
        return R.color.material_purple600;
    }

    @Override
    public int get700() {
        return R.color.material_purple700;
    }

    @Override
    public int get800() {
        return R.color.material_purple800;
    }

    @Override
    public int get900() {
        return R.color.material_purple900;
    }

    @Override
    public int getA100() {
        return R.color.material_purpleA100;
    }

    @Override
    public int getA200() {
        return R.color.material_purpleA200;
    }

    @Override
    public int getA400() {
        return R.color.material_purpleA400;
    }

    @Override
    public int getA700() {
        return R.color.material_purpleA700;
    }

    public static Purple getInstance() {
        if (INSTANCE == null) {
            synchronized (Purple.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Purple();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return PURPLE;
    }
}
