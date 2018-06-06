
import java.util.Random;

public class Ships extends Game {

    private int battleship;
    private int destroyer;
    private int submarine;
    private int boat;
    public int BoatDefine = 2;
    public int SubmarineDefine = 3;
    public int DestroyerDefine = 4;
    public int BattleshipDefine = 5;

    public int getBattleshipSize() {
        return 4;
    }

    public int getBattleshipCount() {
        return battleship;
    }

    public void setBattleship(int battleship) {
        this.battleship = battleship;
    }

    public int getDestroyerSize() {
        return 3;
    }

    public int getDestroyerCount() {
        return destroyer;
    }

    public void setDestroyer(int destroyer) {
        this.destroyer = destroyer;
    }

    public int getSubmarineSize() {
        return 2;
    }

    public int getSubmarineCount() {
        return submarine;
    }

    public void setSubmarine(int submarine) {
        this.submarine = submarine;
    }

    public int getBoatSize() {
        return 1;
    }

    public int getBoatCount() {
        return boat;
    }

    public void setBoat(int boat) {
        this.boat = boat;
    }

    public void setEasy() {
        this.setBoat(1);
        this.setSubmarine(1);
        this.setDestroyer(1);
        this.setBattleship(0);
    }

    public void setNormal() {
        this.setBoat(2);
        this.setSubmarine(1);
        this.setDestroyer(1);
        this.setBattleship(1);
    }

    public void setHard() {
        this.setBoat(2);
        this.setSubmarine(1);
        this.setDestroyer(1);
        this.setBattleship(1);
    }

    public void setRandom() {
        for (int i = 0; i < this.getBoatCount(); i++) {
            setShip(this.getBoatSize(), this.BoatDefine);
        }
        for (int i = 0; i < this.getSubmarineCount(); i++) {
            setShip(this.getSubmarineSize(), this.SubmarineDefine);
        }
        for (int i = 0; i < this.getDestroyerCount(); i++) {
            setShip(this.getDestroyerSize(), this.DestroyerDefine);
        }
        for (int i = 0; i < this.getBattleshipCount(); i++) {
            setShip(this.getBattleshipSize(), this.BattleshipDefine);
        }
    }

    public String getType(int type) {
        if (type == this.BoatDefine) {
            return "Boat";
        } else if (type == this.SubmarineDefine) {
            return "Submarine";
        } else if (type == this.DestroyerDefine) {
            return "Destroyer";
        } else if (type == this.BattleshipDefine) {
            return "Battleship";
        }
        return "";
    }

    public void setShip(int size, int type) {
        if (size <= 0 || size >= 5) {
            return;
        }

        Random r = new Random();
        int x = r.nextInt(worldgrid.getWorld().length - size);
        int y = r.nextInt(worldgrid.getWorld()[0].length - size);

        for (int i = 0; i < size; i++) {
            if (worldgrid.getPointWorld(x, y + i) >= 2) {
                setShip(size, type);
                return;
            }
        }

        for (int i = 0; i < size; i++) {
            worldgrid.setPointWorld(x, y + i, type);
        }
    }

}
