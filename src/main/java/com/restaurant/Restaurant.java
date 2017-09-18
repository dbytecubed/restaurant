package com.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private List<Table> tables = new ArrayList<>();
    
    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
    
    public Table seatCustomers(int num) {
        
        for (int x = 0; x < tables.size(); x++) {
            if (num <= tables.get(x).getSeats() && !tables.get(x).isCustSeatedFlag()) {
                //found an open table
                Table table = tables.get(x);
                table.setCustSeatedFlag(true);
                return table;
            }
        }
        
        //no tables available
        return null;
    }

    public void unseatTable(Table table) {
        for (Table table2 : tables) {
            if (table.getId() == table2.getId()) {
                table2.setCustSeatedFlag(false);
            }
        }
    }

    public boolean checkTabFull() {
        return tables.stream().anyMatch(x -> x.isCustSeatedFlag() == true);
    }
    
}
