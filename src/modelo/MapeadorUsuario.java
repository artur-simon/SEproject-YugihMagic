package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.rowset.CachedRowSet;

public class MapeadorUsuario {

	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	public static String url = "jdbc:postgresql://localhost/yugiMagic";
	public static String user = "user";
	public static String password = "123";
	private static Map<String, UsuarioFinal> cache = new HashMap<String, UsuarioFinal>();

	public static UsuarioFinal get(String login) {
		UsuarioFinal us = cache.get(login);
		if (us == null) {
			try {
				String state = "SELECT * FROM Usuario "
						.concat("WHERE LOGIN = ?");
				con = DriverManager.getConnection(url, user, password);
				pst = con.prepareStatement(state);
				pst.setString(1, login);
				rs = pst.executeQuery();

				while (rs.next()) {
					String senha = rs.getString("SENHA");
					UsuarioFinal a = new UsuarioFinal(login, senha);
					cache.put(login, a);
					return a;
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(MapeadorUsuario.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);

			} finally {

				try {
					if (rs != null) {
						rs.close();
					}
					if (pst != null) {
						pst.close();
					}
					if (con != null) {
						con.close();
					}

				} catch (SQLException ex) {
					Logger lgr = Logger.getLogger(MapeadorUsuario.class
							.getName());
					lgr.log(Level.WARNING, ex.getMessage(), ex);
				}
			}

		}

		return us;
	}

	public static void put(UsuarioFinal usuario) throws SQLException {
		con = DriverManager.getConnection(url, user, password);
		if (MapeadorUsuario.get(usuario.getLogin()) != null) {

			pst = con.prepareStatement("UPDATE USUARIO SET "
					+ "SENHA=?,IP ? WHERE LOGIN=?");
			try {

				pst.setString(1, usuario.getSenha());
				pst.setInt(2, usuario.ipAtual);
				pst.setString(3, usuario.getLogin());
				int updtCnt = pst.executeUpdate();
				if (updtCnt == 0)
					throw new SQLException("Nome inexistente!");
			} finally {
				pst.close();
			}
		} else {
			pst = con.prepareStatement("INSERT INTO PESSOA (NOME,LOGIN,IP) "
					+ "VALUES (?,?,?)");
			try {
				pst.setString(1, usuario.getLogin());
				pst.setString(2, usuario.getSenha());
				pst.setInt(3, usuario.ipAtual);
				pst.execute();
			} finally {
				pst.close();
			}
		}
		cache.put(usuario.getLogin(), usuario);
	}

	public static void putTeste(UsuarioFinal usuario) {
		UsuarioFinal a = MapeadorUsuario.get(usuario.getLogin());
		if (a == null) {
			try {
				con = DriverManager.getConnection(url, user, password);
				String stm = "INSERT INTO Usuario(login,senha, ip) VALUES(?, ?, ?)";
				pst = con.prepareStatement(stm);
				pst.setString(1, usuario.getLogin());
				pst.setString(2, usuario.getSenha());
				pst.setString(3, usuario.ipAtual + "");
				pst.executeUpdate();
				cache.put(usuario.getLogin(), usuario);
			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(MapeadorUsuario.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);

			} finally {

				try {
					if (pst != null) {
						pst.close();
					}
					if (con != null) {
						con.close();
					}

				} catch (SQLException ex) {
					Logger lgr = Logger.getLogger(MapeadorUsuario.class
							.getName());
					lgr.log(Level.SEVERE, ex.getMessage(), ex);
				}
			}
		}
	}
	public static void alterUsuario(Usuario usuario){
		
	}
	public void limpaCache() {
		this.cache.clear();
	}
}
