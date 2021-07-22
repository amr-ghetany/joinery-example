package jupai.dataprep;
import tech.tablesaw.api.Table;

import java.io.IOException;

public class LoadingData {
    public LoadingData() {
    }
   public static void main(String[] args ) {
       /**
        * When loading the entire CSV sheet
        * Give the path that the csv is located
        */
       Table titanicAnalytics  = null;
       try {
           titanicAnalytics = Table.read().csv("src/main/resources/data/titanic.csv");
       } catch (IOException e) {
           e.printStackTrace ();
       }


       /**
        * Getting the structure of the table, this is knowing the data types using Table saw
        */
       Table structure = titanicAnalytics.structure();
       System.out.println(structure);
       System.out.println("WE ARE HERE, DONE PRINTING titanic.csv ?");


   }
}
