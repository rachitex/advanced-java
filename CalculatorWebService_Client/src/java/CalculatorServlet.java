/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculator.CalculatorWebService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author moon
 */
public class CalculatorServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CalculatorWebService_Server/CalculatorWebService.wsdl")
    private CalculatorWebService_Service service;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int num1 = Integer.parseInt(request.getParameter("txtNum1"));
            int num2 = Integer.parseInt(request.getParameter("txtNum2"));
            String operation = request.getParameter("operation");
            
            if(operation.equals("addition")){
                out.println("Addition of "+num1+" and "+num2+" is: "+add(num1, num2));
            }else if(operation.equals("subtraction")){
                out.println("Subtraction of "+num1+" and "+num2+" is: "+subtract(num1, num2));
            }else if(operation.equals("multiplication")){
                out.println("Multiplication of "+num1+" and "+num2+" is: "+multiply(num1, num2));
            }else if(operation.equals("division")){
                out.println("Division of "+num1+" and "+num2+" is: "+divide(num1, num2));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int add(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        calculator.CalculatorWebService port = service.getCalculatorWebServicePort();
        return port.add(num1, num2);
    }

    private float divide(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        calculator.CalculatorWebService port = service.getCalculatorWebServicePort();
        return port.divide(num1, num2);
    }

    private int multiply(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        calculator.CalculatorWebService port = service.getCalculatorWebServicePort();
        return port.multiply(num1, num2);
    }

    private int subtract(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        calculator.CalculatorWebService port = service.getCalculatorWebServicePort();
        return port.subtract(num1, num2);
    }

}
