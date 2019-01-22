package com.kamerlin.leon.utils.materialpallete.colors;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

public class Amber extends MaterialColor {
    private static Amber INSTANCE;
    private Amber(){}

    @Override
    public int get50() {
        return R.color.material_amber50;
    }

    @Override
    public int get100() {
        return R.color.material_amber100;
    }

    @Override
    public int get200() {
        return R.color.material_amber200;
    }

    @Override
    public int get300() {
        return R.color.material_amber300;
    }

    @Override
    public int get400() {
        return R.color.material_amber400;
    }

    @Override
    public int get500() {
        return R.color.material_amber500;
    }

    @Override
    public int get600() {
        return R.color.material_amber600;
    }

    @Override
    public int get700() {
        return R.color.material_amber700;
    }

    @Override
    public int get800() {
        return R.color.material_amber800;
    }

    @Override
    public int get900() {
        return R.color.material_amber900;
    }

    @Override
    public int getA100() {
        return R.color.material_amberA100;
    }

    @Override
    public int getA200() {
        return R.color.material_amberA200;
    }

    @Override
    public int getA400() {
        return R.color.material_amberA400;
    }

    @Override
    public int getA700() {
        return R.color.material_amberA700;
    }

    public static Amber getInstance(){
        if(INSTANCE == null) {
            synchronized (Amber.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Amber();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return AMBER;
    }
}
