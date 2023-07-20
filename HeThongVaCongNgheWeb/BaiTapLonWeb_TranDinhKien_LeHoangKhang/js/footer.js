const footer = document.querySelector("#footer");
footer.outerHTML = `<footer class="footer">
<div class="footer_heading">
    <div class="footer_heading_col1">
        <h5>VỀ CHÚNG TÔI</h5>
        <ul>
            <li><a href="../html/gioithieu.html">Giới thiệu</a></li>
            <li><a href="../html/lienhe.html">Liên hệ</a></li>
        </ul>
    </div>
    <div class="footer_heading_col2">
        <h5>HƯỚNG DẪN</h5>
        <ul>
            <li><a href="../html/huongdanmuahangvathanhtoan.html">Hướng dẫn mua hàng</a></li>
            <li><a href="../html/dieukhoansudung.html">Điều khoản sử dụng</a></li>
        </ul>
    </div>
    <div class="footer_heading_col3">
        <h5>CHÍNH SÁCH</h5>
        <ul>
            <li><a href="">Chính sách giao hàng</a></li>
            <li><a href="">Chính sách đổi trả</a></li>
        </ul>
    </div>
    <div class="footer_heading_col4">
        <h5>HỖ TRỢ</h5>
        <ul>
            <li><a href="">Cộng tác viên</a></li>
            <li><a href="../html/loginform.html">Đăng nhập / Đăng ký</a></li>
        </ul>
    </div>
</div>
<div class="footer_bottom">
    <div class="footer_bottom_social">
        <h5>Liên hệ với chúng tôi</h5>
        <div class="footer_bottom_button">
            <div class="button1">
                <a href="https://www.facebook.com/trandinhkien.07052003"><i class="fa-brands fa-facebook"></i></a>
            </div>
            <div class="button2">
                <a href=""><i class="fa-brands fa-instagram"></i></a>
            </div>
            <div class="button3">
                <a href=""><i class="fa-solid fa-map-location-dot"></i></a>
            </div>
        </div>                
    </div>
    <div class="footer_bottom_subcriable">
        <h5>Đăng ký nhận tin</h5>
        <p>Nhận thông tin khuyến mãi và sản phẩm mới nhất</p>
        <div class="footer_bottom_form">
            <input type="text" placeholder="Họ và tên">
            <input type="text" placeholder="Email">
            <input type="submit" value="Đăng ký" id="footer_subcriable_submit">
        </div>
    </div>
</div>
<div class="footer_coppyright">
    <p>®Coppyright 2023</p>
</div>
</footer>`