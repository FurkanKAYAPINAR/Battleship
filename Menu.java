
import java.util.Scanner;

public class Menu extends Game {

    public static Scanner reader = new Scanner(System.in);

    public void Started() {
        System.out.println("*********************");
        System.out.println("Battleship Game Menu\n");
        System.out.println("1. Login");
        System.out.println("2. Create new user");
        System.out.println("3. Exit");
        System.out.println("*********************\n");
        System.out.print("Select Menu => ");

        int pointer = reader.nextInt();

        System.out.print("Enter user name : ");
        username = reader.next();
        if (!user.isUsernameChecker(username)) {
            System.out.println("Wrong Username !");
            StartMenu(pointer);
            return;
        }

        user.setUsername(username); // set user class username

        StartMenu(pointer);

    }

    public void StartMenu(int pointer) {
        if (pointer == 1) {
            user.getUserPlayed(user.getUsername());//last game win count get txt

            int playCounter = user.getPlayed();

            if (user.getLevel() == differ.Easy && playCounter >= 2) // easy && totalplaywin 2 
            {
                user.setLevel(differ.Normal);
                user.setUserPlayed(user.getUsername(), CounterClear);
                user.updateUser(user.getUsername(), differ.getTypeString(), user.getPlayed());
                equipment.setNormal();
                ship.setNormal();
                playCounter = user.getPlayed();
            } else if (user.getLevel() == differ.Normal && playCounter >= 3) // easy && totalplaywin 3
            {
                user.setLevel(differ.Hard);
                user.setUserPlayed(user.getUsername(), CounterClear);
                user.updateUser(user.getUsername(), differ.getTypeString(), user.getPlayed());
                equipment.setHard();
                ship.setHard();
                playCounter = user.getPlayed();
            }

            System.out.println("\nHELLO : " + user.getUsername() + " - Total Win : " + playCounter + " - Level : " + differ.getTypeString() + "\n");

            int mapsize = differ.getType();
            int[][] mapgrid = new int[mapsize][mapsize];
            worldgrid.setWorld(mapgrid);

            GameStart();
        } else if (pointer == 2) {
            System.out.print("Enter user name : ");
            username = reader.next();

            int playCounter = 0;
            user.setUsername(username);
            user.setLevel(differ.Easy);
            user.setUserPlayed(username, playCounter);
            equipment.setEasy();
            ship.setEasy();

            System.out.println("\nHELLO : " + user.getUsername() + " - Total Win : " + playCounter + " - Level : " + differ.getTypeString() + "\n");

            int mapsize = differ.getType(); //Harita boyutunu �ek

            int[][] mapgrid = new int[mapsize][mapsize];//Harita boyutunu belirle
            worldgrid.setWorld(mapgrid); //Haritay� olu�tur

            GameStart(); // Oyunu ba�lat
        } else {
            System.out.println("Selected Error !");
        }
    }

    public int GetX() {
        System.out.print("X coordinate to shoot: ");
        return reader.nextInt();
    }

    public int GetY() {
        System.out.print("Y coordinate to shoot: ");
        return reader.nextInt();
    }

    public void GunFunc() {
        System.out.println("0. Rocket " + equipment.getRocketCount());
        System.out.println("1. Hand Bomb " + equipment.getHandbombCount());
        System.out.println("2. Gun Shot " + equipment.getGunshotCount());

        System.out.print("Select Weapon: ");

        int pointer = reader.nextInt();

        if (pointer == 0 && equipment.getRocketCount() == 0) // Equipment Count Checker
        {
            System.out.println("Rocket's over\n");
            worldgrid.GridPrint();
            GunFunc();
            return;
        } else if (pointer == 1 && equipment.getHandbombCount() == 0) {
            System.out.println("Hand Bomb's over\n");
            worldgrid.GridPrint();
            GunFunc();
            return;
        } else if (pointer == 2 && equipment.getGunshotCount() == 0) {
            System.out.println("Gun Shot's over\n");
            worldgrid.GridPrint();
            GunFunc();
            return;
        }

        int weaponsize = 0;

        if (pointer < 0 || pointer > 2) //weapon checker
        {
            System.out.println("Select Error !\n");
            worldgrid.GridPrint();
            GunFunc();
            return;
        } else if (pointer == 0)//rocket
        {
            weaponsize = equipment.getRocketSize();
        } else if (pointer == 1)//hand bomb
        {
            weaponsize = equipment.getHandbombSize();
        } else {
            weaponsize = equipment.getGunshotSize();
        }

        int x = GetX();
        do {
            if (x < 0 || x > differ.getType()) {
                System.out.println("Invalid X Coordinate\n");
                System.out.print("X coordinate to shoot: ");
                x = reader.nextInt();
            }
        } while (x < 0 || x > differ.getType());

        int y = GetY();
        do {
            if (y < 0 || y > differ.getType()) {
                System.out.println("Invalid Y Coordinate\n");
                System.out.print("Y coordinate to shoot: ");
                y = reader.nextInt();
            }
        } while (y < 0 || y > differ.getType());

        war.HeadShot(pointer, weaponsize, x, y);

    }

}
