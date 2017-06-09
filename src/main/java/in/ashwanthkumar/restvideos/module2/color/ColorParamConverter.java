package in.ashwanthkumar.restvideos.module2.color;

import javax.ws.rs.ext.ParamConverter;

public class ColorParamConverter implements ParamConverter<Color> {
    @Override
    public Color fromString(String s) {
        switch (s.toUpperCase()) {
            case "RED":
                return Color.RED;
            case "GREEN":
                return Color.GREEN;
            case "BLUE":
                return Color.BLUE;
            default:
                throw new RuntimeException("Unknown color - " + s);
        }
    }

    @Override
    public String toString(Color color) {
        return color.getValue().toLowerCase();
    }
}
