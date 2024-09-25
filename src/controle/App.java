package controle;

import controle.LoginController;
import visao.LoginView;


public class App {
    public static void main(String[] args) {
    	LoginView view = new LoginView();
		@SuppressWarnings("unused")
		LoginController controller = new LoginController();
		view.setVisible(true);
    }
}
