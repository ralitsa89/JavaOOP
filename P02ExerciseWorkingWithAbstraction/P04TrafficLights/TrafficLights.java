package P02ExerciseWorkingWithAbstraction.P04TrafficLights;

public class TrafficLights {
    public enum Signal {
        RED,
        GREEN,
        YELLOW;

    }

    private Signal signal;

    public TrafficLights(Signal signal) {
        this.signal = signal;
    }

    public void update() {
        switch (this.signal) {
            case RED:
                this.signal = Signal.GREEN;
                break;
            case GREEN:
                this.signal = Signal.YELLOW;
                break;
            case YELLOW:
                this.signal = Signal.RED;
                break;
            default:
                throw new IllegalStateException("Unknown state " + this.signal);
        }
    }

    public Signal getSignal() {
        return signal;
    }
}
