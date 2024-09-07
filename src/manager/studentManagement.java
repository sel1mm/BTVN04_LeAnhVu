package manager;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class studentManagement {
    private static ArrayList<Student> listStudent = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void addStudent(){
        System.out.print("Nhap ten sinh vien: ");
        String name = sc.nextLine();
        System.out.print("Nhap id sinh vien: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap gpa sinh vien: ");
        double gpa=Double.parseDouble(sc.nextLine());
        Student student = new Student(name, id, gpa);
        listStudent.add(student);
    }

    public void editStudent(){
        System.out.print("Nhap id Student can sua: ");
        int id = Integer.parseInt(sc.nextLine());
        for(Student student : listStudent){
            if(student.getId() == id){
                System.out.print("Nhap ten Student moi: ");
                String name = sc.nextLine();
                System.out.print("Nhap gpa Student moi: ");
                double gpa = Double.parseDouble(sc.nextLine());
                student.setName(name);
                student.setGpa(gpa);
                System.out.println("Thong tin Student da duoc cap nhat!");
                return;
            }
        }
        System.out.println("Khong thay hoc sinh!");
    }

    public void deleteStudentById(){
        System.out.print("Nhap id Student can xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        for(Student student : listStudent){
            if(student.getId() == id){
                listStudent.remove(student);
                System.out.println("Da xoa Student thanh cong!");
                return;
            }
        }
        System.out.println("Khong thay hoc sinh!");
    }

    public void searchStudentById(){
        System.out.print("Nhap id Student can tim: ");
        int id = Integer.parseInt(sc.nextLine());
        for(Student student : listStudent){
            if(student.getId() == id){
                System.out.println("Da tim thay Student: " +student);
                return;
            }
        }
        System.out.println("Khong thay hoc sinh!");
    }

    public void printListStudent(){
        if(listStudent.isEmpty()){
            System.out.println("Danh sach trong!");
        }
        for(Student student : listStudent){
            System.out.println(student);
        }
    }

    public void printMenu(){
        System.out.println("StudentManagement System");
        System.out.println("1. Add Student");
        System.out.println("2. Edit Student");
        System.out.println("3. Delete Student by id");
        System.out.println("4. Search Student by id");
        System.out.println("5. Sort Student by gpa");
        System.out.println("6. Print list Student");
        System.out.println("7. Exit");
    }

    public static void main(String[] args) {
        studentManagement stdMn = new studentManagement();
        int choice;
        do{
            stdMn.printMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    stdMn.addStudent();
                    break;
                case 2:
                    stdMn.editStudent();
                    break;
                case 3:
                    stdMn.deleteStudentById();
                    break;
                case 4:
                    stdMn.searchStudentById();
                    break;
                case 5:
                    System.out.println("Tinh nang khong kha dung!");
                    break;
                case 6:
                    stdMn.printListStudent();
                    break;
            }
        } while(choice != 7);
    }
}

