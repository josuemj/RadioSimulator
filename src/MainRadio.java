import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class MainRadio extends JFrame {

    private JPanel radioForm;
    private JButton swithOn;
    private JPanel mainRadioStage;
    private JButton switchOff;
    private JButton b7;
    private JButton b8;
    private JButton b2;
    private JButton b9;
    private JButton b3;
    private JButton b4;
    private JButton b10;
    private JButton b5;
    private JButton b11;
    private JButton b6;
    private JButton b12;
    private JButton forwardButton;
    private JButton backfardButton;
    private JComboBox frequenceChanger;
    private JLabel freNumberID;
    private JButton b1;
    public static DecimalFormat df = new DecimalFormat("#.0");

    public MainRadio(){

        //Panel construction
        setContentPane(radioForm);
        setTitle("Radio");
        switchOff.setVisible(false);
        mainRadioStage.setVisible(false);
        setSize(722,662);
        setResizable(false);

        //Default values
        frequenceChanger.addItem("AM");
        frequenceChanger.addItem("FM");



        //Radio Object settlement
        Radio radio = new Radio();


        //SwitchOn action
        swithOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swithOn.setVisible(false);
                mainRadioStage.setVisible(true);
                switchOff.setVisible(true);

                //Initial Settlement
                radio.on();
                radio.AM_FM = Controller.getComboFreq(frequenceChanger); //Where true is AM as default value

                if (radio.AM_FM){
                    System.out.println("No station settled");
                    try{
                        radio.setFrequence("530");
                        freNumberID.setText(radio.getFrequence());
                    } catch(Exception r){
                        System.out.println("Error setting radio");
                    }
                }



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

        frequenceChanger.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Changing freq");

                radio.AM_FM = Controller.getComboFreq(frequenceChanger);

                if(!radio.AM_FM){
                    //if it's FM
                    try{
                        radio.setFrequence("87.9");
                        freNumberID.setText(df.format(radio.getFMActualStation()));
                    } catch (Exception a){
                        System.out.println("Error on switching");
                    }

                }else{
                    //if i's AM
                    try{
                        radio.setFrequence("530");
                        freNumberID.setText(radio.getFrequence());
                    } catch (Exception a){
                        System.out.println("Error on switching");
                    }
                }



            }
        });

        //Forward radio button
        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Controller.checkMaxLimit(radio)){

                    System.out.println("\n============"+"\nMAX LIMIT REACHED"+"\n==============");
                    System.out.println(radio.getFrequence());

                    if (radio.AM_FM){
                        try{
                            radio.setFrequence("530");
                            System.out.println("Freq: "+radio.getFrequence());
                            System.out.println("AMFreq "+radio.getAMActualStation());
                            pushRadio(radio);
                        } catch (Exception a){
                            System.out.println("Error");
                        }
                    } else{
                        try{
                            radio.setFrequence("87.9");
                            System.out.println("Freq: "+radio.getFrequence());
                            System.out.println("FMFreq "+radio.getAMActualStation());
                            pushRadio(radio);
                        } catch (Exception a){
                            System.out.println("Error");
                        }
                    }
                } else{
                    radio.Forward();
                    pushRadio(radio);
                }
            }
        });

        //Backward radio button
        backfardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Controller.checkMinLimit(radio)){

                    System.out.println("\n============"+"\nMIN LIMIT REACHED"+"\n==============");
                    System.out.println(radio.getFrequence());

                    if (radio.AM_FM){
                        try{
                            System.out.println(radio.getAMActualStation());
                            radio.setFrequence("1610");
                            pushRadio(radio);
                        } catch (Exception a){
                            System.out.println("Error");
                        }
                    } else{
                        try{
                            radio.setFrequence("107.9");
                            System.out.println(radio.getFMActualStation());;
                            pushRadio(radio);
                        } catch (Exception a){
                            System.out.println("Error");
                        }
                    }
                } else{
                    radio.Backward();
                    pushRadio(radio);



                }
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,0);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,1);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,2);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,3);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,4);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,5);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,6);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,7);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,8);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,9);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,10);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.saveFreq(radio,11);
                if(radio.AM_FM){
                    freNumberID.setText(radio.getAMActualStation()+"");
                } else{
                    freNumberID.setText(df.format(radio.getFMActualStation()));
                }
            }
        });
    }

    public void pushRadio(Radio radio){
        if(radio.AM_FM){
            freNumberID.setText(radio.getFrequence());
            System.out.println("=======================");
            System.out.println("Pushing AM "+radio.getAMActualStation());
            System.out.println("getFreq str: "+radio.getFrequence());
            System.out.println("AMfreq "+radio.getAMActualStation());
        }else{
            freNumberID.setText(df.format(radio.getFMActualStation()));
            System.out.println("Pushing FM "+radio.getFMActualStation());
            System.out.println("getFreq str: "+radio.getFrequence());
            System.out.println("FMfreq "+radio.getFMActualStation());

        }
    }

    public static void main(String[] args) {
        JFrame radio = new MainRadio();
        radio.setVisible(true);
    }



}
