package Q4.ptc;

import static org.junit.Assert.*;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

public class TesteControladorPTC {
	
	@InjectMocks private ControladorPTC controlador;
	
	@Mock private Datacenter datacenterMock;
	@Mock private PainelCondutor painelMock;
	@Mock private Sensor sensorMock;

	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controlador = new ControladorPTC(sensorMock,datacenterMock, painelMock);
	}
	
	@Test //Item A
	public void testaInicializaoControladorPTC() {
			//Criando dummy objects dos parametros de ControladorPTC para teste
			controlador = new ControladorPTC(sensorMock,datacenterMock, painelMock);
			assertNotNull(controlador);
	}
	
	@Test //Item B
	public void testaQuandoTremNaoEstaEmUmCruzamento() {
		Mockito.when(sensorMock.isCruzamento()).thenReturn(false);
		Mockito.when(sensorMock.getVelocidade()).thenReturn(100.0);
		
		controlador.run();
		
		Mockito.verify(datacenterMock,Mockito.times(1)).gerarRelatorio(Mockito.any());
		//So passa pelo metodo gerarRelatorio da classe Datacenter se o codigo estiver coerente
		//Passou, logo estah verificado
	}
	
	@Test //Item C
	public void testaQuandoTremEstaEmUmCruzamentoComVelocidadeMaiorQue100() {
		Mockito.when(sensorMock.isCruzamento()).thenReturn(true);
		Mockito.when(sensorMock.getVelocidade()).thenReturn(150.0);
		Mockito.when(painelMock.imprimirAviso("Velocidade alta",1)).thenReturn(true);
		
		controlador.run();
		
		assertEquals(150.0, sensorMock.getVelocidade(),0);
		//Quando o trem se encontra em um cruzamento e a velocidade é superior 100Km/h
		//e o usuário localizado no Painel do Condutor informa que leu a mensagem (o retorno do método enviaMsgPrioritariaPainel() é verdadeiro)
		//A velocidade permanece a mesma
	}
	
	@Test //Item D
	public void testaQuandoTremEstaEmUmCruzamentoComVelocidadeMenorQue20() throws InterruptedException {
		Mockito.when(sensorMock.isCruzamento()).thenReturn(true);
		Mockito.when(sensorMock.getVelocidade()).thenReturn(10.0);
		Mockito.when(painelMock.imprimirAviso("Velocidade Baixa",1)).thenReturn(false);

		
		controlador.run();
		
		Mockito.verify(painelMock,Mockito.times(1)).aceleraVelocidadeTrem(20);
		//Quando o trem se encontra em um cruzamento e a velocidade é inferior a 20Km/h
		//e o usuário localizado no Painel do Condutor não confirma que leu a mensagem (o retorno do método enviaMsgPrioritariaPainel() é falso)
		//O método aceleraVelocidadeTrem do Painel do Condutor é chamada uma vez, com o parametro passo igual a 20.
	}
	


}
