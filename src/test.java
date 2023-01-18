import static org.junit.Assert.assertEquals;

public class test {

    @org.junit.Test
    // Prueba de que funcione checkMaxLimit en AM y FM
    public void checkMaxLimit() {
        /* SI CAMBIAMOS EL VALOR ESPERADO A FALSE DA ERROR */
        Radio rad = new Radio();
        // Agrega los maximos a las estaciones
        rad.setAMActualStation(1610);
        rad.setFMActualStation(107.9);
        // AM
        rad.AM_FM = true;
        assertEquals(true, Controller.checkMaxLimit(rad));
        // FM
        rad.AM_FM = false;
        assertEquals(true, Controller.checkMaxLimit(rad));
    }

    // Prueba de que funcione el checkMinLimit en AM y FM
    @org.junit.Test
    public void checkMinLimit() {
        Radio rad = new Radio();
        // Agrega los minimos a las estaciones
        rad.setAMActualStation(530);
        rad.setFMActualStation(87.9);
        // AM
        rad.AM_FM = true;
        assertEquals(true, Controller.checkMinLimit(rad));
        // FM
        rad.AM_FM = false;
        assertEquals(true, Controller.checkMinLimit(rad));
    }

    @org.junit.Test
    public void Forward() { // forward en AM y FM
        Radio rad = new Radio();
        // establece frecuencia arbitraria a las estaciones
        rad.setAMActualStation(530);
        rad.setFMActualStation(87.9);
        // AM
        rad.AM_FM = true;
        rad.Forward();
        assertEquals(540, rad.getAMActualStation());
        // FM (como es de tipo float, se agrega un tercer valora un final que es el
        // rango de error)
        rad.AM_FM = false;
        rad.Forward();
        assertEquals(88.1, rad.getFMActualStation(), 0.00001);

    }

}