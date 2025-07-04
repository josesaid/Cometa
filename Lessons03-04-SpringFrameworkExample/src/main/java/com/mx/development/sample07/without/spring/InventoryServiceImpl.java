package com.mx.development.sample07.without.spring;

public class InventoryServiceImpl implements InventoryServiceI {

    private InventoryRepositoryI inventoryRepositoryI;

    public InventoryServiceImpl(InventoryRepositoryI instance){
        this.inventoryRepositoryI = instance;
    }

    @Override
    public void updateInventory(Product product) {
        System.out.println( "Updating inventory for product: " + product);
        inventoryRepositoryI.updateDB();
    }
}
