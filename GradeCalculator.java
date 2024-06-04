import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int marks[] = new int[5];
        int i;
        float total=0, avg, percentage;
        System.out.println("Enter marks of 5 subjects:");

        for(i=0; i<5; i++) {
            marks[i] = input.nextInt();
            total = total + marks[i];
        }
        input.close();
        
        avg = total/5;
        percentage = (total/500) * 100;

        System.out.println("Total marks: "+total);
        System.out.println("Average marks: "+avg);
        System.out.println("Percentage: "+percentage);

        if(percentage >= 90) {
            System.out.println("Grade: A");
        } else if(percentage >= 80) {
            System.out.println("Grade: B");
        } else if(percentage >= 70) {
            System.out.println("Grade: C");
        } else if(percentage >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}

    