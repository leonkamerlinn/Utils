package com.kamerlin.leon.utils.materialpallete;

public abstract class MaterialColor {
    public static final String AMBER = "amber";
    public static final String BLUE = "blue";
    public static final String BLUE_GREY = "bluegrey";
    public static final String BROWN = "brown";
    public static final String CYAN = "cyan";
    public static final String DEEP_ORANGE = "deeporange";
    public static final String DEEP_PURPLE = "deeppurple";
    public static final String GREEN = "green";
    public static final String GREY = "grey";
    public static final String INDIGO = "indigo";
    public static final String LIGHT_BLUE = "lightblue";
    public static final String LIGHT_GREEN = "lightgreen";
    public static final String LIME = "lime";
    public static final String ORANGE = "orange";
    public static final String PINK = "pink";
    public static final String PURPLE = "purple";
    public static final String RED = "red";
    public static final String TEAL = "teal";
    public static final String YELLOW = "yellow";

    public abstract int get50();
    public abstract int get100();
    public abstract int get200();
    public abstract int get300();
    public abstract int get400();
    public abstract int get500();
    public abstract int get600();
    public abstract int get700();
    public abstract int get800();
    public abstract int get900();
    public abstract int getA100();
    public abstract int getA200();
    public abstract int getA400();
    public abstract int getA700();

    public static String[] getOrderdColors() {
        return new String[] {
                RED,
                PINK,
                PURPLE,
                DEEP_PURPLE,
                INDIGO,
                BLUE,
                LIGHT_BLUE,
                CYAN,
                TEAL,
                GREEN,
                LIGHT_GREEN,
                LIME,
                YELLOW,
                AMBER,
                ORANGE,
                DEEP_ORANGE,
                BROWN,
                GREY,
                BLUE_GREY
        };
    }
}
