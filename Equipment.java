
public class Equipment {

    private int gunshot;
    private int handbomb;
    private int rocket;

    public int getGunshotCount() {
        return gunshot;
    }

    public int getGunshotSize() {
        return 1;
    }

    public void setGunshot(int gunshot) {
        this.gunshot = gunshot;
    }

    public int getHandbombCount() {
        return handbomb;
    }

    public int getHandbombSize() {
        return 3;
    }

    public void setHandbomb(int handbomb) {
        this.handbomb = handbomb;
    }

    public int getRocketCount() {
        return rocket;
    }

    public int getRocketSize() {
        return 5;
    }

    public void setRocket(int rocket) {
        this.rocket = rocket;
    }

    public int TotalEquipment() {
        return this.getGunshotCount() + this.getHandbombCount() + this.getRocketCount();
    }

    public void setEasy() {
        this.setGunshot(7);
        this.setHandbomb(2);
        this.setRocket(1);
    }

    public void setNormal() {
        this.setGunshot(10);
        this.setHandbomb(3);
        this.setRocket(1);
    }

    public void setHard() {
        this.setGunshot(12);
        this.setHandbomb(4);
        this.setRocket(1);
    }

    public void setDecrease(int type) {
        if (type == 0)//rocket
        {
            if (this.getRocketCount() > 0) {
                this.setRocket(this.getRocketCount() - 1);
            }
        } else if (type == 1)//hand bomb
        {
            if (this.getHandbombCount() > 0) {
                this.setHandbomb(this.getHandbombCount() - 1);
            }
        } else//gun shot
        {
            if (this.getGunshotCount() > 0) {
                this.setGunshot(this.getGunshotCount() - 1);
            }
        }
    }

}
