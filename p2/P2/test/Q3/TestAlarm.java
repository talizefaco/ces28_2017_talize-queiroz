package Q3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Q3.TireMonitor.*;



public class TestAlarm {
	
	@InjectMocks private Alarm alarm;
	@Mock private ISensor sensorMock;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		alarm = new Alarm(sensorMock);
	}
	
	@Test
	public void testInicializationAlarm() {
			//Criando dummy objects dos parametros de Alarm para teste
			alarm = new Alarm(sensorMock);
			assertNotNull(alarm);
	}
	
	@Test
	public void testIfAlarmIsOffRightAfterInicialization() {
		assertEquals(false,alarm.isAlarmOn());
		
	}
	
	@Test
	public void testIfpsiPressureValueSmallerThanLowPressureThresholdTurnsOnTheAlarm() {
		Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn((double)15);
		alarm.check();
		assertEquals(true,alarm.isAlarmOn());
		
	}
	
	@Test
	public void testIfpsiPressureValueBiggerThanHighPressureThresholdTurnsOnTheAlarm() {
		Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn((double)23);
		alarm.check();
		assertEquals(true,alarm.isAlarmOn());
		
	}

	
	@Test
	public void testIfpsiPressureValueBiggerThanLowPressureThresholdAndSmallerThanHighPressureThresholdDoesntTurnOnTheAlarm() {
		Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn((double)19);
		alarm.check();
		assertEquals(false,alarm.isAlarmOn());
		
	}
	
	@Test
	public void testIfpsiPressureValueEqualsToLowPressureThresholdDoesntTurnOnTheAlarm() {
		Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn((double)17);
		alarm.check();
		assertEquals(false,alarm.isAlarmOn());
		
	}
	
	@Test
	public void testIfpsiPressureValueEqualsToHighPressureThresholdDoesntTurnOnTheAlarm() {
		Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn((double)21);
		alarm.check();
		assertEquals(false,alarm.isAlarmOn());
		
	}
}
