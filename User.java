
public class User extends Game {

    private String username;
    private int totalPlayed;
    private int playLevel;

    public void setPlayed(int count) {
        totalPlayed = count;
    }

    public void clearPlayed() {
        totalPlayed = 0;
    }

    public int getPlayed() {
        return totalPlayed;
    }

    public void setLevel(int level) {
        playLevel = level;
        differ.setType(level);
    }

    public int getLevel() {
        return playLevel;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isUsernameChecker(String name) {
        if (fp.getUserDataFromFile(FileName, name) == fp.FileSearchFindOK) {
            return true;
        }
        return false;
    }

    public void setUserPlayed(String name, int type) {
        if (type == CounterClear) {
            this.clearPlayed();
        } else {
            this.setPlayed(type);
            fp.setUserDataFromFile(FileName, name, differ.getTypeString(), this.getPlayed());
        }

    }

    public int getUserPlayed(String name) {
        fp.getUserDataFromFile(FileName, name);
        return this.getPlayed();
    }

    public void updateUser(String name, String level, int Score) {
        fp.updateScore(FileName, name, level, Score);
    }

}
