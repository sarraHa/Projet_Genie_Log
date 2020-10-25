package com.gildedrose;

class Conjured {

    Item conjured ; 
    public static final int qualityMinimumValue =  0;

    Conjured(Item item){
        this.conjured = item; 
    }

    private boolean sellInUnder0( Item item ) {
        return item.sellIn < 0;
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