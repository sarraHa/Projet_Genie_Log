package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String agedBrie = "Aged Brie";
    public static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String conjured = "Conjured Mana Cake";

    public static final int qualityMaximumValue = 50;
    public static final int qualityMinimumValue =  0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            
            updateSellin( item );
            getItemByName(item);
        }
    }
    
    
    private GildedRoseItems getItemByName(Item item){
        switch(item.name) {
            case sulfuras:
                Sulfuras sulfuras = new Sulfuras(item);
                return sulfuras;
            case agedBrie:
                AgedBrie agedBrie = new AgedBrie(item);
                agedBrie.updateAgedBrie();
                return agedBrie;
            case backstage:
                Backstage backstage = new Backstage(item);
                backstage.updateBackstage();
                return backstage;
            case conjured:
                Conjured conjured = new Conjured(item);
                conjured.updateConjured();
                return conjured;
            default:
                OtherItems otherItems = new OtherItems(item);
                otherItems.updateOtherItems();
                return otherItems;
        }
    }


    private void updateSellin( Item item ) {
        item.sellIn = item.sellIn - 1;
    }

}