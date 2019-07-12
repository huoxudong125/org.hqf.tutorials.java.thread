package org.hqf.tutorials.java.thread.demo.domain;

import lombok.Data;
import org.hqf.tutorials.java.thread.demo.constants.OrderPayStatusEnum;

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
public class OrderPayInfo {
    private Long orderId;
    private OrderPayStatusEnum orderPayStatus;
}
