package ltd.order.cloud.newbee.openfegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "newbee-cloud-goods-service", path = "/goods")
public interface NewBeeGoodsDemoService {

    @GetMapping(value = "/{goodsId}")
    String getGoodsDetail(@PathVariable(value = "goodsId") int goodsId);
}