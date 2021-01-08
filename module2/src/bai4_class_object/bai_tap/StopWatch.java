package bai4_class_object.bai_tap;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void start() {
        setStartTime(System.currentTimeMillis());
    }

    public void stop() {
        setEndTime(System.currentTimeMillis());
    }

    public long getElapsedTime() {
        return getEndTime() - getStartTime();
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < 700000; i++) {
            for (int j = 0; j < 700000; j++) {
            }
        }
        sw.stop();
        System.out.println("Start time: 0," + sw.getStartTime());
        System.out.println("End time: 0," + sw.getEndTime());
        System.out.println("Time past: " + sw.getElapsedTime()+ " millis second");
    }
}
