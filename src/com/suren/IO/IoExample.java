package com.suren.IO;

import com.suren.model.Employee;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Surendirababu Janarthanan on 6/20/2017.
 */
public class IoExample {

    public static void main(String a[])
    {
        try {
            //Write to file
            File file =  new File("I:\\babu\\workspace\\JavaNIO\\src\\resources\\test.txt");
            FileOutputStream fout = new FileOutputStream(file);
            Employee emp = Employee.EmployeeBuilder
                                    .anEmployee()
                                    .withEmpId(1)
                                    .withEmpDob(new Date())
                                    .withEmpSalary(BigDecimal.valueOf(10000))
                                    .withEmpName("suren").build();

            ObjectOutputStream objStream = new ObjectOutputStream(fout);
            objStream.writeObject(emp);

            //Read From File
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream objIn =  new ObjectInputStream(fin);
            Employee empObjFromFile = (Employee)objIn.readObject();

            System.out.println(empObjFromFile.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
