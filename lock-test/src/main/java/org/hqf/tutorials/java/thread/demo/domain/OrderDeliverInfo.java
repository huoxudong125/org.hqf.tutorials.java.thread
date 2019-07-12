package org.hqf.tutorials.java.thread.demo.domain;

import lombok.Data;
import org.hqf.tutorials.java.thread.demo.constants.OrderDeliverStatusEnum;

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
public class OrderDeliverInfo {
    private Long orderId;

    private OrderDeliverStatusEnum orderDeliverStatus;

    private Long deliverId;

}
