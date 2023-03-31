package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {

    Alarm alarm;
    Sensor sensor;

    @Before
    public void prepare(){
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecouseLowPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(14.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmShouldBeOnBecauseHighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(25.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmShouldBeOff() {
        when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}
