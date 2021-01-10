package bai6_inherit.bai_tap.class_point2d_3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] array = new float[3];
        array[0] = this.x;
        array[1] = this.y;
        array[2] = this.z;
        return array;
    }

    @Override
    public String toString() {
        return "Point3D {" + getX() + ", " + getY() + ", " + getZ() + "}";
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D(2.6f, 4.2f);
        Point3D point3D = new Point3D(6.0f);

        point3D.setXY(point2D.getX(), point2D.getY());

        System.out.println(point2D);
        System.out.println(point3D);
    }
}
