import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRadio extends JFrame {

    private JPanel radioForm;
    private JButton swithOn;
    private JPanel mainRadioStage;
    private JButton switchOff;
    private JButton em1;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a10Button;
    private JButton a11Button;
    private JButton a12Button;
    private JButton button1;
    private JButton button2;
    private JComboBox comboBox1;

    public MainRadio(){
        setContentPane(radioForm);
        setSize(300,300);
        setTitle("Radio");
        switchOff.setVisible(false);
        mainRadioStage.setVisible(false);


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
