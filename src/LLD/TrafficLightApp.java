package LLD;

import java.util.ArrayList;
import java.util.List;

// Enum for light states
enum LightState {
    RED, GREEN, YELLOW
}

// Traffic light with current state
class TrafficLight {
    private LightState state;

    public TrafficLight() {
        this.state = LightState.RED;
    }

    public synchronized void setState(LightState state) {
        this.state = state;
        System.out.println("Light changed to: " + state);
    }

    public synchronized LightState getState() {
        return state;
    }
}

// Controller for managing light transitions
class TrafficSignalController implements Runnable {
    private final TrafficLight light;
    private final int greenDuration;
    private final int yellowDuration;
    private final int redDuration;
    private volatile boolean running = true;

    public TrafficSignalController(TrafficLight light, int green, int yellow, int red) {
        this.light = light;
        this.greenDuration = green;
        this.yellowDuration = yellow;
        this.redDuration = red;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                light.setState(LightState.GREEN);
                Thread.sleep(greenDuration * 1000);

                light.setState(LightState.YELLOW);
                Thread.sleep(yellowDuration * 1000);

                light.setState(LightState.RED);
                Thread.sleep(redDuration * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Controller interrupted.");
            }
        }
    }
}

// Represents a single intersection with one controller (can be extended to 4 ways)
class Intersection {
    private final TrafficLight light;
    private final Thread controllerThread;

    public Intersection(int green, int yellow, int red) {
        this.light = new TrafficLight();
        TrafficSignalController controller = new TrafficSignalController(light, green, yellow, red);
        this.controllerThread = new Thread(controller);
    }

    public void start() {
        controllerThread.start();
    }

    public void stop() {
        controllerThread.interrupt();
    }
}

// Top-level system managing multiple intersections
class TrafficSystem {
    private final List<Intersection> intersections = new ArrayList<>();

    public void addIntersection(Intersection i) {
        intersections.add(i);
    }

    public void startSystem() {
        intersections.forEach(Intersection::start);
    }

    public void stopSystem() {
        intersections.forEach(Intersection::stop);
    }
}

// Main class to start system
public class TrafficLightApp {
    public static void main(String[] args) {
        TrafficSystem system = new TrafficSystem();

        // Add one intersection with G=5s, Y=2s, R=5s
        system.addIntersection(new Intersection(5, 2, 5));

        system.startSystem();

        // Stop after 30 seconds for demo
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        system.stopSystem();
    }
}
