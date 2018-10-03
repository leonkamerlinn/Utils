package com.kamerlin.leon.utils.materialpallete;

import com.kamerlin.leon.utils.materialpallete.colors.Amber;
import com.kamerlin.leon.utils.materialpallete.colors.Blue;
import com.kamerlin.leon.utils.materialpallete.colors.BlueGrey;
import com.kamerlin.leon.utils.materialpallete.colors.Brown;
import com.kamerlin.leon.utils.materialpallete.colors.Cyan;
import com.kamerlin.leon.utils.materialpallete.colors.DeepOrange;
import com.kamerlin.leon.utils.materialpallete.colors.DeepPurple;
import com.kamerlin.leon.utils.materialpallete.colors.Green;
import com.kamerlin.leon.utils.materialpallete.colors.Grey;
import com.kamerlin.leon.utils.materialpallete.colors.Indigo;
import com.kamerlin.leon.utils.materialpallete.colors.LightBlue;
import com.kamerlin.leon.utils.materialpallete.colors.LightGreen;
import com.kamerlin.leon.utils.materialpallete.colors.Lime;
import com.kamerlin.leon.utils.materialpallete.colors.Orange;
import com.kamerlin.leon.utils.materialpallete.colors.Pink;
import com.kamerlin.leon.utils.materialpallete.colors.Purple;
import com.kamerlin.leon.utils.materialpallete.colors.Red;
import com.kamerlin.leon.utils.materialpallete.colors.Teal;
import com.kamerlin.leon.utils.materialpallete.colors.Yellow;

public class MaterialColorFactory {
    public static MaterialColor getColor(String color) {
        switch (color) {
            case MaterialColor.AMBER:
                return Amber.getInstance();
            case MaterialColor.BLUE:
                return Blue.getInstance();
            case MaterialColor.BLUE_GREY:
                return BlueGrey.getInstance();
            case MaterialColor.BROWN:
                return Brown.getInstance();
            case MaterialColor.CYAN:
                return Cyan.getInstance();
            case MaterialColor.DEEP_ORANGE:
                return DeepOrange.getInstance();
            case MaterialColor.DEEP_PURPLE:
                return DeepPurple.getInstance();
            case MaterialColor.GREEN:
                return Green.getInstance();
            case MaterialColor.GREY:
                return Grey.getInstance();
            case MaterialColor.INDIGO:
                return Indigo.getInstance();
            case MaterialColor.LIGHT_BLUE:
                return LightBlue.getInstance();
            case MaterialColor.LIGHT_GREEN:
                return LightGreen.getInstance();
            case MaterialColor.LIME:
                return Lime.getInstance();
            case MaterialColor.ORANGE:
                return Orange.getInstance();
            case MaterialColor.PINK:
                return Pink.getInstance();
            case MaterialColor.PURPLE:
                return Purple.getInstance();
            case MaterialColor.RED:
                return Red.getInstance();
            case MaterialColor.TEAL:
                return Teal.getInstance();
            case MaterialColor.YELLOW:
                return Yellow.getInstance();
        }
        return null;
    }

}
