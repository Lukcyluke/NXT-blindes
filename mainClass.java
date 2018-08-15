package nxtblindes;

import nxtblindes.blinde;
import nxtblindes.window;
import nxtblindes.BluetoothCom;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import java.lang.Thread;

public class mainClass {
    private static blinde blinde1;
    private static blinde blinde2;
    private static blinde blinde3;

    private static window w;
    private static Thread wThread;

    private static BluetoothCom com;

    /** The angle to move the blindes 100% down */
    private static final int maxAngle = 3600;

    public static void init() {
        // TODO
        // init the three blindes
        System.out.println("Assuming all blindes are up now.");        
        blinde1 = new blinde(lejos.nxt.Motor.A, maxAngle);
        // blinde2 = new blinde(lejos.nxt.Motor.B, maxAngle);
        // blinde3 = new blinde(lejos.nxt.Motor.C, maxAngle);
        
        // connect the blindes to the buttons LEFT and RIGHT
        lejos.nxt.Button.LEFT.addButtonListener(blinde1);
        // lejos.nxt.Button.LEFT.addButtonListener(blinde2);
        // lejos.nxt.Button.LEFT.addButtonListener(blinde3);
        lejos.nxt.Button.RIGHT.addButtonListener(blinde1);
        // lejos.nxt.Button.RIGHT.addButtonListener(blinde2);
        // lejos.nxt.Button.RIGHT.addButtonListener(blinde3);
        lejos.nxt.Button.ENTER.addButtonListener(blinde1);
        // lejos.nxt.Button.ENTER.addButtonListener(blinde2);
        // lejos.nxt.Button.ENTER.addButtonListener(blinde3);

        // init the window
        w = new window(SensorPort.S1);
        // start checking the window state;
        wThread = new Thread(w);
        wThread.start();

        // enable bluetooth communication
        com = new BluetoothCom();
    }

    public static void main(String[] args) {
        // TODO
        System.out.println("Initializing ...");
        init();
        System.out.println("Initialized!");
        Button.ESCAPE.waitForPress();
        w.stopWatching = true;
    }
    
    public static void printStatus() {
        System.out.println("Window is " + (w.isOpen() ? "open" : "closed"));
        System.out.println("Blinde 1: " + blinde1.getPosition() + "%");
        System.out.println("Blinde 2: " + blinde2.getPosition() + "%");
        System.out.println("Blinde 3: " + blinde3.getPosition() + "%");
        System.out.println("");
    }
}
