package com.FilterUtils;

import org.apache.poi.util.IOUtils;
import org.apache.http.entity.ContentType;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 重新封装request，并对请求参数做去空格处理
 *
 * @author fnl
 */
public class FiliterBean extends HttpServletRequestWrapper {

    //存储参数
    private Map<String, String[]> params = new HashMap<>();
    //保存处理后的参数
    private byte[] content;

    public FiliterBean(HttpServletRequest request) throws IOException {
        super(request);
        /**
         * 从请求参数里面把map放进params
         */
        this.params.putAll(request.getParameterMap());
        /**
         * 将parameter的值去除空格后重写回来
         * 参数此时已经处理完毕，全部封存在map/params中
         */
        this.modifyParameterValues();


        if (ContentType.APPLICATION_JSON.getMimeType().equals(request.getContentType())) {
            //对application/json数据格式的数据进行去空格处理
            this.content = IOUtils.toByteArray(request.getInputStream());
            //获取文本数据;
            // 对json字符串进行处理
            //....................
        }
    }
    /**
     * 将parameter的值去除空格后重写回去 inoge
     */
    public void modifyParameterValues() {
        Set<Entry<String, String[]>> entrys = params.entrySet();
        for (Entry<String, String[]> entry : entrys) {
            String[] values = entry.getValue();
            for (int i = 0; i < values.length; i++) {
                values[i] = values[i].trim();
            }
            this.params.put(entry.getKey(), values);
        }
    }

    @Override
    public Enumeration<String> getParameterNames() {//重写getParameterNames()
        return new Vector<>(params.keySet()).elements();
    }


    @Override
    public String getParameter(String name) {//重写getParameter()
        String[] values = params.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {//重写getParameterValues()
        return params.get(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() { //重写getParameterMap()
        return this.params;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        //  这种获取的参数的方式针对于内容类型为文本类型，比如Content-Type:text/plain,application/json,text/html等
        //在springmvc中可以使用@RequestBody 来获取 json数据类型
        //其他文本类型不做处理，重点处理json数据格式
        if (!super.getHeader("Content-Type").equalsIgnoreCase("application/json")) {
            return super.getInputStream();
        } else {
            //根据自己的需要重新指定方法
            ByteArrayInputStream in = new ByteArrayInputStream(this.content);
            return new ServletInputStream() {
                @Override
                public int read() throws IOException {
                    return in.read();
                }

                @Override
                public int read(byte[] b, int off, int len) throws IOException {
                    return in.read(b, off, len);
                }

                @Override
                public int read(byte[] b) throws IOException {
                    return in.read(b);
                }

                @Override
                public void setReadListener(ReadListener listener) {
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public boolean isFinished() {
                    return false;
                }

                @Override
                public long skip(long n) throws IOException {
                    return in.skip(n);
                }

                @Override
                public void close() throws IOException {
                    in.close();
                }

                @Override
                public synchronized void mark(int readlimit) {
                    in.mark(readlimit);
                }

                @Override
                public synchronized void reset() throws IOException {
                    in.reset();
                }
            };
        }
    }
}
