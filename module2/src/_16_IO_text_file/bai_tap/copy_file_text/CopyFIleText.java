package _16_IO_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFIleText {
    public static final String COMMA = ",";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập id đi bạn ê:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("nhập name đi bạn ê:");
        String name = scanner.nextLine();
        Student student = new Student(id, name);
        List<Student> list = new ArrayList<>();
        list.add(student);
        try {
            FileWriter fileWriter = new FileWriter("src/_16_IO_text_file/bai_tap/copy_file_text/B.txt", true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            String line = null;
            for (Student student1 : list) {
                line = student1.getId() + COMMA + student1.getName();
                FileWriter fileWriter1 = new FileWriter("src/_16_IO_text_file/bai_tap/copy_file_text/A.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter1);

                bufferedWriter.write(line);
                bufferedWriter.newLine();

                bufferedWriter.close();
            }

            FileReader fileReader = new FileReader("src/_16_IO_text_file/bai_tap/copy_file_text/A.txt");
            BufferedReader br = new BufferedReader(fileReader);


            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
