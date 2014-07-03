package Testes;

import java.sql.SQLException;
import java.util.List;

import modelo.MapeadorUsuario;
import modelo.UsuarioFinal;

public class TesteBD {

	public static void main(String[] args) throws SQLException {

		MapeadorUsuario.putTeste(new UsuarioFinal("Jaspion", "lepolepo"));
	}

}
