import java.io.File;
import jxl.Workbook;

public class Readxcel {

	public static void main(String[] args) throws Exception {
				
		File src = new File("D:/Data.xls");
		Workbook wb= Workbook.getWorkbook(src);
		String data00=wb.getSheet(0).getCell(0,0).getContents();
		System.out.println("Data at Col 0 and Row 0 is: "+data00);
		String data10 = wb.getSheet(0).getCell(1,0).getContents();
		System.out.println("Data at Col 1 and row 0 is: "+ data10);
		int rows = wb.getSheet(0).getRows();
		System.out.println("Num of rows are: "+rows);
	}

}


