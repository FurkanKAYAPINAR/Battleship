
public class Difficulty {

    private int type;

    public int Easy = 0;
    public int Normal = 1;
    public int Hard = 2;

    public int getType() { //return grid size
        if (type == Easy) //easy
        {
            return 10;
        } else if (type == Normal) //normal
        {
            return 15;
        } else //hard
        {
            return 20;
        }
    }

    public int setType(int type) {
        if (type > Hard || type < Easy) {
            return 0;
        } else {
            this.type = type;
        }

        return 1;
    }

    public String getTypeString() {
        if (type == Easy) //easy
        {
            return "Easy";
        } else if (type == Normal) //normal
        {
            return "Normal";
        } else //hard
        {
            return "Hard";
        }
    }

}
