import javax.swing.*;

/**
 * Controller class controls logic
 */

public class Controller {

    /**
     * Checks the combobox changes
     * @param combobox
     * @return
     */
    public static boolean getComboFreq(JComboBox combobox) {
        String frequenceType = (String) combobox.getSelectedItem();
        if (frequenceType.equals("AM")) {
            System.out.println("AM frequence detected");
            return true;
        }
        System.out.println("FM frequence detected");
        return false; // false if FM
    }

    /**
     * Method checks if the radio is on it's max freq when pressing forward.
     * 
     * @param radio
     * @return bool, true if it's reached the max.
     */
    public static boolean checkMaxLimit(Radio radio) {

        // cast
        float FMfreq = (float) radio.getFMActualStation();
        System.out.println("CHECKING AM: " + radio.getAMActualStation());
        System.out.println("CHECKING FM: " + FMfreq);

        if (radio.AM_FM) {
            if (radio.getAMActualStation() == 1610) {
                System.out.println("VERIFIED FM");
                System.out.println("REACHED MAX AM");
                return true;
            }
        } else {
            if (FMfreq == Float.parseFloat("107.9")) {
                System.out.println("REACHED MAX FM");
                return true;
            }
        }
        return false;
    }

    /**
     * Methos checks if the radio has checked the lowest freq when pressing
     * backward.
     * 
     * @param radio
     * @return bool true if it's reached the min.
     */
    public static boolean checkMinLimit(Radio radio) {
        if (radio.AM_FM) {
            if (radio.getAMActualStation() == 530) {
                System.out.println("REACHED MIN AM");
                return true;
            }
        } else {
            if (radio.getFMActualStation() == 87.9) {
                System.out.println("REACHED MIN FM");
                return true;
            }
        }
        return false;
    }

    /**
     * Method saves a frequency given a slot int
     * @param radio
     * @param slot
     */

    public static void saveFreq(Radio radio, int slot) {
        if (radio.AM_FM) {
            if (radio.getAMSlot(slot) == 0) {
                int tem = radio.getAMActualStation();
                radio.saveAMStation(tem, slot);
            } else {
                int tem = radio.getAMSlot(slot);
                radio.setAMActualStation(tem);
            }
        } else {
            if (radio.getFMSlot(slot) == 0) {
                double tem = radio.getFMActualStation();
                radio.saveFMStation(tem, slot);
            } else {
                double tem = radio.getFMSlot(slot);
                radio.setFMActualStation(tem);
            }
        }
    }

}
