package com.br.lp3.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1147106
 */
public class UserCommand implements Command {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public String returnPage = "index.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        request.getSession().setAttribute("errormsg", "");

        switch (action) {
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                if ("cacique".equals(username) && "123".equals(password)) {
                    returnPage = "index.jsp";
                    request.getSession().setAttribute("username", username);
                } else {
                    request.getSession().setAttribute("errormsg", "Usuario ou senha incorretos");
                    returnPage = "login.jsp";
                }

                break;
            case "logout":
                returnPage = "index.jsp";
                request.getSession().setAttribute("username", null);
                break;
            case "logerror":
                returnPage = "login.jsp";
                request.getSession().setAttribute("errormsg", "Acesso restrito! realize o login");
        }

    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

}
