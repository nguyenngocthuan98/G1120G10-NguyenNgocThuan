package bai4_class_object.bai_tap;

public class Fan {
    final byte SLOW = 1, MEDIUM = 2, FAST = 3;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public String fan_switch(boolean status) {
        if (status) {
            return "on";
        } else {
            return "off";
        }
    }

    public String fan_status(int speed) {
        switch (speed) {
            case 1:
                return "SLOW";
            case 2:
                return "MEDIUM";
            case 3:
                return "FAST";
            default:
                return "Nothing to show";
        }
    }

    @Override
    public String toString() {
        if (on) {
            return "fan is: " + fan_switch(isOn()) +
                    ", speed: " + fan_status(getSpeed()) +
                    ", radius: " + getRadius() +
                    ", color: " + getRadius() +
                    '}';
        } else {
            return "fan is: " + fan_switch(isOn()) +
                    ", radius: " + getRadius() +
                    ", color: " + getColor() +
                    '}';
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(3, true, 5, "black");
        Fan fan2 = new Fan(0, false, 3, "rose gold");
        Fan fan_default = new Fan(); // get default fan

        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());
        System.out.println("Fan default: " + fan_default.toString());
    }
}
