<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Body and Section-->

<body> 
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
            
                <div class="carousel-item active">
                    <img src="img/capaBeatles.jpg" class="d-block w-100" style="width: 100%; height: auto;" alt="...">
                </div>
                    
                <div class="carousel-item">
                    <img src="img/capa.jpg" class="d-block w-100" style="width: 100%; height: auto;" alt="...">
                </div>
                    
                <div class="carousel-item">
                    <img src="img/capaBeatles.jpg" class="d-block w-100" style="width: 100%; height: auto;" alt="...">
                </div>
            </div>
     </div>

    <section class="py-5">
        <img src="img/comprasegura.jpg" style="display: block; margin-left: auto; margin-right: auto; width:60%;">
        <hr>
        <h3 style="text-align: center; color: #3C3D59; font-family: Luminari, fantasy; text-decoration: underline double #D9115A;"> PROMOÇÕES DA DISCADA </h3>
            
    <!-- Aqui começa a vitrine principal da loja -->

        <!--<div id="indexRightColumn">
            <div class="container">
                <div class="row col-3 "> -->
        <div class="container px-4 px-lg-5 mt-5">
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">              
                
                    <c:forEach var="produ" items="${produtos}" >
                        <c:choose>
                            <c:when test="${obj.proativo != 1}"> <!-- para produtos ativos -->
                                <div class="col mb-4" >
                        <!-- Imagem do produto-->
                                <div class="card h-100" style="border-radius: 20px;">
                                    <img class="card-img-top" style="object-fit: contain;max-height: 178px;" src="${initParam.produtosImagemPath}${produ.pronome }.jpg" alt="${produ.pronome}"/>

                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <p class="fw-bolder">${produ.pronome}</p>

                                            <!-- Product reviews-->
                                            <div class="d-flex justify-content-center small text-warning mb-2">
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                            </div>
                                        </div>
                                    </div>
                                            <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <p style="text-align: center;">
                                            <fmt:formatNumber value="${produ.propreco}" type="currency"/></p>
                            
                                        <form action="Addcart" method="POST">
                                            <div class="text-center"><input type="hidden" id="cart" name="produtoId"><a class="btn btn-outline-dark mt-auto" href="paginaProduto?${produ.proid}">Veja os Detalhes</a></div>
                                        </form>
                                    </div>
                                </div>
                                </div>
                             </c:when>
                        </c:choose>
                    </c:forEach>
                                           
                <!--</div>-->
            </div>
        </div>


        <nav aria-label="...">
            <ul style="margin-left: 33em;" class="pagination">
                <li class="page-item disabled">
                   <span class="page-link">Anterior</span>
                </li>

                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active">
                    <span class="page-link">
                        2
                        <!--<span class="sr-only">(atual)</span>-->
                    </span>
                </li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#">Próximo</a>
                </li>
            </ul>
        </nav>  
    </section>
</body>

<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->  

  



