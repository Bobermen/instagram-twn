package by.bobrov.gram.servlet;


import by.bobrov.gram.entity.PhotoPost;
import by.bobrov.gram.service.impl.InMemoryPostService;
import by.bobrov.gram.util.FilterConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PhotoPostServlet extends HttpServlet {
    private InMemoryPostService service;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new InMemoryPostService();
        gson = new Gson();
    }

    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        int result;
        if (id != null) {
            result = Integer.parseInt(id);
            response
                    .getWriter()
                    .println(gson.toJson(service.getPost(result)));
        }
    }

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws IOException {
        String JSONPost = request.getReader().readLine();
        service.addPost(gson.fromJson(JSONPost, new TypeToken<PhotoPost>() {
        }.getType()));
        response
                .getWriter()
                .println(gson.toJson(
                        service.getPage(0, 10, new FilterConfig())
                ));
    }

    @Override
    protected void doPut(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws IOException {
        String JSONPost = request.getReader().readLine();
        service.editPost(gson.fromJson(JSONPost, new TypeToken<PhotoPost>() {
        }.getType()));
        response
                .getWriter()
                .println(gson.toJson(
                        service.getPage(0, 10, new FilterConfig())
                ));
    }

    @Override
    protected void doDelete(final HttpServletRequest request,
                            final HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        int result;
        if (id != null) {
            result = Integer.parseInt(id);
            service.removePost(result);
        }
        response
                .getWriter()
                .println(gson.toJson(service
                        .getPage(0, 10, new FilterConfig())
                ));
    }
}
