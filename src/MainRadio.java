import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRadio extends JFrame {

    private JPanel radioForm;
    private JButton swithOn;
    private JPanel mainRadioStage;
    private JButton switchOff;

    public MainRadio(){
        setContentPane(radioForm);
        setSize(300,300);
        setTitle("Radio");
        switchOff.setVisible(false);

        //SwitchOn action
        swithOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swithOn.setVisible(false);
                mainRadioStage.setVisible(true);
                switchOff.setVisible(true);
            }
        });

        //SwitchOff action
        switchOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchOff.setVisible(false);
                swithOn.setVisible(true);
                mainRadioStage.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame radio = new MainRadio();
        radio.setVisible(true);
    }



}
