package engine;

public class TickedEngine implements Runnable {

  private static final int TICK_RATE = 60;
  private Thread thread;

  public void start() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  public void interrupt() {
    if (thread != null && thread.isAlive()) {
      thread.interrupt();
    }
  }

  @Override
  public void run() {
    if (thread == null || thread.isAlive()) return; /* redundant */

    long prior = System.nanoTime();
    long time_in_ticks = 1000 / TICK_RATE; /* ms per tick */

    long now, elapsed;
    while (thread.isAlive()) {
      now = System.nanoTime();
      elapsed = now - prior;
      if (elapsed > time_in_ticks) {
        /* call update handlers */

      } else {
        try {
          /* try to save runtime */
          Thread.sleep(time_in_ticks / 10);
        } catch (InterruptedException e) {
          return;
        }
      }
    }
  }
}
