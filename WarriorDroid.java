package droid;

public class WarriorDroid extends Droid {
    public WarriorDroid(String name) {
        super(name, 100, 20);
    }
    @Override
    public String getType() {
        return "WarriorDroid";
    }
}
