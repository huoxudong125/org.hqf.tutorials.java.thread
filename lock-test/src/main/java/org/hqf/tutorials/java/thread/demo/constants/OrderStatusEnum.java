package org.hqf.tutorials.java.thread.demo.constants;

import lombok.Getter;

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
@Getter
public enum OrderStatusEnum {

    /**
     * 新建
     */
    NEW,

    /**
     * 库存
     */
    STOCK,
    /**
     * 已支付
     */
    PAID,

    /**
     * 已取消
     */
    CANCELED,

    /**
     * 已发货
     */
    DELIVERED,

    /**
     * 拒收
     */
    REJECT;
}
