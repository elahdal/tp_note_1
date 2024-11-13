<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse;">
    <p>Liste de Livre</p>
    <tr>
        <th style="border: 1px solid black;">Titre</th>
        <th style="border: 1px solid black;">Auteur</th>
        <th style="border: 1px solid black;">Emprunter/Rendre</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td style="border: 1px solid black;">${book.title}</td>
            <td style="border: 1px solid black;">${book.author}</td>
            <td style="border: 1px solid black;"><a href="book">Emprunter/Rendre 🗑️</a></td>
        </tr>
    </c:forEach>
</table>
