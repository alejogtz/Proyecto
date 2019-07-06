package com.heroku.GutierrezReyesAlejo.Generadoores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
/**
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
*/
import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;

public class DocumentoXls {
	public static void deObjetosCifrado(HttpServletResponse response, List<Cifrado> objetos) throws IOException {
		/**HSSFWorkbook libroTrabajo = new HSSFWorkbook();
		HSSFSheet hoja = libroTrabajo.createSheet("ObjetosCifrado");
		
		System.out.println(objetos.size());
		
		// Primera fila 
		int numeroFila = 0;
		HSSFRow fila = hoja.createRow(numeroFila);

		String[] cabeceras = { "id","Tipo de Cifrado" ,"Texto Plano", "Texto Cifrado" };
		int numeroCabecera = 0;

		for (String cabecera : cabeceras) {
			HSSFCell celdaCabecera = fila.createCell(numeroCabecera);
			celdaCabecera.setCellValue(cabecera);
			numeroCabecera += 1;
		}
		//Siguiente fila 
		numeroFila += 1;
		for (Cifrado obj : objetos) {
			fila = hoja.createRow(numeroFila);
			fila.createCell(0).setCellValue(obj.getId());
			fila.createCell(1).setCellValue(obj.getTipoCifrado());
			fila.createCell(2).setCellValue(obj.getTextoPlano());
			fila.createCell(3).setCellValue(obj.getTextoCifrado());
		}
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=Cifrados.xls");
		ServletOutputStream salida = response.getOutputStream();
		libroTrabajo.write(salida);

		libroTrabajo.close();*/
	}// End Method
}
