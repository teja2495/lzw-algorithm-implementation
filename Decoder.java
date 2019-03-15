//Bala Guna Teja Karlapudi

import java.io.BufferedReader;								//Import Statements
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Decoder {
    public static void main(String[] args) {
        double max_table_size = java.lang.Math.pow(2,Integer.parseInt(args[1]));	//Max Table size is Calculated
        String fname = args[0];
        String newFname="";
        if (fname.indexOf(".") > 0)							//For Generating the Output File name
            newFname = fname.substring(0, fname.lastIndexOf("."));
        
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fname)), "UTF-16BE"));		//For Reading input file
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(newFname + "_decoded.txt")))); //For Writing Output File

            Map<String, Integer> table = new HashMap<>();	//Initializing a hashmap with ASCII values.
            for (int i = 0; i <= 255; i++) {
                table.put(Character.toString((char) i), i);
            }

            int code;
            String str = "", new_str = "";			//STRING and NEW_STRING are initialized

            while ((code = input.read()) != -1) {		//A Loop for reading the contents of the input file
                if (!table.containsValue(code)) {		//To handle when the table do not contain any data
                    new_str = str + str.charAt(0);
                } 
		else {
                    new_str = String.valueOf(getKey(table, code));
                }
                if (table.size() < max_table_size) {		//Checking if the table size is less than Max table size
                    table.put(str + new_str.charAt(0), table.size());
                    output.write(new_str);
                }
                str = new_str;
            }
	    input.close();	
            output.close();
	    System.out.println("The Decoded File \""+ newFname + "_decoded.txt\" is generated!"); 
        }
        catch (FileNotFoundException fnf) {			//Catching File Not Found Exception
            System.out.println(fnf.getMessage()+ "File Not Found!");
            System.exit(0);
        }
        catch (IOException io) {				//Catching IO Exception
            System.out.println(io.getMessage() +  "Cannot Read File!");
        }
    }

    public static Object getKey(Map hm, int value) {		//A Function for getting the "Key" using a "Value" in the hashmap
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value))
                return o;
        }
        return null;
    }
}
