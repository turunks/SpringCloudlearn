package filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyZuulPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; // 指定过滤器类型
    }

    @Override
    public int filterOrder() {
        return 1; // 过滤器顺序，数字越小越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true; // 是否使用该过滤器
    }

    // 过滤器具体执行的操作
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (token==null||token.isEmpty()) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        return null;


    }
}
