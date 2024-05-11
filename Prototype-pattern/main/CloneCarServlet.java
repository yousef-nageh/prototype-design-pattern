public class CloneCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the existing car object from the session
        Car existingCar = (Car) request.getSession().getAttribute("existingCar");

        // Clone the existing car object
        Car clonedCar = null;
        try {
            clonedCar = (Car) existingCar.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Set the cloned car object as a request attribute
        request.setAttribute("clonedCar", clonedCar);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("cloneCar.jsp");
        dispatcher.forward(request, response);
    }
}

