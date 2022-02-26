package simbot.xiaoU.filter;

import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.filter.FilterData;
import love.forte.simbot.filter.ListenerFilter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: Tisox
 * @date: 2021/12/31 13:29
 * @description:
 * @blog:www.waer.ltd
 */
@Beans
@Component
public class MyFilter implements ListenerFilter {

    @Override
    public boolean test(@NotNull FilterData data) {
        String code = data.getMsgGet().getText();
        System.out.println("自定义过滤器的值："+code);
        return true;
    }
}
