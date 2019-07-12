package org.hqf.tutorials.java.thread.demo.domain;

import lombok.Data;

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
public class OrderItemInfo {
    private Long orderItemId;

    private Long orderId;

    /**
     * SKU
     */
    private String sku;

    /**
     * 购买数量
     */
    private Integer buyQty;

}
