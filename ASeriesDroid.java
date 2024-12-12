package droid;

public class ASeriesDroid extends Droid {
    public ASeriesDroid(String name) {
        super(name, 120, 15);
    }
    @Override
    public String getType() {
        return "ASeriesDroid";
    }
}
