/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caly.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author HP
 */
@ManagedBean
@RequestScoped
public class category {
    
    private String category_name;
    private String sl_no;
    
    
    public void setS1_no(String sl_no){
        this.sl_no=sl_no;
    }
    
   public String getSl_no(){
       return sl_no;
   }

    public String getCategory_name() {
        return category_name;
    }
    
    public String edit_category() throws SQLException{
        FacesContext fc =FacesContext.getCurrentInstance();
        Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
        String field_sl_no=params.get("action");
        
        try{
           DB_CONNECTION obj_DB_connection=new DB_CONNECTION();
           Connection connection=obj_DB_connection.get_connection();
         
         Statement st=connection.createStatement();
         
         ResultSet rs=st.executeQuery("select * from categories where sl_no"+field_sl_no);
         Category obj_Category=new Category();
         
         rs.next();
         
        }
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
    
    public ArrayList<Category>getGet_all_category(){
        ArrayList<Category> list_of_categories=new ArrayList<Category>();
        try{
            
         Connection connection=null;
         DB_CONNECTION obj_DB_connection=new DB_CONNECTION();
         connection =obj_DB_connection.get_connection();
         
         Statement st=connection.createStatement();
         
        
         ResultSet rs=st.executeQuery("select * from categories");
         while(rs.next()){
             category obj_category=new category();
             
             obj_category.setCategory_name(rs.getString("category_name"));
             obj_category.setS1_no("sl no");
             
            //  list_of_categories.add(obj_category);
         }
        }catch(Exception e){
            
        }
        return list_of_categories;
    }
    
     public void add_category(){
        
        try{
            
         Connection connection=null;
         DB_CONNECTION obj_DB_connection=new DB_CONNECTION();
         connection =obj_DB_connection.get_connection();
         
        
         PreparedStatement ps=connection.prepareStatement("insert into categories(category_name) value('"+category_name+"')");
        ps.executeUpdate();
        
        }catch(Exception e){
            
        }
    }
    public category() {    }

    
}
