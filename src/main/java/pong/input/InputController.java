package pong.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InputController extends KeyAdapter {
    private final Set<Integer> down = ConcurrentHashMap.newKeySet();

    @Override
    public void keyPressed(KeyEvent e) {
        down.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        down.remove(e.getKeyCode());
    }

    public boolean isDown(int keyCode) {
        return down.contains(keyCode);
    }
}
