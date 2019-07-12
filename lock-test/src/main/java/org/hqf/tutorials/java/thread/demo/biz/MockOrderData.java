package org.hqf.tutorials.java.thread.demo.biz;

import org.hqf.tutorials.java.thread.demo.domain.OrderDeliverInfo;
import org.hqf.tutorials.java.thread.demo.domain.OrderInfo;
import org.hqf.tutorials.java.thread.demo.domain.OrderPayInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/12
 */
public class MockOrderData {

    private static List<OrderInfo> orderInfoList = new ArrayList<>();
    private static List<OrderPayInfo> orderPayInfoList = new ArrayList<>();
    private static List<OrderDeliverInfo> orderDeliverInfoList = new ArrayList();

    static {
        for (int i = 0; i < 10; i++) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderId(Long.valueOf(i));
            orderInfoList.add(orderInfo);
        }

    }

    public static List<OrderInfo> getPaidOrders() {

        return orderInfoList.stream()
                .filter(t -> orderPayInfoList.stream()
                        .anyMatch(a -> a.getOrderId().equals(t.getOrderId())))
                .collect(Collectors.toList());
    }

    public static List<OrderInfo> getDeliveredOrders() {

        return orderInfoList.stream()
                .filter(t -> orderDeliverInfoList.stream()
                        .anyMatch(a -> a.getOrderId().equals(t.getOrderId())))
                .collect(Collectors.toList());
    }


}
