public class Radio implements IRadio{


    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public boolean isOn() {
        return false;
    }

    @Override
    public void setFrequence(String freq) throws Exception {

    }

    @Override
    public String getFrequence() {
        return null;
    }

    @Override
    public void Forward() {

    }

    @Override
    public void Backward() {

    }

    @Override
    public double getFMActualStation() {
        return 0;
    }

    @Override
    public int getAMActualStation() {
        return 0;
    }

    @Override
    public void setFMActualStation(double actualStation) {

    }

    @Override
    public void setAMActualStation(int actualStation) {

    }

    @Override
    public void saveFMStation(double actualStation, int slot) {

    }

    @Override
    public void saveAMStation(int actualStation, int slot) {

    }

    @Override
    public double getFMSlot(int slot) {
        return 0;
    }

    @Override
    public int getAMSlot(int slot) {
        return 0;
    }
}
