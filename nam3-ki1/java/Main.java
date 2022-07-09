package bai2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int[] arr = new int[20000];
        Arrays.fill(arr , 1);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src/bai2/In.txt"));
            FileWriter fw = new FileWriter("src/bai2/Out.txt");
            String s = null;
            while((s = br.readLine()) != null) {
                s = s.trim();
                s = s.replaceAll("  ", " ");
                s = s.toLowerCase();
                String result[] = s.split(" ");
                String tmp = "";
                tmp += result[result.length - 1];
                for(int i = 0 ; i < result.length - 1; i++) {
                     tmp += String.valueOf(result[i].charAt(0));
                }
                if(!list.contains(tmp)) {
                    list.add(tmp);
                } else {
                    String res = tmp;
                    tmp += String.valueOf(arr[list.indexOf(res)]);
                    arr[list.indexOf(res)] ++;
                }
                    tmp += "@ptit.edu.vn";
                    fw.write(tmp + "\n");
            }
            fw.close();
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
