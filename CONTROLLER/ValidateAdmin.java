/* PROJECT_NAME | ROLL_NUMBER | YOUR_NAME
* This class has all the constants (information) about the admin. You can chnage the admin properties like
* name or password or username etc. here.
* Also, There're method to validate the admin login credentials and a method to get admin info.
* This class uses Admin class
*/

package CONTROLLER;

import MODEL.Admin;

public class ValidateAdmin {
    public static final String name = "name";
    public static final String username = "admin";
    public static final String phone = "03000000000";
    public static final String password = "123456";
    public static final String email = "example@gmail.com";

    public boolean validate(Admin admin) {
        // returns true if the credentials match otherwise false
        return admin.getUsername().equals(ValidateAdmin.username) && admin.getPassword().equals(ValidateAdmin.password);
    }

    public String getAdminInfo() {
        String info = "Name:   " + ValidateAdmin.name + "\n" + "username:  " + ValidateAdmin.username + "\n"
                + "email:  " + ValidateAdmin.email + "\n" + "phone:  " + ValidateAdmin.phone;
        return info;
    }
}