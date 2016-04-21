package cl.ubb.agil;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestProducto {
	
	@Test
	public void TestVerificaStock(){
		Categoria categoria = new Categoria("instrumentos","ins1");
		Producto producto = new Producto("flauta",2,6,categoria);
		
		int stock = producto.getStock();
		
		assertThat(stock,equalTo(0));
	}
	
	@Test
	public void TestIsBajoStockTrue(){
		Producto producto = new Producto("flauta",2,6);
		
		boolean stockBajo = producto.isBajoStock();
		
		assertThat(stockBajo,equalTo(true));
	}
	
	@Test
	public void TestIsBajoStockFalse(){
		Existencia ex1 = new Existencia("23");
		Existencia ex2 = new Existencia("54");
		Producto producto = new Producto("flauta",1,6);
		producto.addExistencia(ex1);
		producto.addExistencia(ex2);
		
		boolean stockBajo = producto.isBajoStock();
		
		assertThat(stockBajo,equalTo(false));
	}
	
	@Test
	public void TestGetStockFaltante(){
		Producto producto = new Producto("flauta",2,6);
		
		int stockFaltante = producto.getStockFaltante();
		
		assertThat(stockFaltante,equalTo(6));
	}
	
	@Test
	public void TestGetCategoria(){
		Categoria categoria = new Categoria("instrumentos","ins1");
		Producto producto = new Producto("flauta",2,6,categoria);
		
		Categoria cat = producto.getCategoria();
		
		assertThat(cat,equalTo(categoria));
	}
	
	@Test
	public void TestSetCategoria(){
		Categoria categoria = new Categoria("instrumentos","ins1");
		Producto producto = new Producto("flauta",2,6,categoria);
		Categoria otra = new Categoria("limpieza","li56");
		
		producto.setCategoria(otra);
		
		assertThat(producto.getCategoria(),equalTo(otra));
	}
	
	@Test
	public void TestGetNombre(){
		Producto producto = new Producto("flauta",2,6);
		
		String nombre = producto.getNombre();
		
		assertThat(nombre,equalTo("flauta"));
	}
	
	@Test
	public void TestSetNombre(){
		Producto producto = new Producto("flauta",2,6);
		producto.setNombre("guitarra");
		
		String nombreNuevo = producto.getNombre();
		
		assertThat(nombreNuevo,equalTo("guitarra"));
	}
	
	@Test
	public void TestGetProximaExistencia() throws ExcepcionDeProducto{
		Existencia ex1 = new Existencia("23");
		Existencia ex2 = new Existencia("54");
		Producto producto = new Producto("flauta",1,6);
		producto.addExistencia(ex1);
		producto.addExistencia(ex2);
		
		Existencia prox = producto.getProximaExistencia();
		
		assertThat(prox,equalTo(ex2));
	}
	
	@Test(expected=ExcepcionDeProducto.class)
	public void TestGetProximaExistenciaExepcion()throws ExcepcionDeProducto{
		Existencia ex1 = new Existencia("23");
		Existencia ex2 = new Existencia("54");
		Producto producto = new Producto("flauta",1,6);
		producto.addExistencia(ex1);
		producto.addExistencia(ex2);
		
		producto.getProximaExistencia();
		producto.getProximaExistencia();
		producto.getProximaExistencia();
		
	}

	@Test
	public void TestAddExistenciaTrue(){
		Existencia ex1 = new Existencia("23");
		Producto producto = new Producto("flauta",1,6);
		
		boolean agregar = producto.addExistencia(ex1);
		
		assertThat(agregar,equalTo(true));
		
	}
	
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void TestAddExistenciaFalse(){
		Existencia ex1 = new Existencia("23");
		Producto producto = new Producto("flauta",0,0);
		boolean resultado=producto.addExistencia(ex1);
	
		assertThat(resultado,equalTo(true));
	}
	
	
	@Test
	public void TestGetCodigoProximaExistenciaSinCategoria()throws ExcepcionDeProducto{
		Existencia ex1 = new Existencia("23");
		Existencia ex2 = new Existencia("257");
		Producto producto = new Producto("flauta",1,6);
		producto.addExistencia(ex1);
		producto.addExistencia(ex2);
		
		String codigoProxima = producto.getCodigoProximaExistencia();
		
		assertThat(codigoProxima,equalTo("XXXXX-257"));
	}
	
	@Test
	public void TestGetCodigoProximaExistenciaConCategoria()throws ExcepcionDeProducto{
		Existencia ex1 = new Existencia("23");
		Existencia ex2 = new Existencia("257");
		Categoria categoria = new Categoria("instrumentos","ins1");
		Producto producto = new Producto("flauta",1,6,categoria);
		producto.addExistencia(ex1);
		producto.addExistencia(ex2);
		
		String codigoProxima = producto.getCodigoProximaExistencia();
		
		assertThat(codigoProxima,equalTo("ins1-257"));
	}
	
	
	@Test(expected=ExcepcionDeProducto.class)
	public void TestGetCodigoProximaExistenciaExcepcio()throws ExcepcionDeProducto{
		Producto producto = new Producto("flauta",1,6);
		
		producto.getCodigoProximaExistencia();
	}
}
