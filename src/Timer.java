/**
 * Class represents a countdown timer to be used during the exam
 */
public class Timer {
    private int minutes;
    private boolean isRunning;
    private Thread timerThread;
    private TakeExamGUI display;

    public Timer(TakeExamGUI display) {
        this.minutes = 0;
        this.isRunning = false;
        this.display = display;
    }

    // Setter method to set the timer duration in minutes
    public void setMinutes(int minutes) {
        if (!isRunning) {
            this.minutes = minutes;
        }
    }

    // Start method to begin the timer
    public void start() {
        if (!isRunning) {
            isRunning = true;
            timerThread = new Thread(() -> {
                int seconds = minutes * 60;
                while (seconds > 0) {
                    try {
                        Thread.sleep(1000);
                        displayTime(--seconds);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                if (isRunning)
                    stop();
            });
            timerThread.start();
        }
    }

    private void displayTime(int seconds) {
        display.setTime(seconds);
    }

    public void stop() {
        isRunning = false;
        display.finish();
    }
}
