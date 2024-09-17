package com.baeldung.jasperreports;

import com.baeldung.jasperreports.config.JasperRerportsSimpleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JasperRerportsSimpleConfig.class);
        ctx.refresh();

        SimpleReportFiller simpleReportFiller = ctx.getBean(SimpleReportFiller.class);
        simpleReportFiller.setReportFileName("employeeEmailReport.jrxml");
        simpleReportFiller.compileReport();

        simpleReportFiller.setReportFileName("employeeReport.jrxml");
        simpleReportFiller.compileReport();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Employee Report Example");
        parameters.put("minSalary", 15000.0);
        parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");

        simpleReportFiller.setParameters(parameters);
        simpleReportFiller.fillReport();

        SimpleReportExporter simpleExporter = ctx.getBean(SimpleReportExporter.class);
        simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

        simpleExporter.exportToPdf("employeeReport.pdf", "baeldung");
//        simpleExporter.exportToXlsx("c:\\manu\\00basura\\aa\\employeeReport.xlsx", "Employee Data");
        simpleExporter.exportToXlsx("employeeReport.xlsx", "Employee Data");
        simpleExporter.exportToCsv("employeeReport.csv");
        simpleExporter.exportToHtml("employeeReport.html");
        
        

        SimpleReportFiller simpleReportFiller2 = ctx.getBean(SimpleReportFiller.class);

        simpleReportFiller2.setReportFileName("employeeEmailReport.jrxml");
        simpleReportFiller2.compileReport();

        simpleReportFiller2.setReportFileName("employeeReport2.jrxml");
        simpleReportFiller2.compileReport();

        Map<String, Object> parameters2 = new HashMap<>();
        parameters2.put("title", "Employee Report Example");
        parameters2.put("minSalary", 15000.0);
        parameters2.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");

        simpleReportFiller2.setParameters(parameters2);
        
        simpleReportFiller2.fillReport2();
        
        SimpleReportExporter simpleExporter2 = ctx.getBean(SimpleReportExporter.class);
        simpleExporter.setJasperPrint(simpleReportFiller2.getJasperPrint());

        simpleExporter.exportToXlsx("employeeReport2.xlsx", "Employee Data");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }
}
