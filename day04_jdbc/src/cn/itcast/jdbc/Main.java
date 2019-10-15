package cn.itcast.jdbc;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:).<script>.欢迎访问baidu. 大家都是996";
        Respanse respanse = new Respanse();
        respanse.str = "respanse";
        FilterChain f = new FilterChain();
        f.add(new HTMLFilter()).add(new SensitiveFilter());
        f.doFilter(request,respanse);
        System.out.println(request.str);
        System.out.println(respanse.str);

    }


}
interface Filter{
    void doFilter(Request request, Respanse respanse, FilterChain chain);
}
class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Respanse respanse, FilterChain chain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "HTMLFilter()";
        chain.doFilter(request, respanse);
        respanse.str += "HTMLFilter()";

    }
}
    class SensitiveFilter implements Filter {

        @Override
        public void doFilter(Request request, Respanse respanse, FilterChain chain) {
            request.str = request.str.replaceAll("996","995")+"SensitiveFilter()";
            chain.doFilter(request,respanse);
            respanse.str = "--SensitiveFilter()";
        }
    }


 class Request{
    String str;
}
 class Respanse{
    String str;
}

    class FilterChain {
        List<Filter> filters = new ArrayList<>();
        int index = 0;

        public FilterChain add(Filter f) {
            filters.add(f);
            return this;
        }
        public void doFilter(Request request,Respanse respanse){
            if (index == filters.size()) return;
            Filter f = filters.get(index);
            index ++;
             f.doFilter(request,respanse,this);
        }
    }





