import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Gear> gears = new ArrayList<>();
        gears.add(null);
        for (int i = 0 ; i < 4; i++)
            gears.add(new Gear());
        gears.add(null);

        for (int i = 1; i <= 4; i++) {
            String line = sc.nextLine();
            
            Gear gear = gears.get(i);
            Gear leftGear = gears.get(i - 1);
            Gear rightGear = gears.get(i + 1);

            gear.setGear(line, leftGear, rightGear);
        }
        
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int gearNum = sc.nextInt();
            int dir = sc.nextInt();

            gears.get(gearNum).rotate(dir);
        }

        int score = 0;
        for (int i = 1; i <= 4; i++) {
            Gear gear = gears.get(i);
            score += gear.getTop() * (1 << (i - 1));
        }

        System.out.println(score);
    }
}

class Gear {
    int left, right, top;
    String cogs;
    boolean isRotating = false;

    Gear leftGear = null;
    Gear rightGear = null;

    public Gear() {
        this.left = 6;
        this.right = 2;
        this.top = 0;
    }

    public void setGear(String data, Gear leftGear, Gear rightGear) {
        this.cogs = data;
        this.leftGear = leftGear;
        this.rightGear = rightGear;
    }

    public void rotate(int dir) {
        if (isRotating)
            return;
        isRotating = true;

        if (leftGear != null && leftGear.getRight() != getLeft()) {
            leftGear.rotate(-dir);
        }
        if (rightGear != null && rightGear.getLeft() != getRight()) {
            rightGear.rotate(-dir);
        }

        left = (left - dir + cogs.length()) % cogs.length();
        right = (right - dir + cogs.length()) % cogs.length();
        top = (top - dir + cogs.length()) % cogs.length();

        isRotating = false;
    }

    public int getLeft() {
        return cogs.charAt(left);
    }

    public int getRight() {
        return cogs.charAt(right);
    }

    public int getTop() {
        return cogs.charAt(top) - '0';
    }
}
