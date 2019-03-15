//Bala Guna Teja Karlapudi

import java.lang.String;			//Import Statements
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Encoder {
    public static void main(String[] args){
        int temp;				//A temporary variable for reading Input file contents
        String str="", sym;			//STRING and SYMBOL variables are declared

        double max_table_size = java.lang.Math.pow(2,Integer.parseInt(args[1]));	//Max Table size is Calculated
        String fname = args[0];
        String newFname="";
        if (fname.indexOf(".") > 0)							//For Generating the Output File Name
            newFname = fname.substring(0, fname.lastIndexOf("."));

        try {
            FileReader encode = new FileReader(fname);		//For Reading the input file
            Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFname + ".lzw"), "UTF-16BE")); //For Writing the Output file

            Map<String, Integer> table = new HashMap<>();	//Initializing a Hashmap with ASCII values
            for (int i = 0; i <= 255; i++) {
                table.put(Character.toString((char) i), i);
            }

            while ((temp = encode.read()) != -1) {		//A Loop for reading the input file contents
                sym = Character.toString((char) temp);

                if (table.containsKey(str + sym)) {		//Checking if the STRING + SYMBOL is available in the ASCII Hashmap
                    str = str + sym;
                } 
		else {
                    //System.out.println(table.get(str));
                    output.write(table.get(str));
                    if (table.size() < max_table_size) {	//Checking if the the Table size is less than the Max table size
                        int sz = table.size();			
                        table.put(str + sym, sz);		//Table size is given as value because the ASCII Hashmap starts with value 0
                }
                    str = sym;
                }
            }
            //System.out.println(table.get(str));
            output.write(table.get(str));
            encode.close();
            output.close();
	    System.out.println("The Encoded File \""+ newFname + ".lzw\" is generated!"); 
        }
        catch (FileNotFoundException fnf) {			//Catch block to handle File Not Found Exception
            System.out.println(fnf.getMessage()+ "File Not Found!");
            System.exit(0);
        }
        catch (IOException io) {				//Catch block to handle IO Exception
            System.out.println(io.getMessage() +  "Cannot Read File!");
        }
    }
}
