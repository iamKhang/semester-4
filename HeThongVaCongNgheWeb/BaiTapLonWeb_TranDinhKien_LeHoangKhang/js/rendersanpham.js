import data from "../js/data.js";


localStorage.setItem("dssanpham",JSON.stringify(data));

var jsondssanpham = localStorage.getItem('dssanpham');
var dsSanPham = JSON.parse(jsondssanpham);

function chuyenDSObjectThanhHTML(dsSanPham) {
    var HTMLDanhSachSanPham = `<div class="dssanpham">`;
    for(var i=0;i<dsSanPham.length;i++){
        var htmlSanPham = chuyenSanPhamThanhHTML(dsSanPham[i]);
        HTMLDanhSachSanPham = HTMLDanhSachSanPham + htmlSanPham;
    }

    HTMLDanhSachSanPham = HTMLDanhSachSanPham + `</div>`;
    return HTMLDanhSachSanPham;
}



function chuyenSanPhamThanhHTML(sanPham){
    var html=``;
    var SP = JSON.stringify(sanPham);
    html += `<div class="item">
                     <div class="item-thumb">
                        <a href="/html/chitietsanpham.html" onclick=\'showDetail(\`${SP}\`);\' id="location"><img src=".${sanPham.anh[1]}" alt=""></a>
                        </div>
                        <h4 class="item-title">${sanPham.tenNuocHoa}</h4>
                        <div class="item-price">${sanPham.gia[0]} đ - ${sanPham.gia[1]} đ</div>
                        <div class="item-rate"><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></div>
                        <div class="item-btn">
                            <button class="btn btn-heart"><i class="fa-regular fa-heart"></i></button>
                            <button class="btn btn-primary" onclick=\'addToCart(\`${SP}\`);\'><i class="fa-sharp fa-regular fa-cart-plus"></i></button>
                        </div>
                    </div>`;

    return html;
}


var HTML = chuyenDSObjectThanhHTML(dsSanPham);


var nodeDSSanPham =  document.getElementById('products');
nodeDSSanPham.innerHTML = HTML;


