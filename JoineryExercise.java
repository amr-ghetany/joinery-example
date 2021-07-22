package jupai.dataprep;

import joinery.DataFrame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoineryExercise {
    public static void main(String[] args) {
        try {

            DataFrame<Object> df1 = DataFrame.readCsv ("src/main/resources/data/titanic.csv");


            List<Object> Values = new ArrayList<>();
            List<Object> values_df = df1.col ("sex");
            for (Object j : values_df) {
                if (j instanceof String) {
                    String str = (String) j;
                    if (str.equals ("female"))
                        Values.add (1);
                    else
                        Values.add (0);
                }

            }
            df1 = df1.add("gender",Values);
            df1 = df1.retain("pclass","survived","name","age","gender","fare","embarked");
            //printing the dataframe (table of titanic data)
            System.out.println(df1);
            System.out.println("===============================================================================================================================================");
            //printing the description of the dataframe (the count-mean-srd-max-min)
            System.out.println(df1.describe());
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}

