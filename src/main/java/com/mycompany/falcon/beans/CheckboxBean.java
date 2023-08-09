/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.falcon.beans;

import com.mycompany.falcon.dao.DAO;
import com.mycompany.falcon.entity.DataShow;
import com.mycompany.falcon.entity.Game;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author hainguyen
 * */
@ManagedBean
@ViewScoped
public class CheckboxBean {
 
    private List<String> game_id;
    private List<String> platforms;
    private List<String> countries;
    private List<String> appVersions;
    private List<String> types;
    private String breakFilter;
    private List<Game> listGame;
    
    private List<String> selectedCountries;
    private List<String> selectedAppVersions;
    private List<String> selectedTypes;
    private String selectedBreakFilter;
    private String selectedGameID;
    private String selectedPlatform;
    
//    private List<DataShow> dataShows;
    
    public void init() {
        
        DAO dao = DAO.getInstance();
        listGame = dao.getGetAllGame();
        platforms = dao.getAllPlatform();
        countries = dao.getAllCountry();
        types = dao.getAllType();
        appVersions = dao.getAllAppVersion();
        
        
        selectedGameID = listGame.get(0).getGame_id();
        selectedPlatform = platforms.get(0);
        selectedCountries = new ArrayList<>(countries);
        selectedAppVersions = new ArrayList<>(appVersions);
        selectedTypes = new ArrayList<>(types);
//        selectedAppVersions = (String[]) appVersions.toArray();
//        selectedTypes = (String[]) types.toArray();
        selectedBreakFilter = "game_name";
        
//        getDataShowByFIlter();
       
         
    }
    
    public List<String> getGetAllBreak() {
		List<String> list = new ArrayList<>();
		list.add("game_name");
		list.add("platform");
		list.add("account_id");
		list.add("app_version");
		list.add("level");
		list.add("device_id");
		list.add("created_date");
		list.add("session_id");
		list.add("type");
		list.add("ad_where");
		list.add("create_date_str");
		list.add("country");
		list.add("sdk_version");
		list.add("retention_day");
		list.add("time_id");
		list.add("install_day");
		list.add("api_id");


		return list;
	}
    
    public List<DataShow> getDataShowByFIlter() {
        List<DataShow> list = new ArrayList<>();
        DAO dao = DAO.getInstance();
        System.out.println(selectedGameID);
        System.out.println(selectedPlatform);
        System.out.println(arrayToString(selectedCountries));
        System.out.println(arrayToString(selectedAppVersions));
        System.out.println(arrayToString(selectedTypes));
        System.out.println(selectedBreakFilter);
        list= dao.getByBreakString(selectedGameID, selectedPlatform, arrayToString(selectedCountries),
                arrayToString(selectedAppVersions), arrayToString(selectedTypes), selectedBreakFilter);
        
        System.out.println(list.toString());
        return list;
    }
    
    private String arrayToString(List<String> arr) {
    StringBuilder sb = new StringBuilder();
   
    for (int i = 0; i < arr.size(); i++) {
        
        sb.append("'").append(arr.get(i)).append("'");

        if (i < arr.size() - 1) {
            sb.append(",");
        }
    }
    
    return sb.toString();
}

    

    public List<Game> getListGame() {
        return listGame;
    }

    public void setListGame(List<Game> listGame) {
        this.listGame = listGame;
    }

    
    
    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(List<String> appVersions) {
        this.appVersions = appVersions;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getBreakFilter() {
        return breakFilter;
    }

    public void setBreakFilter(String breakFilter) {
        this.breakFilter = breakFilter;
    }

    public List<String> getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(List<String> selectedCountries) {
        this.selectedCountries = selectedCountries;
    }

    public List<String> getSelectedAppVersions() {
        return selectedAppVersions;
    }

    public void setSelectedAppVersions(List<String> selectedAppVersions) {
        this.selectedAppVersions = selectedAppVersions;
    }

    public List<String> getSelectedTypes() {
        return selectedTypes;
    }

    public void setSelectedTypes(List<String> selectedTypes) {
        this.selectedTypes = selectedTypes;
    }

    

    public String getSelectedBreakFilter() {
        return selectedBreakFilter;
    }

    public void setSelectedBreakFilter(String selectedBreakFilter) {
        this.selectedBreakFilter = selectedBreakFilter;
    }

    public String getSelectedGameID() {
        return selectedGameID;
    }

    public void setSelectedGameID(String selectedGameID) {
        this.selectedGameID = selectedGameID;
    }

    public String getSelectedPlatform() {
        return selectedPlatform;
    }

    public void setSelectedPlatform(String selectedPlatform) {
        this.selectedPlatform = selectedPlatform;
    }

    

    public List<String> getGame_id() {
        return game_id;
    }

    public void setGame_id(List<String> game_id) {
        this.game_id = game_id;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

   
    
 
}
