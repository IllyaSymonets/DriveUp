package softserve.academy.converter;

import org.springframework.stereotype.Service;
import softserve.academy.domain.Order;
import softserve.academy.request.OrderDetailsToView;

@Service
public class OrderConverter {

    public OrderDetailsToView toOrderDetailsToView(Order order) {
        OrderDetailsToView orderDetails = new OrderDetailsToView(
                order.getOrderNumber(), order.getDate());
        return orderDetails;
    }
}
