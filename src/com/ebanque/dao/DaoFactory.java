package com.ebanque.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * La DAO Factory (DaoFactory.java) permet d'initialiser le DAO en chargeant 
 * notamment les drivers nécessaires(ici un driver JDBC MySQL) et se connecte à 
 * la base de données. La Factory peut
 *  fournir plusieurs DAO (ici, il n'y en a qu'un seul, UtilisateurDao,
 *    qui correspond à une table de la base).
 * 
 */
public class DaoFactory {
	private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/banque", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }

}
