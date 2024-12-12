package droid;

public class RSuperDroid extends Droid {
    public RSuperDroid(String name) {
        super(name, 80, 25);
    }
    @Override
    public String getType() {
        return "RSuperDroid";
    }
}
