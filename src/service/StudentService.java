package service;

import fileCSV.FILECSV;
import model.Student;
import view.StudentView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    Scanner sc = new Scanner(System.in);
    String PATH = "data/danhsach.csv";

    public List<Student> findAll() {
        List<Student> products = new ArrayList<>();
        List<String> records = FILECSV.read(PATH);
        for (String record : records) {
            products.add(Student.parse(record));
        }
        return products;
    }

    public void add() {
        List<Student> students = findAll();
        try {
            System.out.print("Nhập mã số sinh viên : ");
            long maSinhVien = Long.parseLong(sc.nextLine());
            do {
                if (maSinhVien <= 0) {
                    System.out.println("Mã sinh viên không thể âm và có chữ , xin nhập lại");
                    System.out.print("Nhập lại : ");
                    maSinhVien = Integer.parseInt(sc.nextLine());
                }
            } while (maSinhVien <= 0);

            System.out.print("Nhập họ tên sinh viên : ");
            String hoTen = sc.nextLine();
            do {
                if (hoTen.trim().isEmpty()) {
                    System.out.println("Tên không được bỏ trống");
                    System.out.print("Nhập lại : ");
                    hoTen = sc.nextLine();
                }
            } while (hoTen.trim().isEmpty());

            System.out.print("Nhập tuổi : ");
            int age = Integer.parseInt(sc.nextLine());
            do {
                if (age <= 0) {
                    System.out.println("Tuổi không thể < 0 và không có chữ, xin nhập lại");
                    System.out.print("Nhập lại : ");
                    age = Integer.parseInt(sc.nextLine());
                }
            } while (age <= 0);

            System.out.print("Nhập giới tính : ");
            String gioiTinh = sc.nextLine();
            do {
                if (gioiTinh.trim().isEmpty()) {
                    System.out.println("Giới tính không được bỏ trống, xin nhập lại");
                    System.out.print("Nhập lại : ");
                    gioiTinh = sc.nextLine();
                }
            } while (gioiTinh.trim().isEmpty());

            System.out.print("Nhập địa chỉ : ");
            String diaChi = sc.nextLine();
            do {
                if (diaChi.trim().isEmpty()) {
                    System.out.println("Địa chỉ không được bỏ trống");
                    System.out.print("Nhập lại : ");
                    diaChi = sc.nextLine();
                }
            } while (diaChi.trim().isEmpty());


            System.out.print("Nhập điểm trung bình : ");
            double diemTB = Double.parseDouble(sc.nextLine());
            do {
                if (diemTB <= 0) {
                    System.out.println("Điểm Trung Bình không thể < 0, xin nhập lại");
                    System.out.print("Nhập lại : ");
                    diemTB = Integer.parseInt(sc.nextLine());
                }
            } while (diemTB <= 0);


            Student student = new Student(maSinhVien, hoTen, age, gioiTinh, diaChi, diemTB);
            students.add(student);
            FILECSV.write(PATH, students);
            System.out.println("Thêm thành công !!! ");
        } catch (Exception e) {
            System.out.println("Nhập sai xin nhập lại từ đầu");
            add();
        }
        ;
    }

    public void update() {
        List<Student> students = findAll();
        showStudent();
        System.out.print("Nhập mã sinh viên cần thay đổi : ");
        long maSinhVien = Long.parseLong(sc.nextLine());
        for (Student student : students) {
            try {


                if (student.getMaSinhVien() == maSinhVien) {
                    System.out.print("Sửa mã sinh viên : ");
                    int masinhvien = Integer.parseInt(sc.nextLine());
                    do {
                        if (maSinhVien <= 0) {
                            System.out.println("Mã sinh viên không thể âm và có chữ , xin nhập lại");
                            System.out.print("Nhập lại : ");
                            maSinhVien = Integer.parseInt(sc.nextLine());
                        }
                    } while (maSinhVien <= 0);
                    student.setMaSinhVien(masinhvien);

                    System.out.print("Sửa họ tên : ");
                    String hoTen = sc.nextLine();
                    do {
                        if (hoTen.trim().isEmpty()) {
                            System.out.println("Tên không được bỏ trống");
                            System.out.print("Nhập lại : ");
                            hoTen = sc.nextLine();
                        }
                    } while (hoTen.trim().isEmpty());
                    student.setHoTen(hoTen);

                    System.out.print("Sửa tuổi : ");
                    int age = Integer.parseInt(sc.nextLine());
                    do {
                        if (age <= 0) {
                            System.out.println("Tuổi không thể < 0 và không có chữ, xin nhập lại");
                            System.out.print("Nhập lại : ");
                            age = Integer.parseInt(sc.nextLine());
                        }
                    } while (age <= 0);
                    student.setAge(age);

                    System.out.print("Sửa giới tính : ");
                    String gioiTinh = sc.nextLine();
                    do {
                        if (gioiTinh.trim().isEmpty()) {
                            System.out.println("Giới tính không được bỏ trống, xin nhập lại");
                            System.out.print("Nhập lại : ");
                            gioiTinh = sc.nextLine();
                        }
                    } while (gioiTinh.trim().isEmpty());
                    student.setGioiTinh(gioiTinh);

                    System.out.print("Sửa địa chỉ : ");
                    String diaChi = sc.nextLine();
                    do {
                        if (diaChi.trim().isEmpty()) {
                            System.out.println("Địa chỉ không được bỏ trống");
                            System.out.print("Nhập lại : ");
                            diaChi = sc.nextLine();
                        }
                    } while (diaChi.trim().isEmpty());
                    student.setDiaChi(diaChi);

                    System.out.print("Sửa điểm trung bình : ");
                    double diemTB = Double.parseDouble(sc.nextLine());
                    do {
                        if (diemTB <= 0) {
                            System.out.println("Điểm Trung Bình không thể < 0 và có chữ số, xin nhập lại");
                            System.out.print("Nhập lại : ");
                            diemTB = Integer.parseInt(sc.nextLine());
                        }
                    } while (diemTB <= 0);
                    student.setDiemTB(diemTB);

                    FILECSV.write(PATH, students);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai, xin nhập lại từ đầu");
                update();
            }
        }
        System.out.println("Thay đổi thành công !!! ");
    }

    public void remove() {
        List<Student> students = findAll();
        showStudent();
        System.out.print("Nhập mã sinh viên cần xóa : ");
        int maSinhVien = Integer.parseInt(sc.nextLine());
        for (Student student : students) {
            if (student.getMaSinhVien() == maSinhVien) {
                students.remove(student);
                System.out.println("Nhấn 1 để xóa, 2 để quay lại");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        StudentView studentView = new StudentView();
                        studentView.menuStudent();
                        return;
                }
                System.out.println("Xóa thành công ");
                FILECSV.write(PATH, students);
                break;
            }
        }
    }

    public List<Student> sortASC() {
        List<Student> products = new ArrayList<>(findAll());
        products.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o1.getDiemTB() - o2.getDiemTB();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return products;
    }

    public List<Student> sortDESC() {
        List<Student> products = new ArrayList<>(findAll());
        products.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o2.getDiemTB() - o1.getDiemTB();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return products;
    }

    public void showStudentSort(List<Student> students) {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n ",
                "Mã Sinh Viên",
                "Họ Tên",
                "Tuổi",
                "Giới Tính",
                "Địa Chỉ",
                "Điểm Trung Bình");
        for (Student a : students) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n",
                    a.getMaSinhVien(),
                    a.getHoTen(),
                    a.getAge(),
                    a.getGioiTinh(),
                    a.getDiaChi(),
                    a.getDiemTB());
        }
    }

    public void showStudent() {
        List<Student> students = findAll();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n ",
                "Mã Sinh Viên",
                "Họ Tên",
                "Tuổi",
                "Giới Tính",
                "Địa Chỉ",
                "Điểm Trung Bình");
        for (Student a : students) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n",
                    a.getMaSinhVien(),
                    a.getHoTen(),
                    a.getAge(),
                    a.getGioiTinh(),
                    a.getDiaChi(),
                    a.getDiemTB());
        }
    }

}
