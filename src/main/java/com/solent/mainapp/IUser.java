/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.solent.mainapp;

/**
 *
 * @author chathurikagoonawardane
 */
//encourage Abstraction promotes Polymorphsm (multiple class can implements the interface differently, provide flexibility
public interface IUser {
    
     //Login method
    User Login (String email, String password); // accept the email and password and returns the User object 
        
    
    //register methiod 
    
    User Register(User user);// accsept the User object and returns the User object 
    // above are just methods they have no body (blueprints)
    
}
