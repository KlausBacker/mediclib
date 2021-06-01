<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:AdminLayout>
    <jsp:attribute name="title">Specialités médicales</jsp:attribute>

    <jsp:body>
        <c:if test="${ param.medspeAjout == true }">
            <div class="alert alert-success" role="alert">
                La spécialité medicale à été ajoutée !
            </div>
        </c:if>

        <c:if test="${ param.medspeModifie == true }">
            <div class="alert alert-success" role="alert">
                La spécialité medicale à été modifiée !
            </div>
        </c:if>

        <a href="add-medspe" class="btn btn-success">Ajouter une spécialité</a>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="speciality" items="${ specialities }">
                <tr>
                    <td>${ speciality.getId() }</td>
                    <td>${ speciality.name }</td>
                    <td>
                        <a href="detail-medspe?id=${ speciality.id }" class="btn btn-info">Details</a>
                        <a href="update-medspe?id=${ speciality.id }" class="btn btn-warning">Modifier</a>
                        <a href="delete-medspe?id=${ speciality.id }" class="btn btn-danger">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:AdminLayout>