package com.heroku.GutierrezReyesAlejo.Generadoores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
/*
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;

public class DocumentoXlsx {
	public static void deObjetosCifrado(HttpServletResponse response, List<Cifrado> objetos) throws IOException {
		/*XSSFWorkbook libroTrabajo = new XSSFWorkbook();
		XSSFSheet hoja = libroTrabajo.createSheet("ObjetosCifrado");

		int numeroFila = 0;
		XSSFRow fila = hoja.createRow(numeroFila);

		String[] cabeceras = { "id","Tipo de Cifrado", "Texto Plano", "Texto Cifrado" };
		int numeroCabecera = 0;
		for (String cabecera : cabeceras) {
			XSSFCell celdaCabecera = fila.createCell(numeroCabecera);
			celdaCabecera.setCellValue(cabecera);
			numeroCabecera += 1;
		}

		/* Siguiente fila */
		/*numeroFila += 1;
		for (Cifrado obj : objetos) {
			fila = hoja.createRow(numeroFila);
			fila.createCell(0).setCellValue(obj.getId());
			fila.createCell(1).setCellValue(obj.getTipoCifrado());
			fila.createCell(2).setCellValue(obj.getTextoPlano());
			fila.createCell(3).setCellValue(obj.getTextoCifrado());

			/* Siguientes filas */
			/*numeroFila += 1;
		}
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=objetosCifrado.xlsx");
		ServletOutputStream salida = response.getOutputStream();
		libroTrabajo.write(salida);

		libroTrabajo.close();*/

	}// end deObjetosForm
}
