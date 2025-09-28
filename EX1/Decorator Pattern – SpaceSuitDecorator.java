interface SpaceSuit {
    String getFeatures();
}

class BasicSuit implements SpaceSuit {
    @Override
    public String getFeatures() {
        return "Basic Oxygen Supply";
    }
}

class JetPackDecorator implements SpaceSuit {
    private SpaceSuit suit;
    public JetPackDecorator(SpaceSuit suit) { this.suit = suit; }
    @Override
    public String getFeatures() {
        return suit.getFeatures() + ", Jet Pack";
    }
}

class ShieldDecorator implements SpaceSuit {
    private SpaceSuit suit;
    public ShieldDecorator(SpaceSuit suit) { this.suit = suit; }
    @Override
    public String getFeatures() {
        return suit.getFeatures() + ", Radiation Shield";
    }
}

public class SpaceSuitDecoratorDemo {
    public static void main(String[] args) {
        SpaceSuit advancedSuit = new ShieldDecorator(new JetPackDecorator(new BasicSuit()));
        System.out.println("Astronaut Suit Features: " + advancedSuit.getFeatures());
    }
}
