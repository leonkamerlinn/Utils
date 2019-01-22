package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Red extends MaterialColor {
    private static Red INSTANCE;
    private Red() {}

    @Override
    public int get50() {
        return R.color.material_red50;
    }

    @Override
    public int get100() {
        return R.color.material_red100;
    }

    @Override
    public int get200() {
        return R.color.material_red200;
    }

    @Override
    public int get300() {
        return R.color.material_red300;
    }

    @Override
    public int get400() {
        return R.color.material_red400;
    }

    @Override
    public int get500() {
        return R.color.material_red500;
    }

    @Override
    public int get600() {
        return R.color.material_red600;
    }

    @Override
    public int get700() {
        return R.color.material_red700;
    }

    @Override
    public int get800() {
        return R.color.material_red800;
    }

    @Override
    public int get900() {
        return R.color.material_red900;
    }

    @Override
    public int getA100() {
        return R.color.material_redA100;
    }

    @Override
    public int getA200() {
        return R.color.material_redA200;
    }

    @Override
    public int getA400() {
        return R.color.material_redA400;
    }

    @Override
    public int getA700() {
        return R.color.material_redA700;
    }

    public static Red getInstance(){
        if(INSTANCE == null){
            synchronized (Red.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Red();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return RED;
    }
}
