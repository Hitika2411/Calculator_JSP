package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyWebServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String[] jokes = {
        "How do you know a developer is an artist? When their code is a masterpiece... until the deadlines hit.",
        "I asked the database for a date, but it gave me a NULL. Guess I need better queries.",
        "Why did the Python programmer get kicked out of the party? He kept bringing up decorators without context.",
        "I told my computer I needed a break, Now it won\'t stop sending me Kit-Kats.",
        "Why was the developer broke? Because he used up all his cache.",
        "What\'s the object-oriented way to become wealthy? Inheritance.",
        "What\'s a programmer\'s favorite type of music? Algo-rhythm!"
    };

    public MyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String str1 = request.getParameter("num1");
            String str2 = request.getParameter("num2");
            Integer num1 = Integer.parseInt(str1);
            Integer num2 = Integer.parseInt(str2);
            String str3 = request.getParameter("btn1");
            Integer ans = 0;

            // Perform the calculation based on the operation selected
            switch (str3) {
                case "+":
                    ans = num1 + num2;
                    break;
                case "-":
                    ans = num1 - num2;
                    break;
                case "*":
                    ans = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        ans = num1 / num2;
                    } else {
                        ans =Integer.MAX_VALUE;  // Handle division by zero
                    }
                    break;
            }

            // Pick a random joke
            int randomIndex = (int) (Math.random() * jokes.length);
            String randomJoke = jokes[randomIndex];

            // Redirect to the result page with ans and joke as query parameters
            response.sendRedirect("resultPage.jsp?ans=" + ans + "&joke=" + randomJoke);
        } catch (NumberFormatException e) {
            // Handle invalid number format
            response.sendRedirect("resultPage.jsp?ans=Error: Invalid input&joke=" + jokes[0]);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Do Post called");
    }
}
