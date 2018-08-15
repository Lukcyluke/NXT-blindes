package nxtblindes;

import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;
import java.lang.Runnable;

public class window implements Runnable{

  private TouchSensor ts;

  public boolean stopWatching = false;

  public window(lejos.nxt.SensorPort s) {
    //init the window
    ts = new TouchSensor(s);
  }

  /**
    Return: True if the window is open. False if the Window is closed.
   */
  public boolean isOpen() {
    return ts.isPressed();
  }

  public void run() {
    System.out.println("Starting to watch the window state");
    boolean lastState = isOpen();
    while(! stopWatching) {
      if(isOpen() != lastState){
        lastState = isOpen();
        System.out.println("Window state changed: " + (isOpen() ? "open" : "closed"));
        // TODO: call some listener ...
      }
    }
  }
}