package src;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class read_From_Querys {

	
	private String [] ListOfQueries;
	private int NumOfQueries;
 
	/**
	 *   reads from the queries file
	 * @param address
	 */
	public read_From_Querys(String address){

		File file = new File(address);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		

		try {
			fis = new FileInputStream(file);

			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);


			if(dis.available() != 0){
				
				String line;
				line=dis.readLine();
				NumOfQueries=Integer.parseInt(line)-1;

				ListOfQueries=new String[NumOfQueries];

				for(int i=0;i<NumOfQueries;i++) {
					
					line=dis.readLine();
					ListOfQueries[i]=line;
				}
			}
			
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public String[] getListOfQueries() {
		return ListOfQueries;
	}



	public int getNumOfQueries() {
		return NumOfQueries;
	}

	
	
	public static void main(String[] args) {

	}

}
