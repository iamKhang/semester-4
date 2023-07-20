 // Đổi hình
 function changeImage(img) {
    var mainImage = document.getElementById("main-image");
    var tempSrc = mainImage.src;
    mainImage.src = img.src;
    img.src = tempSrc;
}

// Lấy ra các đối tượng cần sử dụng
const dungtich1 = document.getElementById('dungtich1');
const dungtich2 = document.getElementById('dungtich2');
const price = document.getElementById('item-price');


// Gán sự kiện "change" cho radio button của dung tích
dungtich1.addEventListener('change', updatePrice);
dungtich2.addEventListener('change', updatePrice);

// Hàm xử lý sự kiện "change"
function updatePrice() {
    // Lấy ra giá trị của radio button đã được chọn
    const selectedDungTich = document.querySelector('input[name="dungtich"]:checked').value;

    // Tính toán giá của sản phẩm dựa vào dung tích đã chọn
    let gia;
    if (selectedDungTich === '10ml') {
        gia = objSP.gia[0];
    } else  {
        gia = objSP.gia[1];
    }
    // Hiển thị giá của sản phẩm
    price.innerHTML = gia + 'đ';
}


// Lấy các phần tử cần thiết
var minusBtn = document.getElementById("minus-btn");
var plusBtn = document.getElementById("plus-btn");
var quantityInput = document.getElementById("quantity");
var quantityError = document.getElementById("quantity-error");

// Xử lý sự kiện khi người dùng nhấn nút "-"
minusBtn.addEventListener("click", function () {
    var currentQuantity = parseInt(quantityInput.value);
    if (currentQuantity > 1) {
        quantityInput.value = currentQuantity - 1;
    }
});

// Xử lý sự kiện khi người dùng nhấn nút "+"
plusBtn.addEventListener("click", function () {
    var currentQuantity = parseInt(quantityInput.value);
    if (currentQuantity < 1000) {
        quantityInput.value = currentQuantity + 1;
    }
});

// Xử lý sự kiện khi người dùng nhập số lượng
quantityInput.addEventListener("input", function () {
    var currentQuantity = parseInt(quantityInput.value);
    if (isNaN(currentQuantity) || currentQuantity < 1 || currentQuantity > 1000) {
        quantityError.textContent = "Số lượng phải lớn hơn 1.";
    } else {
        quantityError.textContent = "";
    }
});

let objSP = JSON.parse(localStorage.getItem("sanpham"));

document.querySelector('#main-image').src = `.${objSP.anh[0]}`;
let str="";
for(var i=1;i<objSP.anh.length;i++){
    str+= `<img src=".${objSP.anh[i]}"
    class="img-fluid thumbnail d-block mx-auto" onclick="changeImage(this)" />`;
}
document.querySelector('.image-child').innerHTML = str;
document.querySelector('.item-xuatXu').innerHTML = objSP.xuatXu;
document.querySelector('#item-name').innerHTML = objSP.tenNuocHoa;
document.querySelector('.name').innerHTML = objSP.tenNuocHoa;
document.querySelector('#item-price').innerHTML = objSP.gia[0];
document.querySelector('.item-description').innerHTML = objSP.moTa;
document.querySelector('.item-gender').innerHTML = objSP.gioiTinh;
document.querySelector('.nhaPhaChe').innerHTML = objSP.thongTinSanPham.nhaPhaChe;
document.querySelector('.nhomHuong').innerHTML = objSP.thongTinSanPham.nhomNuocHoa;
document.querySelector('.namRaMat').innerHTML = objSP.thongTinSanPham.namRaMat;
document.querySelector('.doLuuHuong').innerHTML = objSP.thongTinSanPham.doLuuHuong;
document.querySelector('.nongDo').innerHTML = objSP.thongTinSanPham.nongDo;
document.querySelector('.phongCach').innerHTML = objSP.thongTinSanPham.phongCach;
document.querySelector('.item-moTa').innerHTML = objSP.moTa;


function addToCart() {
            
    const itemCart = JSON.parse(localStorage.getItem("sanpham"));
    const selectedDungTich = document.querySelector('input[name="dungtich"]:checked').value;
    let qty = parseInt(document.getElementById('quantity').value);
    let cartItems = JSON.parse(localStorage.getItem('cartItems')) || []; 
    if (itemCart) {
      const existingItemIndex = cartItems.findIndex(item => (item.id === itemCart._id) && (item.ml === selectedDungTich)); 
      if (existingItemIndex !== -1) {
        cartItems[existingItemIndex].quantity+=qty; 
      } else {

        if (selectedDungTich === '10ml') {
            cartItems.push({id: itemCart._id,anh:itemCart.anh[1], name: itemCart.tenNuocHoa, price: itemCart.gia[0],ml: '10ml', quantity: qty });
        } else  {
            cartItems.push({id: itemCart._id,anh:itemCart.anh[1], name: itemCart.tenNuocHoa, price: itemCart.gia[1],ml: 'fullbox', quantity: qty });
        }
        
      }
      localStorage.setItem('cartItems', JSON.stringify(cartItems));
    }
    location.reload();
    
    
}