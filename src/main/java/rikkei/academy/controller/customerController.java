package rikkei.academy.controller;

import rikkei.academy.model.Customer;
import rikkei.academy.service.CustomerServiceIMPL;
import rikkei.academy.service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/customer")
public class customerController extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceIMPL();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "GETALL":
                showListCustomer(request, response);
                break;
            case "DETAIL":
                detailCustomer(request, response);
                break;
            case "CREATE":
                showFormCreateCustomer(request, response);
                break;
            case "EDIT":
                showFormEditCustomer(request, response);
                break;
            case "DELETE-REQUEST":
                showDeleteForm(request, response);
                break;
            case "DELETE-CONFIRM":
                deleteCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action doPost >>>>>>>>>>" + action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "CREATE":
                createCustomer(request, response);
                break;
            case "EDIT":
                updateCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
        }

    }


    void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> listCustomer = customerService.findAll();
        request.setAttribute("listCustomer", listCustomer);
        String message = request.getParameter("message");
        String displayMessage = null;
        if (message == null) {
            displayMessage = "";
        }else if (message.toLowerCase().equals("ok")){
            displayMessage = "Delete Successfully!";
        }
        System.out.println("displayMessage===>"+displayMessage);
        request.setAttribute("message", displayMessage);



        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/showListCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void detailCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idDetail = Integer.parseInt(request.getParameter("id"));
        Customer customerDetail = customerService.findById(idDetail);
        request.setAttribute("customerDetail", customerDetail);
        System.out.println("customerDetail>>>>>>>>>>" + customerDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/detailCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void showFormCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = customerService.findAll().get(customerService.findAll().size() - 1).getId() + 1;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        //
        System.out.println("name----->" + name);
        System.out.println("email----->" + email);
        String validate = "";
        if (name == "" || email == "") {
            validate = "Create failed!";
        } else {
            validate = "Create success!";
            customerService.save(customer);
        }
        request.setAttribute("validate", validate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerEdit = customerService.findById(id);
        request.setAttribute("customerEdit", customerEdit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/editCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerUpdate = customerService.findById(id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String validate = "";
        if (name == customerUpdate.getName() && email == customerUpdate.getEmail()) {
            validate = "Customer is existed !";
            updateCustomer(request, response);
        } else if (name == "") {
            validate = "Name can not blank!";
        } else if (email == "") {
            validate = "Email can not blank!";
        } else {
            validate = "Update success !";
            Customer customer = new Customer(id, name, email, address);
            customerService.save(customer);
        }
        request.setAttribute("validate", validate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/editCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (
                ServletException e) {
            throw new RuntimeException(e);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", idDelete);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/deleteConfirm.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        customerService.deleteById(idDelete);
        try {
            response.sendRedirect("customer?action=GETALL&message=OK");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}