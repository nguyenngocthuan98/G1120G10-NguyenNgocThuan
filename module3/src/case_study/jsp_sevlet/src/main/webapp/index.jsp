<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--include header--%>
<jsp:include page="pages/header.jsp" />

<%--include banner--%>
<jsp:include page="pages/banner.jsp" />

<%--include navbar--%>
<jsp:include page="pages/navbar.jsp" />

<%--include menu left--%>
<jsp:include page="pages/menu_left.jsp" />

<%--page change content BELOW--%>
    <%--include home main--%>
<jsp:include page="pages/home_page.jsp" />

    <%--include employee main--%>
<jsp:include page="employee_page/employee_page.jsp" />

    <%--include customer main--%>
<jsp:include page="customer_page/customer_page.jsp" />

    <%--include service main--%>
<jsp:include page="service_page/service_page.jsp" />

    <%--include contract main--%>
<jsp:include page="contract_page/contract_page.jsp" />
<%--page change content END HERE--%>

<%--include footer content--%>
<jsp:include page="pages/footer_content.jsp" />

<%--include footer--%>
<jsp:include page="pages/footer.jsp" />
