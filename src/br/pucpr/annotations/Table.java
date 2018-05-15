package br.pucpr.annotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {
    private String colSeparator = " ";
    private String headerSeparator = "--------------------------------";

    private List<TableColumn> inspect(Class<?> clazz) {
        List<TableColumn> columns = new ArrayList<>();
        int defaultOrder = 1000000;
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            //Check if the column annotation is present
            Column info = field.getAnnotation(Column.class);
            if (info == null) continue;

            TableColumn column = new TableColumn(field);
            column.setOrder(info.order() < 0 ? defaultOrder++ : info.order());
            column.setFormat(info.format());

            Header header = field.getAnnotation(Header.class);
            if (header != null) {
                column.setHeader(header.name());
            }
            columns.add(column);
        }

        Collections.sort(columns);
        return columns;
    }

    public void print(List<?> lines) {
        try {
            if (lines.isEmpty())	 {
                System.out.println("No data to print...");
                return;
            }

            List<TableColumn> columns = inspect(lines.get(0).getClass());
            if (columns.isEmpty()) {
                System.out.println("No columns to print...");
                return;
            }

            //HEADER SECTION
            for (TableColumn column : columns) {
                System.out.print(column.getHeader());
                System.out.print(colSeparator);
            }

            System.out.println();
            System.out.println(headerSeparator);

            //LINES SECTION
            for (Object obj : lines) {
                for (TableColumn col : columns) {
                    System.out.print(col.format(obj));
                    System.out.print(colSeparator);
                }
                System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to print table", e);
        }
    }

    public Table setColumnSeparator(String colSeparator) {
        this.colSeparator = colSeparator;
        return this;
    }

    public Table setHeaderSeparator(String headerSeparator) {
        this.headerSeparator = headerSeparator;
        return this;
    }
}
