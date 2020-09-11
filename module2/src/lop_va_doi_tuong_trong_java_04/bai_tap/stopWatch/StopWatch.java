package lop_va_doi_tuong_trong_java_04.bai_tap.stopWatch;

public class StopWatch {
    private boolean startTime;
    private boolean endTime;

    public StopWatch() {
        System.currentTimeMillis();
    }

    public StopWatch(boolean startTime, boolean endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isStartTime() {
        return startTime;
    }

    public void setStartTime(boolean startTime) {
        this.startTime = startTime;
    }

    public boolean isEndTime() {
        return endTime;
    }

    public void setEndTime(boolean endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "StopWatch{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
        
}
