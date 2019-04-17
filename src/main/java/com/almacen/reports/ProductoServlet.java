package com.almacen.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.almacen.dto.DataTableDTO;
import com.almacen.dto.out.MaestraOutDTO;
import com.almacen.service.MaestraService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@WebServlet(value = "/reportes/producto")
public class ProductoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoServlet.class);

    @Autowired
    private MaestraService maestraService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperCompileManager.compileReportToStream(getClass().getResourceAsStream("/ReporteProductos.jrxml"), baos);

            DataTableDTO<MaestraOutDTO> table = maestraService.buscar();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(table.getData());
            JasperPrint print = JasperFillManager.fillReport(new ByteArrayInputStream(baos.toByteArray()), new HashMap<String, Object>(), dataSource);
            JasperExportManager.exportReportToPdfStream(print, resp.getOutputStream());
        } catch (JRException e) {
            LOGGER.error("", e);
        }
    }
}
