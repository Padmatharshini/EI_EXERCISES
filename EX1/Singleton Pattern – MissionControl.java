class MissionControl {
    private static MissionControl instance;
    private MissionControl() {}
    
    public static synchronized MissionControl getInstance() {
        if (instance == null) {
            instance = new MissionControl();
        }
        return instance;
    }
    
    public void announce(String msg) {
        System.out.println("[Mission Control] " + msg);
    }
}

public class MissionControlDemo {
    public static void main(String[] args) {
        MissionControl.getInstance().announce("Engines ready for launch!");
        MissionControl.getInstance().announce("Weather check complete.");
    }
}
