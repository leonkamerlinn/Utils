package com.kamerlin.leon.utils.materialpallete.colors;
import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Blue extends MaterialColor {
    private static Blue INSTANCE;
    private Blue() {}
    @Override
    public int get50() {
        return R.color.material_blue50;
    }

    @Override
    public int get100() {
        return R.color.material_blue100;
    }

    @Override
    public int get200() {
        return R.color.material_blue200;
    }

    @Override
    public int get300() {
        return R.color.material_blue300;
    }

    @Override
    public int get400() {
        return R.color.material_blue400;
    }

    @Override
    public int get500() {
        return R.color.material_blue500;
    }

    @Override
    public int get600() {
        return R.color.material_blue600;
    }

    @Override
    public int get700() {
        return R.color.material_blue700;
    }

    @Override
    public int get800() {
        return R.color.material_blue800;
    }

    @Override
    public int get900() {
        return R.color.material_blue900;
    }

    @Override
    public int getA100() {
        return R.color.material_blueA100;
    }

    @Override
    public int getA200() {
        return R.color.material_blueA200;
    }

    @Override
    public int getA400() {
        return R.color.material_blueA400;
    }

    @Override
    public int getA700() {
        return R.color.material_blueA700;
    }

    public static Blue getInstance() {
        if (INSTANCE == null) {
            synchronized (Blue.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Blue();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return BLUE;
    }
}
