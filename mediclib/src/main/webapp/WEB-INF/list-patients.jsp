<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
    <jsp:attribute name="title">List of patients</jsp:attribute>

    <jsp:body>
        <c:if test="${ addPatient == true }" >
            <div class="alert alert_success" role="alert">
                The patient has been added to your list.
            </div>
        </c:if>

        <c:if test="${ param.modPatient == true }" >
            <div class="alert alert_success" role="alert">
                The patient data has been modified.
            </div>
        </c:if>

        <c:if test="${ delPatient == true }" >
            <div class="alert alert_success" role="alert">
                The patient has been removed from the list.
            </div>
        </c:if>

        <a href="add-patient" class="btn btn-success">Add a new patient</a>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Last name</th>
                <th>First name</th>
                <th>Social Security Number</th>
               <%-- <th>Birthdate</th>--%>
<%--                <th>Phone number</th>--%>
<%--                <th>Address</th>--%>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="patient" items="${ patients }">
                <tr>
                    <td>${ patient.getId() }</td>
                    <td>${ patient.lastName }</td>
                    <td>${ patient.firstName }</td>
                    <td>${ patient.numberSecSoc }</td>
                    <%--<td>${ patient.birthday }</td>
                    <td>${ patient.tel }</td>
                    <td>${ patient.patAddress }</td>--%>
                    <td>
                        <a href="modPatient?id=${ patient.id }" class="btn btn-warning">Edit patient information</a>
                        <a href="delPatient?id=${ patient.id }" class="btn btn-danger">Delete patient</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </jsp:body>
</t:layout>

