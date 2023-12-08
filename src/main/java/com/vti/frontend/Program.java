package com.vti.frontend;

import com.vti.utils.Scannerutils;

public class Program {
    public static void main(String[] args) {
        Function function = new Function();
        while (true){
            System.out.println("Mời bạn chọn chức năng: ");
            System.out.println("1. User nhập vào id project, sau đó in ra tất cả các employee trong project đó ");
            System.out.println("2. Lấy ra tất cả Manager của các project");
            System.out.println("3. Login");
            System.out.println("4. Lấy thông tin user theo id");
            System.out.println("5. Xóa theo id");
          System.out.println("6. Thoát chương trình");
            int chose = Scannerutils.inputNumber(1,6);
            switch (chose){
                case 1:
                    function.userListInProject();
                    break;
                case 2:
                    function.getManager();
                    break;
                case 3:
                    function.login();
                    break;
                case 4:
                  function.getUserById();
                  break;
              case 5:
                function.deleteById();
                break;
                case 6:
                    return;
            }
        }
    }
}
