package rikkei.academy.service;

import rikkei.academy.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements ICustomerService {
    public static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Nguyen Van A", "nguyenvana@gmail.com", "HN"));
        customerList.add(new Customer(2, "Nguyen Van B", "nguyenvanb@gmail.com", "DN"));
        customerList.add(new Customer(3, "Nguyen Van C", "nguyenvanc@gmail.com", "QN"));
        customerList.add(new Customer(4, "Nguyen Van D", "nguyenvand@gmail.com", "TH"));
        customerList.add(new Customer(5, "Nguyen Van E", "nguyenvane@gmail.com", "HCM"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        //update
        if (findById(customer.getId()) != null) {
            customerList.set(customerList.indexOf(findById(customer.getId())),customer);
            return;
        }
        //add
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        customerList.remove(customerList.indexOf(findById(id)));
    }
}
