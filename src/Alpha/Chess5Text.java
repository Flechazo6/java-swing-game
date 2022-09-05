package Alpha;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess5Text extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 4877484591716823524L;
    Chess5Panel Chess5Panel;

    public Chess5Panel getChessBorder() {
        return Chess5Panel;
    }

    public Chess5Text(Chess5Panel Chess5Panel) {
        this.Chess5Panel = Chess5Panel;
        this.setLayout(new BorderLayout());
        this.add(Chess5Panel, BorderLayout.CENTER);
        this.setTitle("Îå×ÓÆå");
        this.setSize(600, 680);
        JButton Save = new JButton("Save");
        JButton Clear = new JButton("Clear");
        JPanel content = new JPanel(new FlowLayout());
        content.add(Save);
        content.add(Clear);
        this.add(content, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        Save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chess5Panel.save();
            }
        });
        Clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chess5Panel.Clear();
            }
        });
    }

    public static void main(String[] args) {

        Chess5Panel Chess5Panel = new Chess5Panel();
        Chess5Text frame = new Chess5Text(Chess5Panel);
        frame.setVisible(true);
    }
}
