package Demo.view;

import Demo.controller.UserManagement;
import Demo.model.User;

import java.util.Scanner;

public class LoginMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static UserManagement userManagement = new UserManagement();

    public void run() {
        int choice;
        do {
            MenuUser();
            System.out.println("Mời nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    userManagement.showAll();
                    break;
                }
                case 2: {
                    userManagement.addNew(addNewUser());
                    break;
                }
                case 3: {
                    updateUser();
                    break;
                }
                case 4: {
                    deleteUser();
                    break;
                }
            }
        } while (choice != 0);
    }

    private void deleteUser() {
        System.out.println("nhập id muốn xóa");
        String id = scanner.nextLine();
        int index = userManagement.searchId(id);
        userManagement.deleteById(index);
    }

    private void updateUser() {
        System.out.println("nhập id muốn sửa");
        String id = scanner.nextLine();
        int index = userManagement.searchId(id);
        if (index != -1) {
            User user = addNewUser();
            userManagement.updateById(index, user);
        }else {
            System.out.println("không tìm thấy id");
        }

    }

    private  User addNewUser() {
        System.out.println("nhập id người dùng");
        String id = scanner.nextLine();
        System.out.println("nhập tên người dùng");
        String nameUser = scanner.nextLine();
        System.out.println("nhập password");
        String passWord = scanner.nextLine();
        System.out.println("nhập role");
        String role = scanner.nextLine();
        User user = new User(id, nameUser, passWord, role);
        return user;
    }

    private void MenuUser() {
        System.out.println("Menu");
        System.out.println("1.show all");
        System.out.println("2.thêm");
        System.out.println("3.sửa");
        System.out.println("4.xóa");
        System.out.println("0.exit");
    }
}
