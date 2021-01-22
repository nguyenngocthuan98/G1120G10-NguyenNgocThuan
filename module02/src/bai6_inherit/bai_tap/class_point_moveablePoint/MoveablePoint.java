package bai6_inherit.bai_tap.class_point_moveablePoint;

import bai6_inherit.bai_tap.class_point2d_3d.Point2D;

public class MoveablePoint extends Point2D {
    public float xSpeed = 0.0f;
    public float ySpeed = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] speed = new float[2];
        speed[0] = this.xSpeed;
        speed[1] = this.ySpeed;
        return speed;
    }

    @Override
    public String toString() {
        return "MoveablePoint {" + this.getX() +", " + this.getY() +"}; Speed = (" + this.getXSpeed() +", " + this.getYSpeed() +")";
    }
    public MoveablePoint move(){
        x += getXSpeed();
        y += getYSpeed();
        return this;
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D(4.1f,4.5f);
        MoveablePoint movablePoint = new MoveablePoint(4.5f,2.5f);

        movablePoint.setXY(point2D.getX(),point2D.getY());

        System.out.println(movablePoint);
        System.out.println("-----------------");
        System.out.println(movablePoint.move());
        System.out.println(movablePoint.move());
        System.out.println(movablePoint.move());
    }
}
