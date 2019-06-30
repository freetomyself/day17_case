package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: day17_case--${PACKAGE_NAME}
 * @author: WaHotDog 2019-06-27 19:59
 **/

/**
 * 敏感词汇过滤器
 */

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //1.创建代理对象，增强getParameter方法

        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }

                    return value;
                }

                //判断方法名是否是 getParameterMap
                if (method.getName().equals("getParameterMap")) {
                    System.out.println( method.invoke(req,args));
                    Map<String,String[]> value= (Map<String, String[]>) method.invoke(req,args);
                    for (String key : value.keySet()) {
                        for (String str : list) {
                            String checkworld = value.get(key)[0];
                            if (checkworld.contains(str)){
                                checkworld = checkworld.replaceAll(str,"***");
                                String [] SensitiveWords = new String[]{checkworld};
                                Method method1 = value.getClass().getMethod("setLocked",new Class[]{boolean.class});
                                method1.invoke(value,new Object[]{new Boolean(false)});
                                value.put(key,SensitiveWords);
                            }
                        }
                    }
                    return value;
                }
                //判断方法名是否是 getParameterValue;
                if(method.getName().equals("getParameterValues")){
                    String [] value = (String[]) method.invoke(req,args);
                    for(int i=0 ;i<value.length;i++){
                        for (String str : list) {
                            if(value[i].contains(str)){
                                value[i] = value[i].replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }
        });

        //2.放行
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list = new ArrayList<String>();//敏感词汇的list集合

    public void init(FilterConfig config) throws ServletException {


        System.out.println("进来了");
        ServletContext servletContext = config.getServletContext();
        //获取真实路径
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

        //读入数据
        try {
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String context = null;
            while ((context = br.readLine()) != null) {
                list.add(context);
            }
            br.close();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
