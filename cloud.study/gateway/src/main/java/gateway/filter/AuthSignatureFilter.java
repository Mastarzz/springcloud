package gateway.filter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSONObject;

import common.web.CommonResult;
import reactor.core.publisher.Mono;

/**
 * 调用鉴权
 */
@Component
public class AuthSignatureFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
          //不合法
            ServerHttpResponse response = exchange.getResponse();
            //设置headers
            HttpHeaders httpHeaders = response.getHeaders();
            httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
            httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
            //设置body
            CommonResult commonResult = new CommonResult();
            commonResult.setStatus(110);
            commonResult.setMessage("未登录或登录超时");
            DataBuffer bodyDataBuffer = response.bufferFactory().wrap(JSONObject.toJSONString(commonResult).getBytes());
            return response.writeWith(Mono.just(bodyDataBuffer));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }
}