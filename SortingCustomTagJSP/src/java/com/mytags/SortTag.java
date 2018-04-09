package com.mytags;

import java.io.IOException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.*;
public class SortTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        ArrayServlet obj = new ArrayServlet();
        try{
            int temp;
            for(int i=0; i < obj.array.length; i++){
                for (int j = i + 1; j < obj.array.length; j++) {
                    if (obj.array[i] > obj.array[j]) 
                    {
                        temp = obj.array[i];
                        obj.array[i] = obj.array[j];
                        obj.array[j] = temp;
                    }
                }
                out.println(obj.array[i]);
            }
        }catch(Exception e){
        }
    }
}
