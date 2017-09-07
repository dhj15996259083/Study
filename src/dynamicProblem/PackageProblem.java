package dynamicProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 *
 * 有编号分别为a,b,c,d,e的五本书，它们的重量分别是2,2,6,5,4，
 * 它们的价值分别是6,3,5,4,6，现在给你个承重为10的背包，如何让背包里装入的物品具有最大的价值总和？
 */
public class PackageProblem {
    class Book {
        String a;
        int weight;
        int value;

        public Book(String a, int weight, int value) {
            this.a = a;
            this.weight = weight;
            this.value = value;
        }
    }


    Book[] books = new Book[]{
            new Book("a", 2, 6)
            ,new Book("b",2,3)
            ,new Book("c",6,5)
            ,new Book("d",5,4)
            ,new Book("e",4,6)
    };

    public static void main(String[] args) {

    }


}
