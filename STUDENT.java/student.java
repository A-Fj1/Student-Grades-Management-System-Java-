import java.util.Scanner; 
import java.io.FileWriter; 
import java.io.IOException; 
public class student{ 
   static class Student { 
       String name; 
       double[] grades = new double[10]; 
       int gradeCount = 0; 
       Student(String name) { 
           this.name = name; 
       } 
       void addGrade(double grade) { 
           if (gradeCount < 10) { 
               grades[gradeCount++] = grade; 
           } 
       } 
       double average() { 
           if (gradeCount == 0) return 0; 
           double sum = 0; 
           for (int i = 0; i < gradeCount; i++) sum += grades[i]; 
           return sum / gradeCount; 
       } 
       String getResult() { 
           return name + " - Average Grade: " + average(); 
       } 
   } 
   public static void main(String[] args) throws IOException { 
       Scanner scanner = new Scanner(System.in); 
       System.out.print("How many students? "); 
       int total = scanner.nextInt(); scanner.nextLine(); 
       Student[] students = new Student[total]; 
       for (int i = 0; i < total; i++) { 
           System.out.print("Student name: "); 
           Student s = new Student(scanner.nextLine()); 
           System.out.println("Enter grades (negative to stop):"); 
           for (int j = 0; j < 10; j++) { 
               System.out.print("Grade: "); 
               double g = scanner.nextDouble(); 
               if (g < 0) break; 
               s.addGrade(g); 
           } 
           scanner.nextLine(); 
           students[i] = s; 
       } 
       FileWriter writer = new FileWriter("student_grades.txt"); 
       System.out.println("--- Student Averages ---"); 
       for (Student s : students) { 
           String result = s.getResult(); 
           System.out.println(result); 
           writer.write(result + " "); 
       } 
       writer.close(); 
       System.out.println("Results saved to 'student_grades.txt'"); 
    }
}
