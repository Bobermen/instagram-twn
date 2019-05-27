package by.bobrov.gram.servlet;

import by.bobrov.gram.service.impl.InMemoryPostService;
import by.bobrov.gram.util.FilterConfig;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class PhotoPostsServlet extends HttpServlet {
    private InMemoryPostService service;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new InMemoryPostService();
        gson = new Gson();
    }

    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws IOException {
        FilterConfig filterConfig = new FilterConfig();
        filterConfig.setAuthors(Arrays.asList(
                "Ivan",
                "Sashenka",
                "Masha"
        ));
        filterConfig.setHashTags(Arrays.asList("tag1"));
        filterConfig.setFromDate(new Date("2010/01/01"));
        filterConfig.setToDate(new Date("2020/01/01"));
        response
                .getWriter()
                .println(gson.toJson(
                        service.getPage(0, 10, filterConfig)
                ));
    }
}
