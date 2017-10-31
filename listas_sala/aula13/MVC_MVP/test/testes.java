import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

import org.junit.Test;

import view.PersonDetailView;

public class testes {
	@Mock private PersonDetailView viewFake;
	
	@Test
	public void mockedView() {
		Mockito.when(viewFake.onPersonNameChanged()).theReturn()
		Mockito.when(viewFake.getNameTextField())
	}

}
