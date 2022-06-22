package view;

import fileCSV.FILECSV;
import model.Student;
import service.StudentService;
import sun.security.krb5.internal.PAData;

import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    StudentService student = new StudentService();


    public void menuDanhSach(){

    }
    public void menuStudent(){

        System.out.println("------------------------------------------------------------");
        System.out.println("------    1. Xem danh sách Sinh Viên         --------------");
        System.out.println("------    2. Thêm mới                         --------------");
        System.out.println("------    3. Cập nhật                         --------------");
        System.out.println("------    4. Xóa                              --------------");
        System.out.println("------    5. Sắp xếp                          --------------");
        System.out.println("------    6. Đọc từ file                      --------------");
        System.out.println("------    7. Ghi từ file                      --------------");
        System.out.println("------    8. Thoát                            ---------------");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Chọn số : ");
        int number;
        do {
            number = Integer.parseInt(sc.nextLine());
            switch (number){
                case 1:
                    student.showStudent();
                    break;
                case 2:
                    student.add();
                    menuStudent();
                    break;
                case 3:
                    student.update();
                    menuStudent();
                    break;
                case 4:
                    student.remove();
                    menuStudent();
                    break;
                case 5:
                    menuSort();
                    break;
                case 6:
                    FILECSV.write("data/students.csv",student.findAll());
                    break;
                case 7:
                    FILECSV.read("data/students.csv");
                    break;
                case 8:
                    System.exit(8);
                    break;

            }
        }while (number != 8);
    }

    public void menuSort(){
        System.out.println("------------------------------------------------------------");
        System.out.println("------    1. Sắp xếp điểm trung bình tăng dần        -------");
        System.out.println("------    2. Sắp xếp điểm trung bình giảm dần        -------");
        System.out.println("------    3. Thoát                                   -------");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Chọn số : ");
        int number;
        do {
            number = Integer.parseInt(sc.nextLine());
            switch (number){
                case 1:
                    student.showStudentSort(student.sortASC());
                    break;
                case 2:
                    student.showStudentSort(student.sortDESC());
                    break;
                case 3:
                    menuStudent();
                    break;
            }
        }while (number != 3);
    }
}
