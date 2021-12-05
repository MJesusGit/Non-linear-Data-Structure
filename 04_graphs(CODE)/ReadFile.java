package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {

	private String fileName;

	public ReadFile(String fileName) {
		this.fileName = fileName;
	}

	
	public void  readCharacters(DecoratedElement<String> gr)throws NumberFormatException, IOException{
		
		try {
			FileInputStream f= new FileInputStream("starwars-pers.csv");
			
			XSSFWorkbook libro = new XSSFWorkbook(f);
			
			libro.getSheetAt(0);
			
			XSSFSheet hoja = libro.getSheetAt(0);
			
			Iterator<Row> filas = hoja.iterator();
			Iterator<Cell> celdas ;
			
			Row fila;
			Cell celda = null;
			CellType type = celda.getCellType();
			while(filas.hasNext()) {
				fila= filas.next();
				celdas=fila.cellIterator();
				while(celdas.hasNext()) {
					celda= celdas.next();
					celdas=fila.cellIterator();
					if(type.equals(CellType.STRING)) {
						//ID
						
					}else if(type.equals(CellType.STRING)) {
						//nombre
						
					}else if(type.equals(CellType.NUMERIC)) {
						//iteracciones
					}
				}
			}
					
		}catch(IOException ex){
			System.out.println(ex.getMessage());
			
		}
	
		
		
		
		
		
	}
	
	
	
}
