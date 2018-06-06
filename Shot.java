
public class Shot extends Game {

    public int HandBomb(int x, int y, int i) {
        int type = -1;
        if (worldgrid.getPointWorld(y, x + i) >= 2) // -1 free
        {
            type = worldgrid.getPointWorld(y, x + i); 	// get type ships
        }
        if (type == -1) {
            worldgrid.setPointWorld(y, x + i, -1);	// missed shot
        } else {
            worldgrid.setPointWorld(y, x + i, 1);		// shot
        }
        return type;
    }

    public void HeadShot(int weapon, int square, int x, int y) {
        /* type 0 = free,1 = shot,2 >= ships active */
        int type = -1;
        for (int i = 0; i < square; i++) {
            type = -1;

            if (x + i >= 10 && y + i >= 10) {
                continue;
            }

            if (weapon == 1) { //rocket
                if (x == 0 && i - 1 < 0) {
                    continue;
                }
                if (type == -1) {
                    type = HandBomb(x, y, i - 1);
                } else {
                    HandBomb(x, y, i - 1);
                }
            } else if (weapon == 2) { // gun shot
                if (x == 0 && i - 1 < 0) {
                    continue;
                }
                if (type == -1) {
                    type = HandBomb(x, y, i);
                } else {
                    HandBomb(x, y, i);
                }
            } else if (weapon == 0) // rocket
            {
                if (type == -1) {
                    type = HandBomb(x - 1, y, 0);
                } else {
                    HandBomb(x - 1, y, 0);
                }

                if (type == -1) {
                    type = HandBomb(x, y, 0);
                } else {
                    HandBomb(x, y, 0);
                }

                if (type == -1) {
                    type = HandBomb(x + 1, y, 0);
                } else {
                    HandBomb(x + 1, y, 0);
                }

                if (type == -1) {
                    type = HandBomb(x, y + 1, 0);
                } else {
                    HandBomb(x, y + 1, 0);
                }

                if (type == -1) {
                    type = HandBomb(x, y - 1, 0);
                } else {
                    HandBomb(x, y - 1, 0);
                }

                break;
            }
        }

        equipment.setDecrease(weapon);

        if (type > -1) {
            System.out.println("You just sank a " + ship.getType(type));
        }
    }

}
