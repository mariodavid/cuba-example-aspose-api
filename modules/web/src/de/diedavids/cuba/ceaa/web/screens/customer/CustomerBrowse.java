package de.diedavids.cuba.ceaa.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceaa.entity.Customer;

@UiController("ceaa_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}