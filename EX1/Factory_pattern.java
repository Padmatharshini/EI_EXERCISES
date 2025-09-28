abstract class SpaceSnack {
    abstract String getSnackName();
}

class AstroCookie extends SpaceSnack {
    @Override
    String getSnackName() { return "Astro Cookie"; }
}

class MeteorBite extends SpaceSnack {
    @Override
    String getSnackName() { return "Meteor Bite"; }
}

class GalaxySnackFactory {
    public static SpaceSnack createSnack(String type) {
        switch (type.toLowerCase()) {
            case "cookie": return new AstroCookie();
            case "meteor": return new MeteorBite();
            default: throw new IllegalArgumentException("Unknown snack: " + type);
        }
    }
}

public class GalaxySnackFactoryDemo {
    public static void main(String[] args) {
        SpaceSnack snack = GalaxySnackFactory.createSnack("cookie");
        System.out.println("Snack Created: " + snack.getSnackName());
    }
}
