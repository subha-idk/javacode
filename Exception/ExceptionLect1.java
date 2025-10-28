package Exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;

public class ExceptionLect1 {
  public static void main(String[] args) {
    // Reader reader = new InputStreamReader(null);
    try{ 
      InputStreamReader inputStreamReader = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(inputStreamReader);
      String name = br.readLine();
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
      outputStreamWriter.write(name);
      outputStreamWriter.close();
      // PrintWriter pw = new PrintWriter(System.out);
      // pw.write(name);
      // pw.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
