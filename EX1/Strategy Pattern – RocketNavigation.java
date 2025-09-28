interface NavigationStrategy {
    void navigate();
}

class OrbitStrategy implements NavigationStrategy {
    @Override
    public void navigate() {
        System.out.println("Navigating into stable orbit...");
    }
}

class LandingStrategy implements NavigationStrategy {
    @Override
    public void navigate() {
        System.out.println("Preparing for planetary landing...");
    }
}

class RocketNavigator {
    private NavigationStrategy strategy;
    public void setStrategy(NavigationStrategy strategy) {
        this.strategy = strategy;
    }
    public void execute() {
        strategy.navigate();
    }
}

public class RocketNavigationDemo {
    public static void main(String[] args) {
        RocketNavigator navigator = new RocketNavigator();
        
        navigator.setStrategy(new OrbitStrategy());
        navigator.execute();
        
        navigator.setStrategy(new LandingStrategy());
        navigator.execute();
    }
}
