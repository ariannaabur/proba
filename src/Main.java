package com.company;
import java.util.Scanner;

class Ludi {
    String Fam, Name,Pol1;
    int Rost,Pol;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.println("Введите количество людей=> ");
        int n=sc.nextInt();
        Ludi ludi[]=new Ludi[n];
        System.out.println("Введите информацию о людях: ");
        for (int i = 0; i < ludi.length; i++) {
            sc.nextLine();
            ludi[i]=new Ludi();
            System.out.print("Имя "+(i+1)+"-го человека => ");
            ludi[i].Name=sc.nextLine();
            System.out.print("Фамилия "+(i+1)+"-го человека => ");
            ludi[i].Fam=sc.nextLine();
            System.out.print("Рост "+(i+1)+"-го человека =>");
            ludi[i].Rost= (int) sc.nextDouble();
            System.out.print("Пол "+(i+1)+"-го человека: 1-мужчина, 2- женщина =>");
            ludi[i].Pol= (int) sc.nextDouble();
            if (ludi[i].Pol == 1){
                ludi[i].Pol1="Мужчина";
            }
            if (ludi[i].Pol == 2){
                ludi[i].Pol1="Женщина";
            }
        }
        System.out.println("\nХарактеристики людей:");
        for (int i = 0; i < ludi.length; i++) {
            System.out.println(""+ludi[i].Fam+"\t"+ludi[i].Name +"\t"+ludi[i].Rost+"см"+"\t"+ludi[i].Pol1);
        }

        double s=0;
        int m=0;
        for (int i = 0; i < ludi.length; i++)
            if (ludi[i].Pol==1){
                m=m+1;
                s+=ludi[i].Rost;
            }
        double sr=s/m;
        System.out.println("Средний рост мужчин ="+sr);
        double s1=0;
        int zh=0;
        for (int i = 0; i < ludi.length; i++)
            if (ludi[i].Pol==2){
                zh=zh+1;
                s1+=ludi[i].Rost;
            }
        double sr1=s1/zh;
        System.out.println("Средний рост женщин ="+sr1);

        int nommax=0;
        double max=ludi[nommax].Rost;
        for (int i = 0; i < ludi.length; i++)
            if (ludi[i].Pol==1) {
                if (ludi[i].Rost>max) {
                    max = ludi[i].Rost;
                    nommax = i;
                }
            }
        System.out.println("\nСамый высокий мужчина :");
        System.out.println(""+ludi[nommax].Fam+"\t"+ludi[nommax].Name+"\t"+ludi[nommax].Rost+" см");

        for (int i = 0; i < ludi.length-1; i++)
            for (int j = 0; j < ludi.length-1-i; j++)
                if (ludi[j].Rost>ludi[j+1].Rost){
                    Ludi rab=ludi[j]; // rab – рабочая переменная для перестановки
                    ludi[j]=ludi[j+1];
                    ludi[j+1]=rab;
                }
        System.out.println("\nОтсортированный список по площади:");//
        for (int i = 0; i < ludi.length; i++) {
            System.out.println(""+ludi[i].Fam+"\t"+ludi[i].Name +"\t"+ludi[i].Rost+"см"+"\t"+ludi[i].Pol1);
        }
        sc.nextLine();
        System.out.println("Введите фамилию искомых людей=> ");
        String Fam=sc.nextLine();
        int nom=-1;

        for (int i = 0; i < ludi.length; i++)
            if (Fam.equalsIgnoreCase(ludi[i].Fam))
                nom=i;
        if (nom!= -1) {
            System.out.println("Такие люди есть в списке. Это "
                    +ludi[nom].Fam+"\t"+ludi[nom].Name +"\t"+ludi[nom].Rost+"см"+"\t"+ludi[nom].Pol1);
        }else System.out.println("Таких людей в списке нет");

    }
}
