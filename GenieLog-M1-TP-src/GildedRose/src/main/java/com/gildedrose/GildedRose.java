package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String agedBrie = "Aged Brie";
    public static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String conjured = "Conjured Mana Cake";


    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateQuality( Item item ) {
        item.quality = item.quality + 1;
    }

    private void updateQualityOtherItems( Item item ) {
        item.quality = item.quality - 1;
    }

    private void updateSellin( Item item ) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateAgedBrie(Item agedBrie ){
        if(agedBrie.quality < 50){
            updateQuality(agedBrie);
            updateSellin( agedBrie );
        
        }else{
            updateSellin(agedBrie);   
        }        
        if(agedBrie.sellIn < 0 && agedBrie.quality < 50){
            updateQuality(agedBrie);
        }
    }

    private void updateBackstage(Item backstage ){
        if( backstage.quality < 50){
            updateQuality(backstage);
        }
        if (backstage.sellIn < 11) {
            if (backstage.quality < 50) {
                updateQuality(backstage);
            }
        }
        if (backstage.sellIn < 6) {
            if (backstage.quality < 50) {
                updateQuality(backstage);
            }
        }
        updateSellin(backstage);
        if (backstage.sellIn < 0) {
            backstage.quality = backstage.quality - backstage.quality;
        }
    }

    private void UpdateOtherItems( Item item){
        if (item.quality > 0) {
            updateQualityOtherItems(item);
        }
        updateSellin(item);
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                updateQualityOtherItems(item);
            }
        }
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if( items[i].name.equals(sulfuras)){
                continue;
            }else if( items[i].name.equals(agedBrie)){
                updateAgedBrie( items[i]);
            }else if (items[i].name.equals(backstage)) {
                updateBackstage(items[i]);
            }else{
                UpdateOtherItems( items[i]);
            }
        }
    }
}