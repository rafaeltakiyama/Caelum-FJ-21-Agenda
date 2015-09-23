package br.com.caelum.jdbc.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection con;

	public ContatoDao() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato){
		
		String sql = "insert into contatos " +
					"(nome, email, endereco, dataNascimento)" +
					" values (?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
		
	}
	
	public List<Contato> getLista(){
		
		String sql = "Select * from contatos";
		List<Contato> contatos = new ArrayList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
		
		return contatos;
	}
	
	public Contato getPorId(int id){
		
		String sql = "Select * from contatos where id = ?";
		Contato contato = new Contato();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
					
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
		
		return contato;
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set"
				+ " nome = ?,"
				+ " email = ?,"
				+ " endereco = ?,"
				+ " dataNascimento = ?"
				+ " where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
	}
	
	public void remove(Contato contato){
		
		String sql = "delete from contatos where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
	}
	
	
	private void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
}
