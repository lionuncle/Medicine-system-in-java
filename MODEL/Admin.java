/*PROJECT_NAME | ROLL_NUMBER | YOUR_NAME
This is the model class of Admin which all admin attributes and their getter setter (also known as POJO class in java)
This class does not use any other class
*/
package MODEL;

public class Admin {
    private String name, username, email, password, phone;

    public Admin() {
        name = username = email = password = phone = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}