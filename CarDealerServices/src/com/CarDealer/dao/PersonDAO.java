package com.CarDealer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.CarDealer.dbConnect.DBConnection;


public class PersonDAO {
	
	
	
	public ArrayList<PersonDTO> getPersonList(){
		ArrayList<PersonDTO> listOutDTO = new ArrayList<>();
		DBConnection conn = new DBConnection();
		
		try {
			PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM PERSON;");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				listOutDTO.add(new PersonDTO(resultSet.getInt("idPerson"), resultSet.getString("PersonName"), resultSet.getString("PersonSurname")));
			}
			resultSet.close();
			statement.close();
			conn.desconectar();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listOutDTO;
	}
	
}
