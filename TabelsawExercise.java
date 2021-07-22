package jupai.dataprep;


import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TabelsawExercise {
    public static void main(String[] args) {

        try {
            Table titanicData = Table.read ().csv ("src/main/resources/data/titanic.csv");
            List<Integer> Values = new ArrayList<>();
            Column values_df = titanicData.column("sex");
            for (Object j : values_df) {
                if (j instanceof String) {
                    String str = (String) j;
                    if (str.equals ("female"))
                        Values.add (1);
                    else
                        Values.add (0);
                }

            }
            Integer[] replaceGender = new Integer[Values.size()];
            replaceGender = Values.toArray(replaceGender);
            titanicData.replaceColumn("sex",IntColumn.create("gender",replaceGender));
            //printing the data set
            System.out.println(titanicData.retainColumns("pclass","survived","name","age","gender","fare","embarked"));
            System.out.println("===============================================================================================================================================");
            //printing the data set summary
            System.out.println(titanicData.retainColumns("pclass","survived","name","age","gender","fare","embarked").summary());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}