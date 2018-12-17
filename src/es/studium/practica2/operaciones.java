package es.studium.practica2;

public class operaciones {

	static String sentencia2 = "UPDATE `DIP2-JARC`.`Articulos` SET `descripcionArticulo`= " + vistaModificarArticulo.desc + "," + "`precioArticulo` "+ 11 + "," + "`cantidadStockArticulo`= " + 44 + " WHERE `idArticulos`= " + 1 + ";";
	
	public static void main(String[] args) {
		
		
		System.out.println(sentencia2);
		
	}

}
