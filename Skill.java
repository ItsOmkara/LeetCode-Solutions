public class Skill {
    String name;
    String level;

    Skill(String name, String level) {
        this.name = name;
        this.level = level;
    }

    Skill(Skill s){
        this.name = s.name;
        this.level = s.level;
    }

    @Override
    public String toString() {
        return name + " - " + level;
    }
}
