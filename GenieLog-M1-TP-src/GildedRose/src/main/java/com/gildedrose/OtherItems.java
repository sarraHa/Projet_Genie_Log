package com.gildedrose;

class OtherItems extends GildedRoseItems {

    Item item ; 

    OtherItems(Item item){
        this.item = item;
    }

    private void updateQualityOtherItems( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    public void updateOtherItems(){
        updateQualityOtherItems(this.item);
        if (sellInUnder0(this.item)){
            updateQualityOtherItems(this.item);
        }
    }

    
}