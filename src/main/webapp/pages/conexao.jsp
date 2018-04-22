<%@page import="br.com.controlpass.dao.ConexaoMySQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%

                out.println(ConexaoMySQL.statusConection());

            %>
            <%    ConexaoMySQL.getConexaoMySQL();

                out.println(ConexaoMySQL.statusConection());

            %>
        </h1>
    </body>
</html>
