package in.ashwanthkumar.restvideos.module2.color;

public interface Color {
    String getValue();

    Color RED = () -> "RED";
    Color GREEN = () -> "GREEN";
    Color BLUE = () -> "BLUE";
}
