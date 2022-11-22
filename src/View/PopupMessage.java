package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupMessage extends JFrame {
    private JPanel popupMessage;
    private JButton OKButton;
    private JLabel mesage;

    public PopupMessage(String msg) {
        setTitle("Mensagem");
        setBounds(500, 300, 400, 200);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        getContentPane().add(popupMessage);
        mesage.setText(msg);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }

    public static void main(String[] args) {
        PopupMessage popupMessage = new PopupMessage(args.toString());
    }
}
