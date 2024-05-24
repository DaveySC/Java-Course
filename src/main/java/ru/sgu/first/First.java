package main.java.ru.sgu.first;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);


        String firstDateStr =  scanner.nextLine();
        String secondDateStr = scanner.nextLine();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd");
        Date first = simpleDateFormat.parse(firstDateStr);
        Date second = simpleDateFormat.parse(secondDateStr);

        long milliseconds = Math.abs(first.getTime() - second.getTime());

        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        System.out.println("Разница в днях :" + days);
    }



}
