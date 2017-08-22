package labmock;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

public class TestaSIAPJ {
	
	@InjectMocks private SIAPJ siapj;
	
	@Mock private IServicoEmail emailMock;
	@Mock private IServicoDB dbMock;
	@Mock private IValidatorProcesso validatorMock;
	@Mock private IProcesso processo1;
	@Mock private IProcesso processo2;
	
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		siapj = new SIAPJ(emailMock,dbMock, validatorMock);
	}
	
	@Test
	public void testaInicializaoSIAPJ() {
			//Criando dummy objects dos parametros de siapj para teste
			siapj = new SIAPJ(emailMock, dbMock, validatorMock);
			assertNotNull(siapj);
	}
	
	@Test
	public void testaCriaReclamacao() throws SQLException, MessagingException {
		Mockito.when(processo1.getEmail()).thenReturn("ces28@gmail.com");
		Mockito.when(processo2.getEmail()).thenReturn("talizefq@gmail.com");
		Mockito.when(validatorMock.validaProcesso(processo1)).thenReturn(true);
		Mockito.when(validatorMock.validaProcesso(processo2)).thenReturn(false);
		Mockito.when(dbMock.persisteProcesso(processo1)).thenReturn(1);
		Mockito.when(emailMock.sendEmail(processo1.getEmail(), "Processo aceito")).thenReturn(true);
		Mockito.when(emailMock.sendEmail(processo1.getEmail(), "Existem erros em seu processo")).thenReturn(true);
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
		
		siapj.criaReclamacao(processo1);
		siapj.criaReclamacao(processo2);
		
		Mockito.verify(validatorMock,Mockito.times(2)).validaProcesso(Mockito.any());
		Mockito.verify(dbMock,Mockito.times(1)).persisteProcesso(Mockito.any());
		Mockito.verify(emailMock,Mockito.times(2)).sendEmail(Mockito.any(),Mockito.any());
		
		Mockito.verify(mockConnection,Mockito.times(1)).createStatement();
	
	}

}
