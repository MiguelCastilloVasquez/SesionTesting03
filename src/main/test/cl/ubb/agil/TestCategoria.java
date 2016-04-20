package cl.ubb.agil;


import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestCategoria {

	
	@Test
	public void testGetNombreCategoria(){
		Categoria categoria = new Categoria("instrumento","inst1");
		
		String nombre=categoria.getNombre();
		
		assertThat(nombre,equalTo("instrumento"));
	}
	
	@Test
	public void testGetCodigoCategoria(){
		Categoria categoria = new Categoria("instrumento","inst1");
		
		String codigo=categoria.getCodigo();
		
		assertThat(codigo,equalTo("inst1"));
	}
}
