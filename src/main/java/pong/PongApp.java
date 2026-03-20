package pong;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PongApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PongApp::startGame);
    }

    public static void startGame() {
        GameMode mode = askMode();
        Difficulty difficulty = (mode == GameMode.VS_COMPUTER) ? askDifficulty() : Difficulty.MEDIUM;
        new GameFrame(mode, difficulty).setVisible(true);
    }

    private static GameMode askMode() {
        Object[] options = {"2 Players", "Against Computer"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose a game mode:",
                "Pong",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (choice == 1) return GameMode.VS_COMPUTER;
        return GameMode.TWO_PLAYERS;
    }

    private static Difficulty askDifficulty() {
        Object[] options = {"Easy", "Medium", "Hard"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose a difficulty:",
                "Pong – Difficulty",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );
        return switch (choice) {
            case 0  -> Difficulty.EASY;
            case 2  -> Difficulty.HARD;
            default -> Difficulty.MEDIUM;
        };
    }
}
