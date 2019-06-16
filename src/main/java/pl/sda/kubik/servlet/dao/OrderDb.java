package pl.sda.kubik.servlet.dao;

import pl.sda.kubik.servlet.domain.Order;
import pl.sda.kubik.servlet.domain.User;

import java.util.LinkedList;
import java.util.List;

public class OrderDb {
    private static OrderDb instance;
    private final List<Order> allOrders;

    private OrderDb() {
        this.allOrders = new LinkedList<>();
    }

    public static OrderDb getInstance() {
        if (OrderDb.instance == null) {
            OrderDb.instance = new OrderDb();
        }

        return OrderDb.instance;
    }

    public List<Order> getAllOrders() {
        return this.allOrders;
    }

    public List<Order> getOrderForUser(final User user) {
        final List<Order> userOrders = new LinkedList<>();
        for (final Order allOrder : this.allOrders) {
            if (allOrder.getUser().equals(user)) {
                userOrders.add(allOrder);

            }

        }


        return userOrders;

    }
}
