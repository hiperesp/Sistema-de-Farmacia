package view.util;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

public interface InterfaceConstants {
	public static final int TELA = 0x20;
	public static final int TELA_CLIENTES = TELA+1;
	public static final int TELA_VENDAS = TELA+2;
	public static final int TELA_ESTOQUE= TELA+3;
	public static final int TELA_FUNCIONARIOS = TELA+4;
	public static final int TELA_FORNECEDORES = TELA+5;
	public static final int TELA_PRODUTOS = TELA+6;
	public static final int TELA_LOGIN = TELA+7;
	public static final int FEATURES = 0x80;
	public static final int AUMENTAR_TELA = FEATURES+1;
	public static final int LOGOUT = FEATURES+2;
	public static final int SEPARADOR = 0xffffff;
	public static LookAndFeelInfo[] getThemes() {
		return UIManager.getInstalledLookAndFeels();
	}
	public static String getTheme() {
		return UIManager.getLookAndFeel().getClass().getName();
	}
	public static void setTheme(String theme) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(theme);
	}
}