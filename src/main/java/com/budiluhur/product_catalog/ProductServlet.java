package com.budiluhur.product_catalog;

import com.budiluhur.product_catalog.model.Product;
import com.budiluhur.product_catalog.repository.ProductRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() {
        // Inisialisasi Repository dan data awal
        productRepository = new ProductRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        List<Product> products = productRepository.findAll();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Katalog Produk</title></head>");
        out.println("<body>");
        out.println("<h2>=== DAFTAR KATALOG PRODUK (WEB) ===</h2>");
        out.println("<table border='1' cellpadding='8' cellspacing='0'>");
        out.println("<tr><th>ID Produk</th><th>Nama Produk</th><th>Harga Satuan</th></tr>");

        for (Product p : products) {
            out.println("<tr>");
            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getName() + "</td>");
            out.println("<td>Rp" + p.getPrice() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
