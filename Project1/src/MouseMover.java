import java.awt.*;
import java.util.Random;

public class MouseMover {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;


    public void move() throws AWTException {
        Robot robot = new Robot();
        Random random = new Random();

        robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
    }


}