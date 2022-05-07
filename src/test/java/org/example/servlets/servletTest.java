package org.example.servlets;

//import junit.framework.TestCase;
//import org.example.dao.DaoFactory;
//import org.example.dao.EmployeeDao;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class servletTest {
//    public class EmployeeServletTest extends TestCase {
//
//        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
//
//        @BeforeEach
//        public void setUp() {
//            // since we're testing with h2, create the tables every time:
//            employeeDao.initTables();
//            employeeDao.fillTables();
//        }
//
//        @Test
//        public void testDoGet() throws IOException {
//            // mock the request/response:
//            HttpServletRequest request = mock(HttpServletRequest.class);
//            HttpServletResponse response = mock(HttpServletResponse.class);
//
//            // since we take in a buffered reader to read the body, we simulate it by putting
//            // mock data in a local file called book.txt, this is simulating what we would put in body of the request
//            FileReader fr = new FileReader("src/test/java/org/example/entity/testEmployee.txt");
//            BufferedReader t = new BufferedReader(fr);
//            // configure the buffered reader:
//            when(request.getReader()).thenReturn(t);
//
//            // set up the print writer:
//            StringWriter stringWriter = new StringWriter();
//            PrintWriter writer = new PrintWriter(stringWriter);
//            when(response.getWriter()).thenReturn(writer);
//
//
//            // create a new book servlet and do the get method:
//            try {
//                new EmployeeServlet().doGet(request, response);
//            } catch(ServletException ex){
//                System.out.println(ex.getLocalizedMessage());
//            }
//
//            // flush the writer, make sure all the output is written:
//            writer.flush();
//            // assert that the result contains all of the proper books:
//            assertTrue(stringWriter.toString().contains("Employee{userid=1, username='name 1', password='password 1'}"));
//
//        }
//
//        @Test
//        public void testDoPost() {
//        }
//    }
//}
