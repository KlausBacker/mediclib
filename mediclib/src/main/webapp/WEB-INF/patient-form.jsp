<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ patient == null }">Add a new patient</c:if>
		<c:if test="${ patient != null }">Edit patient information</c:if>
	</jsp:attribute>

    <jsp:body>
        <form method="POST">
            <div>
                <label>Last name</label>
                <input type="text" name="lname" value="${ patient.lastName }" />
            </div>

            <div>
                <label>First name</label>
                <input type="text" name="fname" value="${ patient.firstName }" />
            </div>

            <div>
                <label>Social Security Number</label>
                <input type="text" name="secu" value="${ patient.numberSecSoc }" />
            </div>
            <div>
                <label>Birthdate</label>
                <input type="date" name="birthdate" value="${ patient.birthday }" >
            </div>
            <div>
                <label>Phone number</label>
                <input type="text" name="tel" value="${ patient.tel }" >
            </div>
            <div>
                <label>Address</label>
                <select name="addressId">
                    <c:forEach var="address" items="${ addresses }">
                        <c:if test="${ patient.address.id == address.four_Id }">
                            <option selected value="${ address.id }">${ address.street }</option>
                        </c:if>

                        <c:if test="${ patient.address.id != address.id }">
                            <option value="${ address.id }">${ address.street }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div

            <div>
                <c:if test="${ patient == null }">
                    <input type="submit" class="btn btn-success" value="Add" />
                </c:if>

                <c:if test="${ patient != null }">
                    <input type="submit" class="btn btn-warning" value="Edit" />
                </c:if>
            </div>
        </form>
    </jsp:body>
</t:layout>