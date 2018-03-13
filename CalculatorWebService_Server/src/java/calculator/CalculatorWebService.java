/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moon
 */
@WebService(serviceName = "CalculatorWebService")
public class CalculatorWebService {

    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        int answer = num1 + num2;
        return answer;
    }
    
    @WebMethod(operationName = "subtract")
    public int subtract(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        int answer = (num1 > num2)? num1 - num2:num2 - num1;
        return answer;
    }
    
    @WebMethod(operationName = "multiply")
    public int multiply(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        int answer = num1 * num2;
        return answer;
    }
    
    @WebMethod(operationName = "divide")
    public float divide(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        float answer = (float)(num1 / num2);
        return answer;
    }
}
