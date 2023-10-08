package stage2;

public enum Level {
    EASY(7, "초급자 난이도"),
    NORMAL(6, "중급자 난이도"),
    HARD(5, "전문가 난이도");

    private final int chances;
    private final String level;

    private Level(int chances, String level) {
        this.chances = chances;
        this.level = level;
    }

    public int getChances() {
        return chances;
    }

    public String getLevel() {
        return level;
    }
}
