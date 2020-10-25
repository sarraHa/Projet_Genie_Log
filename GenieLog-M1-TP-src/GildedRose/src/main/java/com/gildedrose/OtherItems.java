package com.gildedrose;

class OtherItems {

    Item item ; 
    public static final int qualityMinimumValue =  0;


    OtherItems(Item item){
        this.item = item;
    }

    private void updateQualityOtherItems( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    private boolean sellInUnder0( Item item ) {
        return item.sellIn < 0;
    }

    public void updateOtherItems(){
        updateQualityOtherItems(this.item);
        if (sellInUnder0(this.item)){
            updateQualityOtherItems(this.item);
        }
    }

    
}