package com.restaurant;

import org.junit.Assert;
import org.junit.Test;

public class TestRestaurant {

    @Test
    public void testCanSeat2() {
        Restaurant myRestaurant = new Restaurant();

        //initialize table setup
        myRestaurant.getTables().add(new Table(1, 2));
        myRestaurant.getTables().add(new Table(2, 2));
        myRestaurant.getTables().add(new Table(3, 4));
        myRestaurant.getTables().add(new Table(4, 4));

        Table table = myRestaurant.seatCustomers(2);
        Assert.assertEquals(table.getId(), 1);

        table = myRestaurant.seatCustomers(2);
        Assert.assertEquals(table.getId(), 2);

        table = myRestaurant.seatCustomers(2);
        Assert.assertEquals(table.getId(), 3);

        table = myRestaurant.seatCustomers(2);
        Assert.assertEquals(table.getId(), 4);

        table = myRestaurant.seatCustomers(2);
        //all seats are full
        Assert.assertEquals(table, null);

        myRestaurant.unseatTable(new Table(1, 0));
        table = myRestaurant.seatCustomers(2);
        Assert.assertEquals(table.getId(), 1);

    }

    @Test
    public void testCanSeat4() {
        Restaurant myRestaurant = new Restaurant();

        //initialize table setup
        myRestaurant.getTables().add(new Table(1, 2));
        myRestaurant.getTables().add(new Table(2, 2));
        myRestaurant.getTables().add(new Table(3, 4));
        myRestaurant.getTables().add(new Table(4, 4));

        Table table = myRestaurant.seatCustomers(4);
        Assert.assertEquals(table.getId(), 3);

        table = myRestaurant.seatCustomers(4);
        Assert.assertEquals(table.getId(), 4);

        table = myRestaurant.seatCustomers(4);
        //all seats are full
        Assert.assertEquals(table, null);

        myRestaurant.unseatTable(new Table(3, 0));
        table = myRestaurant.seatCustomers(4);
        Assert.assertEquals(table.getId(), 3);

    }

    @Test
    public void testAllTablesFullChecker() {
        Restaurant myRestaurant = new Restaurant();

        //initialize table setup
        myRestaurant.getTables().add(new Table(1, 2));
        myRestaurant.getTables().add(new Table(2, 2));
        myRestaurant.getTables().add(new Table(3, 4));
        myRestaurant.getTables().add(new Table(4, 4));

        //check we are not full
        Assert.assertEquals(false, myRestaurant.checkTabFull());

        //fill up all tables
        myRestaurant.seatCustomers(1);
        myRestaurant.seatCustomers(1);
        myRestaurant.seatCustomers(1);
        myRestaurant.seatCustomers(1);

        Assert.assertEquals(true, myRestaurant.checkTabFull());
    }

}
