package com.bancoCdisAABC.springoot.app.errors;

public class DataBaseBancoException extends RuntimeException{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 5438560362964238827L;
	
	public DataBaseBancoException() {
    super("Contacte con la administracion, hubo un error con la base de datos");
 }
}
