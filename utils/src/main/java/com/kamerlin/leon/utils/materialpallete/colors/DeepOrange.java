package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class DeepOrange extends MaterialColor {
    private static DeepOrange INSTANCE;
    private DeepOrange() {}
    @Override
    public int get50() {
        return R.color.material_deeporange50;
    }

    @Override
    public int get100() {
        return R.color.material_deeporange100;
    }

    @Override
    public int get200() {
        return R.color.material_deeporange200;
    }

    @Override
    public int get300() {
        return R.color.material_deeporange300;
    }

    @Override
    public int get400() {
        return R.color.material_deeporange400;
    }

    @Override
    public int get500() {
        return R.color.material_deeporange500;
    }

    @Override
    public int get600() {
        return R.color.material_deeporange600;
    }

    @Override
    public int get700() {
        return R.color.material_deeporange700;
    }

    @Override
    public int get800() {
        return R.color.material_deeporange800;
    }

    @Override
    public int get900() {
        return R.color.material_deeporange900;
    }

    @Override
    public int getA100() {
        return R.color.material_deeporangeA100;
    }

    @Override
    public int getA200() {
        return R.color.material_deeporangeA200;
    }

    @Override
    public int getA400() {
        return R.color.material_deeporangeA400;
    }

    @Override
    public int getA700() {
        return R.color.material_deeporangeA700;
    }


    public static DeepOrange getInstance() {
        if (INSTANCE == null) {
            synchronized (DeepOrange.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeepOrange();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public String toString() {
        return DEEP_ORANGE;
    }
}
