/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mytags;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArrayServlet extends HttpServlet {
    static int[] array = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String numbers = request.getParameter("txtNum");
            array = Stream.of(numbers.split(" "))
                    .mapToInt(token -> Integer.parseInt(token))
                    .toArray();
            /*for(int i=0; i<array.length; i++){
                 out.println(array[i]);
            }*/
            response.sendRedirect("index.jsp");
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    /*protected int[] getArray(int[] myArray){
            myArray = array;
            return myArray; 
    }*/
}
