package cl.ubb.agil;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestExistencia {

	@Test
	public void TestGetNumeroExistencia(){
		Existencia existencia = new Existencia("4323");
		
		String numero=existencia.getNumero();
		
		assertThat(numero,equalTo("4323"));
	}
}
