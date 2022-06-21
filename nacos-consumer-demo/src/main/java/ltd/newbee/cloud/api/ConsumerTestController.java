package ltd.newbee.cloud.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerTestController {
    private final String SERVICE_URL = "http://newbee-cloud-goods-service";

    @Resource
    private RestTemplate restTemplate;
    // 测试方法，暂未通过Nacos调用下级服务
    @GetMapping("/nacosRegTest")
    public String nacosRegTest() {
        return restTemplate.getForObject(SERVICE_URL + "/goodsServiceTest", String.class);
    }
}