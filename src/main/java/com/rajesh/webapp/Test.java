/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp;

import com.heroku.web.entity.repository.RootWordRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dell
 */
public class Test {
     @Autowired
        private static RootWordRepository repository;
    public static void main(String[] args) {
      
        for(long i=0;i<5;i++){
            System.out.println(repository.findById(i).get());
                    
                    
        }
           
    }
}
