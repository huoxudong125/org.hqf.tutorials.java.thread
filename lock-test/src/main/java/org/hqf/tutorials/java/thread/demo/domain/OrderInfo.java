package org.hqf.tutorials.java.thread.demo.domain;

import lombok.Data;
import org.hqf.tutorials.java.thread.demo.constants.OrderStatusEnum;

import java.util.List;

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
@Data
public class OrderInfo {

    private Long orderId;

    private Long customerId;

    private String orderName;

    private OrderStatusEnum orderStatus;

    private List<OrderItemInfo> orderItemInfoList;

}
