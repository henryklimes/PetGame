import javax.swing.*;

public class Needs {

    public static int hungry = 4;
    public static int hygiene = 4;
    public static int fun = 4;
    public static int aq = hungry + hygiene + fun;

    public static void checker() {
        setter();
        if (hungry <= 0) {
            if (hygiene <= 0) {
                if (fun <= 0) {
                    setter();
                    JOptionPane.showMessageDialog(null, "Game Over! Pet died.", "GAME OVER", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                } else {}
            } else {}
        } else {}
    }

    public static void setter() {
        Needs.aq = Needs.hungry + Needs.hygiene + Needs.fun;
        Gui.moodChecker();
        Gui.setCounts();
        if (hungry < 0) {hungry = 0;} if (hygiene < 0) {hygiene = 0;} if (fun < 0) {fun = 0;}
    }
    public static void needsMinus() {
        --Needs.hungry;
        --Needs.hygiene;
        --Needs.fun;
        checker();
    }
}