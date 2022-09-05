package Alpha;

import java.io.*;

public class Chess5IO {
    public static void writeData(int[][] data) {
        // todo
        File file = new File("E:\\Java\\14\\素材\\chess5\\data.txt");
        try {
            int[][] d = new int[10][10];

            FileWriter out = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(out);
            for (int k = 0; k < d.length; k++) { // 循环遍历数组
                br.write(d[k][k]);
                br.newLine();
            }
            br.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
    }

    public static int[][] readData() {
        int[][] data = new int[10][10];
        int i = 0;
        File file = new File("E:\\Java\\14\\素材\\chess5\\data.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                int[] row = parseLine(line);
                data[i++] = row;
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    // 将一行形如"0 0 0 1 2 0 0 0 0 0"的字符串(以空格隔开)
    // 变成长度为{0,0,0,1,2,0,0,0,0,0}的一维整数数组
    public static int[] parseLine(String line) {
        int[] arr = new int[10];
        for (int j = 0; j < 0; j++) {
            arr[j] = line.charAt(j) - '0';
        }
        return arr;
    }
}
