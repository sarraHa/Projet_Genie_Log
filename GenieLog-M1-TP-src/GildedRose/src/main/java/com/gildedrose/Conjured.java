package com.gildedrose;

class Conjured extends GildedRoseItems{

    Item conjured ; 

    Conjured(Item item){
        this.conjured = item; 
    }

    /*----->
    private void updateQualityOtherItems( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    ------>*/

    @Override
    protected void updateQuality( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    public void updateConjured(){
        updateQuality(this.conjured);
        if (sellInUnder0(this.conjured)){
            updateQuality(this.conjured);
        }
        updateQuality(this.conjured);
    }

}