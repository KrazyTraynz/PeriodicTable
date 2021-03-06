import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class OverlayListener extends MouseAdapter {

    private JPanel panel;

    OverlayListener(JPanel panel){
        this.panel = panel;
    }
    @Override
    public void mouseEntered(MouseEvent e){
        if(e.getComponent() instanceof JComponent){
            Graphics g = panel.getGraphics();
            JComponent j = (JComponent)e.getComponent();
            PeriodicTable.getLayer().paint(g, j);
        }
    }
}
