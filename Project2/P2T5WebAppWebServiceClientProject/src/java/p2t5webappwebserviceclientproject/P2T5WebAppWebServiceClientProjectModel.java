/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2t5webappwebserviceclientproject;

import edu.cmu.andrew.kmakaew.Studenttable;

/**
 *
 * @author Karinya
 */
public class P2T5WebAppWebServiceClientProjectModel {

    static boolean createStudent(java.lang.Short arg0, java.lang.String arg1, java.lang.Double arg2) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.createStudent(arg0, arg1, arg2);
    }

    static boolean deleteStudent(java.lang.Short arg0) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.deleteStudent(arg0);
    }

    static java.util.List<java.lang.Object> findAllStudentNames() {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.findAllStudentNames();
    }

    static Studenttable readStudent(java.lang.Short arg0) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.readStudent(arg0);
    }

    static boolean updateStudent(java.lang.Short arg0, java.lang.String arg1, java.lang.Double arg2) {
        edu.cmu.andrew.kmakaew.StudentListService_Service service = new edu.cmu.andrew.kmakaew.StudentListService_Service();
        edu.cmu.andrew.kmakaew.StudentListService port = service.getStudentListServicePort();
        return port.updateStudent(arg0, arg1, arg2);
    }

   
}
