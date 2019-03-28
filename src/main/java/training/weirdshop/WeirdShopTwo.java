package training.weirdshop;

public class WeirdShopTwo {
    private Item[] items;

    public WeirdShopTwo(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            updateQuality(item);
        }
    }

    private boolean hasPassedSellByDate(Item item) {
        return item.sellIn < 0;
    }

    private void updateQuality(Item item) {
        if (itemIsPremium(item)) {
            updatePremiumQuality(item);
        } else {
            updateNormalQuality(item);
        }

        enforceQualityLimit(item);
    }

    private void updatePremiumQuality(Item item) {
        updateNormalQuality(item);
        updateNormalQuality(item);
    }

    private boolean itemIsPremium(Item item) {
        if (item.name.contains("Premium")) {
            return true;
        }
        return false;
    }

    private void updateNormalQuality(Item item) {
        if (isAgedBrie(item)) {
            updateBrieQuality(item);
        } else if (isBackstagePass(item)) {
            updateQualityBackstagePass(item);
        } else if (isGoldCoin(item)) {
            //gold coins do not change quality
        }
        else {
            updateOtherQuality(item);
        }
    }

    private void updateOtherQuality(Item item) {
        if (hasPassedSellByDate(item)) {
            item.quality = item.quality - 2;
        } else {
            item.quality = item.quality -1;
        }
    }

    private void updateQualityBackstagePass(Item item) {
        if (hasPassedSellByDate(item)) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = item.quality + 3;
        } else if (item.sellIn <= 10) {
            item.quality = item.quality + 2;
        } else {
            item.quality = item.quality + 1;
        }
    }

    private void updateBrieQuality(Item item) {
        if (hasPassedSellByDate(item)) {
            item.quality = item.quality + 2;
        } else {
            item.quality = item.quality + 1;
        }
    }

    private void enforceQualityLimit(Item item) {
        if (!isGoldCoin(item)) {
            if (item.quality < 0) {
                item.quality = 0;
            }
            if (item.quality > 50) {
                item.quality = 50;
            }
        }
    }


    private void updateSellIn(Item item) {
        if (!isGoldCoin(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean isGoldCoin(Item item) {
        return item.name.contains("Gold Coin");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.contains("Backstage Pass");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.contains("Aged Brie");
    }
}
