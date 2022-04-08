<%-- 
    Document   : paginaProduto
    Created on : 04/03/2022, 14:50:12
    Author     : user
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <!-- Body and Section-->
 
<body>
     <!-- Product section-->
    <section class="py-5">
        <div class="container px-4 px-lg-5 my-5">
            <div id="indexRightColumn"> 
                 
                <%--<c:choose>
                     <c:when test="${cliente.cliid == null}">
                         <p style="font-family: cursive; margin-left: 2em; margin-top: -3em;">
                             PARA COMPRAR É NECESSÁRIO ESTAR LOGADO! <a style="text-decoration: none" type="button" href="/loja/cadastroP2">CLIQUE AQUI</a>                                                          
                         </p>
                     </c:when>
                 </c:choose> --%>

                 <div class="row gx-4 gx-lg-5 align-items-center">
                     <div class="col-md-6">
                         <img class="card-img-top mb-5 mb-md-0" src="${initParam.produtosImagemPath}${selecioneProd.pronome}.jpg">
                     </div>                                 
                     <div class="col-md-6">                   


                         <div class="small mb-1">SKU: BSTSiv${selecioneProd.proid}</div>
                         <h3 class="display-5 fw-bolder">${selecioneProd.pronome}</h3>
                         <div class="fs-5 mb-5">
                             <span class="text-decoration">
                                 <fmt:formatNumber value="${selecioneProd.propreco}" type="currency"  /></span>  
                         </div>
                         <p class="lead">${selecioneProd.prodescr}</p>
                         <div class="d-flex">

                             <form action="${pageContext.request.contextPath}/addCart" method="POST">
                                 <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">

                                     <div class="text-center">

                                         <input type="hidden" name="produtoId" value="${selecioneProd.proid}" />
                                         <button type="submit" class="btn btn-outline-dark mt-auto" <%--href="paginaCompraLista?${selecioneProd.proid}"--%> >adicionar</button>
                                     </div>

                                 </div>
                             </form>
                         </div>
                     </div>
                 </div>
            </div>
         </div>
    </section>

 <!-- Description item section-->
    <section>
        <div class="container px-4 px-lg-5 mt-5">
            <h2 class="fw-bolder mb-4">Descrição do produto: ${selecioneProd.pronome}</h2>
            <p class="lead">${selecioneProd.prodescr}</p>
            <p class="lead">Comprimento : ${selecioneProd.procompri} metros</p>
            <p class="lead">Largura: ${selecioneProd.prolargura}metros</p>
            <p class="lead">Altura: ${selecioneProd.proaltura} metros</p>
            <p class="lead">Peso: "${selecioneProd.propeso} Kg</p>
        </div>
    </section>
</body>
