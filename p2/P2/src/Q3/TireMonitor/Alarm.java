package Q3.TireMonitor;


public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private ISensor _sensor;
    
    private boolean _alarmOn = false;
    
    public Alarm(ISensor sensor) {
    	_sensor = sensor;
    }


    public void check()
    {
        double psiPressureValue = _sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            _alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return _alarmOn; 
    }
}