/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.falcon.dao;

/**
 *
 * @author hainguyen
 */


import com.mycompany.falcon.connection.DBConnection;
import com.mycompany.falcon.entity.DataShow;
import com.mycompany.falcon.entity.Game;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import java.util.ArrayList;

public class DAO {
    
    private static DAO sSoleInstance;

    private DAO(){

    }  //private constructor.

    public static DAO getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new DAO();
        }

        return sSoleInstance;
    }

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public List<DataShow> getByBreakString(String game_id, String platform, String country,
                                                  String app_version, String type, String breakFilter) {
        List<DataShow> list = new ArrayList<>();
        String query = "SELECT created_date_str ," + breakFilter + ", COUNT(*) as inpression\r\n" +
                "FROM api_ads_log_raw_data\r\n" +
                "WHERE game_id = '" + game_id + "' \r\n" +
                "and platform = '" + platform + "' \r\n" +
                "and country IN (" + country + ")\r\n" +
                "AND app_version IN (" + app_version + ")\r\n" +
        	"AND type IN ("+ type + ")\r\n" +
                "GROUP BY created_date_str, " + breakFilter;
        System.out.println(query);
        try {
            conn = DBConnection.getInstance().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(new DataShow(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public List<Game> getGetAllGame() {
		List<Game> list = new ArrayList<>();
		String query = "SELECT game_id, game_name \r\n" +
				"FROM api_ads_log_raw_data\r\n" +
				"GROUP BY game_id, game_name";
		try {
			conn = DBConnection.getInstance().getConnection();//mo ket noi voi sql
	

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Game(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
		}
		return list;
	}

    public List<String> getAllCountry() {
        List<String> list = new ArrayList<>();
        String query = "SELECT country \r\n" +
                "FROM api_ads_log_raw_data\r\n" +
                "GROUP BY country";
        try {
            conn = DBConnection.getInstance().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
        }
        return list;
    }


    public List<String> getAllPlatform() {
        List<String> list = new ArrayList<>();
        String query = "SELECT platform " +
                "FROM api_ads_log_raw_data " +
                "GROUP BY platform";
        try {
            conn = DBConnection.getInstance().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public List<String> getAllAppVersion() {
        List<String> list = new ArrayList<>();
        String query = "SELECT app_version \n" +
                "FROM api_ads_log_raw_data \n" +
                "GROUP BY app_version;";
        try {
            conn = DBConnection.getInstance().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            
        } 
        return list;
    }

    public List<String> getAllType() {
        List<String> list = new ArrayList<>();
        String query = "SELECT type \r\n" +
                "FROM api_ads_log_raw_data\r\n" +
                "GROUP BY type";
        try {
            conn = DBConnection.getInstance().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
        }
        return list;
    }

}

