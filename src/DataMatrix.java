import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DataMatrix {

    private int lines;
    private int columns;


    private int[][] matrix;

    public DataMatrix(String txtFilePath) {
        Reader reader = new Reader(txtFilePath);
        this.matrix = new int [lines][columns];
        reader.fillMatrix();
    }

    @Override
    public String toString() {
        return "DataMatrix{" +
                "lines=" + lines +
                ", columns=" + columns +
                ", matrix=" + matrixToString() +
                '}';
    }

    public String matrixToString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                str.append(matrix[i][j]).append(" ");
            }
            str.append("|||||||+\n");
        }
        return str.toString();
    }

    public class Reader {
        Scanner sc;

        public Reader(String txtFilePath) {
            try {
                sc = new Scanner(new File(txtFilePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert sc != null;
            sc.nextLine();

            lines = sc.nextInt();
            columns = sc.nextInt();

            sc.nextLine();

        }
        private void fillMatrix() {
            for (int i = 0; i < lines; i++) {
                sc.nextInt();
                sc.nextInt();
                for (int j = 0; j < columns; j++) {
                    if (sc.hasNextInt()) {
//                        System.out.println(i+" "+j);
                        matrix[i][j] = sc.nextInt();
                    }
                }
            }
        }

    }
}
