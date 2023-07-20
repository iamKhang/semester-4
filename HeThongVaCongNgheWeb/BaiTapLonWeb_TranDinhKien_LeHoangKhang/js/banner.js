
const myCarousel = document.querySelector("#myCarousel");
myCarousel.outerHTML = ` <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" style="z-index:-1; height:600px">
<div class="carousel-indicators">
  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
</div>
<div class="carousel-inner" style=" height:600px">
  <div class="carousel-item active">
    <img src="../img/banner1.jpg" class="d-block w-100" alt="banner1">
  </div>
  <div class="carousel-item" style=" height:600px">
    <img src="../img/banner2.jpg" class="d-block w-100" alt="banner2">
  </div>
</div>
<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
  <span class="visually-hidden">Previous</span>
</button>
<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
  <span class="carousel-control-next-icon" aria-hidden="true"></span>
  <span class="visually-hidden">Next</span>
</button>
</div>`

// const carousel = new bootstrap.Carousel("#myCarousel",{
//   interval: 5,
//   ride: true,
// });
// carousel.cycle();