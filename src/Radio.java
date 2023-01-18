public class Radio implements IRadio {
    // True encendido, false apagado
    private boolean encendido = false;

    // True AM, false FM
    public boolean AM_FM = false;
    private int freqAM;
    private double freqFM;

    // Listas para almacenar las frecuencias de AM y FM respectivamente
    int[] AMlist = new int[12];
    double[] FMlist = new double[12];

    // AM mult de 10, de 530 a 1610
    // FM mult de 0.2, de 87.9 a 107.9

    @Override
    public void on() {
        encendido = true;
    }

    @Override
    public void off() {
        encendido = false;
    }

    @Override
    public boolean isOn() {
        return encendido;
    }

    @Override
    public void setFrequence(String freq) throws Exception {
        if (AM_FM) { // si es am
            try {
                freqAM = Integer.parseInt(freq);
                setAMActualStation(freqAM);
            } catch (Exception e) {
            }
        } else { // si es fm
            try {
                freqFM = Double.parseDouble(freq);
                setFMActualStation(freqFM);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public String getFrequence() {
        if (AM_FM) { // si es AM
            return freqAM + "";
        } else { // si es FM
            return freqFM + "";
        }
    }

    @Override
    public void Forward() { // Solo suma lo apropiado para cada tipo de señal
        if (AM_FM) { // Si es AM
            freqAM = freqAM + 10;
            setAMActualStation(freqAM);
        } else { // Si es FM
            freqFM = freqFM + 0.2;
            setFMActualStation(freqFM);
        }
    }

    @Override
    public void Backward() { // Solo resta lo apropiado para cada tipo de señal
        if (AM_FM) { // Si es AM
            freqAM = freqAM - 10;
        } else { // Si es FM
            freqFM = freqFM - 0.2;
        }
    }

    @Override
    public double getFMActualStation() {
        return freqFM;
    }

    @Override
    public int getAMActualStation() {
        return freqAM;
    }

    @Override
    public void setFMActualStation(double actualStation) {
        freqFM = actualStation;
    }

    @Override
    public void setAMActualStation(int actualStation) {
        freqAM = actualStation;
    }

    @Override
    public void saveFMStation(double actualStation, int slot) {
        FMlist[slot] = actualStation;
    }

    @Override
    public void saveAMStation(int actualStation, int slot) {
        AMlist[slot] = actualStation;
    }

    @Override
    public double getFMSlot(int slot) {
        return FMlist[slot];
    }

    @Override
    public int getAMSlot(int slot) {
        return AMlist[slot];
    }
}