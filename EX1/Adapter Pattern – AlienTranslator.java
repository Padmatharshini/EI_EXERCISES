interface EarthLanguage {
    void communicate(String msg);
}

class EnglishSpeaker implements EarthLanguage {
    @Override
    public void communicate(String msg) {
        System.out.println("English: " + msg);
    }
}

class AlienLanguage {
    void blipBlop(String alienMsg) {
        System.out.println("Alien says: " + alienMsg);
    }
}

class AlienTranslator implements EarthLanguage {
    private AlienLanguage alien;
    public AlienTranslator(AlienLanguage alien) {
        this.alien = alien;
    }
    @Override
    public void communicate(String msg) {
        alien.blipBlop("<<Translated>> " + msg);
    }
}

public class AlienTranslatorDemo {
    public static void main(String[] args) {
        EarthLanguage translator = new AlienTranslator(new AlienLanguage());
        translator.communicate("Welcome to the Milky Way!");
    }
}
