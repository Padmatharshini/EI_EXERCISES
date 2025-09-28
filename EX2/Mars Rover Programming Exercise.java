import java.util.*;

// ===============================
// Direction ENUM with creative spins
// ===============================
enum CosmicHeading {
    NORTH, EAST, SOUTH, WEST;

    public CosmicHeading pirouetteLeft() {
        return values()[(this.ordinal() + 3) % 4];
    }

    public CosmicHeading pirouetteRight() {
        return values()[(this.ordinal() + 1) % 4];
    }
}

// ===============================
// Rover Entity - "CrimsonCrawler"
// ===============================
class CrimsonCrawler {
    private int x, y;
    private CosmicHeading heading;
    private MartianPlayground playground;

    public CrimsonCrawler(int x, int y, CosmicHeading heading, MartianPlayground playground) {
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.playground = playground;
    }

    // Move forward
    public void dashForward() {
        int newX = x, newY = y;
        switch (heading) {
            case NORTH -> newY++;
            case SOUTH -> newY--;
            case EAST  -> newX++;
            case WEST  -> newX--;
        }

        if (!playground.isInside(newX, newY)) {
            System.out.println("🚧 Boundary Breach! CrimsonCrawler refuses to leave safe zone.");
            return;
        }
        if (playground.hasCosmicBoulder(newX, newY)) {
            System.out.println("💥 Collision Alert! Cosmic Boulder at (" + newX + "," + newY + ")");
            return;
        }

        x = newX;
        y = newY;
        System.out.println("🛰️ Glide successful: Now at (" + x + "," + y + ")");
    }

    // Rotate Left
    public void pirouetteLeft() {
        heading = heading.pirouetteLeft();
        System.out.println("↩️ Pirouette Left → Now facing " + heading);
    }

    // Rotate Right
    public void pirouetteRight() {
        heading = heading.pirouetteRight();
        System.out.println("↪️ Pirouette Right → Now facing " + heading);
    }

    // Status report
    public void transmitTelemetry() {
        System.out.println("📡 TELEMETRY: CrimsonCrawler at (" + x + "," + y + ") facing " + heading);
    }
}

// ===============================
// Martian Playground (Grid + Obstacles)
// ===============================
class MartianPlayground {
    private int width, height;
    private Set<String> cosmicBoulders = new HashSet<>();

    public MartianPlayground(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void dropCosmicBoulder(int x, int y) {
        cosmicBoulders.add(x + "," + y);
    }

    public boolean hasCosmicBoulder(int x, int y) {
        return cosmicBoulders.contains(x + "," + y);
    }

    public boolean isInside(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }
}

// ===============================
// Command Pattern with Innovation
// ===============================
interface CosmicCommand {
    void ignite();
}

class DashForwardCommand implements CosmicCommand {
    private CrimsonCrawler rover;
    public DashForwardCommand(CrimsonCrawler rover) { this.rover = rover; }
    @Override public void ignite() { rover.dashForward(); }
}

class PirouetteLeftCommand implements CosmicCommand {
    private CrimsonCrawler rover;
    public PirouetteLeftCommand(CrimsonCrawler rover) { this.rover = rover; }
    @Override public void ignite() { rover.pirouetteLeft(); }
}

class PirouetteRightCommand implements CosmicCommand {
    private CrimsonCrawler rover;
    public PirouetteRightCommand(CrimsonCrawler rover) { this.rover = rover; }
    @Override public void ignite() { rover.pirouetteRight(); }
}

// ===============================
// MAIN Demo – "executeCosmicChoreography"
// ===============================
public class CosmicMarsDance {
    public static void main(String[] args) {
        // Create Martian playground
        MartianPlayground playground = new MartianPlayground(10, 10);
        playground.dropCosmicBoulder(2, 2);
        playground.dropCosmicBoulder(3, 5);

        // Place the Rover
        CrimsonCrawler rover = new CrimsonCrawler(0, 0, CosmicHeading.NORTH, playground);

        // Define a mission choreography
        List<CosmicCommand> missionPlan = Arrays.asList(
            new DashForwardCommand(rover),
            new DashForwardCommand(rover),
            new PirouetteRightCommand(rover),
            new DashForwardCommand(rover),
            new PirouetteLeftCommand(rover),
            new DashForwardCommand(rover)
        );

        // Execute mission like a dance routine
        System.out.println("🎼 Executing Cosmic Choreography...");
        for (CosmicCommand step : missionPlan) {
            step.ignite();
        }

        // Final status report
        rover.transmitTelemetry();
    }
}
