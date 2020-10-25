package com.gildedrose;

class Conjured extends GildedRoseItems{

    Item conjured ; 
    public static final int qualityMinimumValue =  0;

    Conjured(Item item){
        this.conjured = item; 
    }

    private void updateQualityOtherItems( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    public void updateConjured(){
        updateQualityOtherItems(this.conjured);
        if (sellInUnder0(this.conjured)){
            updateQualityOtherItems(this.conjured);
        }
        updateQualityOtherItems(this.conjured);
    }

}