package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.beans.Cadastro;
import model.beans.Login;
import model.daos.CadastroDAO;
import view.TelaCadastro;
import view.TelaLogin;
import view.TelaMenu;

public class LoginHandler {

	private CadastroDAO dao; 
	
	private TelaLogin loginView;

	public LoginHandler(TelaLogin view) {
		this.loginView = view;
		this.dao = new CadastroDAO();

		this.loginView.addLoginListener(new LoginListener());
	}

	public Cadastro validLogin(Login loginInfo) {
		Cadastro userFound = dao.getCadastro(loginInfo.getUser());
		
		if (userFound != null 
				&& userFound.getPassword().equals(loginInfo.getPassword())
				&& userFound.getTipoAcesso().equals(loginInfo.getTipoAcesso()))
			return userFound;
		
		return null;
	}
	
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			Component component = (Component) evt.getSource();
			switch (component.getName()) {

			case "LOGIN":
				if(loginView.getUser().isEmpty() || loginView.getPassword().isEmpty()) {
					loginView.displayMessage("Entre com suas credenciais!");
					break;
				}
				
				if(!loginView.isAluno() && !loginView.isProfessor()) {
					loginView.displayMessage("Selecione um tipo de acesso!");
					break;
				}
				
				Login loginInfo = new Login(loginView.getUser(), loginView.getPassword(), loginView.isAluno(), loginView.isProfessor());
				
				Cadastro usrLogado = validLogin(loginInfo);
				if(usrLogado == null) {
					loginView.displayMessage("Usuário e/ou senha inválidos!");
					break;
				}
				
				TelaMenu telaMenu = new TelaMenu();
				new MenuHandler(telaMenu, usrLogado); 
				telaMenu.setVisible(true);
				telaMenu.setLocationRelativeTo(null);
				loginView.dispose();
				break;

			case "CAD":
				TelaCadastro telaCadastro = new TelaCadastro(loginView, true);
				new CadastroHandler(telaCadastro);
				telaCadastro.setLocationRelativeTo(loginView);
				telaCadastro.setVisible(true);
				break;

			case "RESET":

			}
		}
	}
}
