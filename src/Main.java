import com.stschool.ecommerce.ui.CustomerUI;
import com.stschool.ecommerce.ui.MainMenu;
import com.stschool.ecommerce.util.CsvUtil;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws IOException {
    CustomerUI customerUI = new CustomerUI();
//    customerUI.loginForm();
//    customerUI.registerForm();
    MainMenu.mainMenu();
   // CsvUtil.readCustomersFromCsv();   //name,email,password,phone,age,isActive,membership
}
