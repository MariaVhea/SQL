package pepito2b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Pepito2b {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;
     do {
         System.out.println("1. ADD");
         System.out.println("2. VIEW");
         System.out.println("3. UPDATE");
         System.out.println("4. DELETE");
         System.out.println("5. EXIT");
         
         System.out.println("Enter Action: ");
         int action = sc.nextInt();
         Pepito2b student = new Pepito2b();
         switch (action) {
             case 1:
                 student.addStudent();
               break;
             case 2:
                 student.viewStudent();
               break;  
             case 3:
                 student.viewStudent();
                 student.updateStudent();
                 student.viewStudent();
                 break;  
             case 4:
                 student.viewStudent();
                 student.deleteStudent();
                 student.viewStudent();
               break;  
             case 5:
                 System.out.println("Exiting...");
               break;  
             default:
                 System.out.println("Invalid action. Please try agaiin.");
                 
         }
         System.out.println("Do you want to continue? (yes/no): ");
         response = sc.next();
         } while (response.equalsIgnoreCase("yes"));
         System.out.println("Thank you, See you soonest!");
    }
         public void addStudent() {
              Scanner sc = new Scanner(System.in);
              
              System.out.println("ID: ");
              String fid = sc.next();
              System.out.println("NAME: ");
              String fname = sc.next();
              System.out.println("VIOLATION: ");
              String violation = sc.next();
              System.out.println("ACTIONS TAKEN: ");
              String actions = sc.next();
              System.out.println("STATUS: ");
              String status = sc.next();
              
              String sql = "INSERT INTO tbl_students (s_id, s_name, s_violation, s_actions, s_status) VALUES (?, ?, ?, ?, ?)";
              config conf = new config();
              conf.addRecord(sql, fid, fname, violation, actions, status);
         }
          
          private void viewStudent() {
              
             String qry = "SELECT * FROM tbl_students";
             String[] hdrs = {"ID", "NAME", "VIOLATION", "ACTIONS TAKEN", "STATUS"};
             String[] clmns = {"s_id", "s_name", "s_violation", "s_actions", "s_status"};
             
             config conf = new config();
             conf.viewRecords(qry, hdrs, clmns);
          }
         
         private void updateStudent(){
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter ID to update: ");
             int id = sc.nextInt();
             
              System.out.println("NEW NAME: ");
              String nfname = sc.next();
              System.out.println("NEW VIOLATION: ");
              String nviolation = sc.next();
              System.out.println("NEW ACTIONS TAKEN: ");
              String nactions = sc.next();
              System.out.println("NEW STATUS: ");
              String nstatus = sc.next();
         
         String qry = "UPDATE tbl_students SET s_name = ?, s_violation = ?, s_actions = ?, s_status = ? WHERE s_id = ?";
         
         config conf = new config();
         conf.updateRecord(qry, nfname, nviolation, nactions, nstatus, id);
         }
         private void deleteStudent(){
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter ID to delete: ");
             int id = sc.nextInt();
             
             String qry = "DELETE FROM tbl_students WHERE s_is = ?";
             config conf = new config();
             conf.deleteRecord(qry, id);
             
        }
        
    }
    

