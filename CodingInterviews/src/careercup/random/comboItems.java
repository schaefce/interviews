package careercup.random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * You are given a list of items / combo_items with their price list. And you
 * are given list of items to buy. Now you are asked to find which combination
 * to buy so that it costs you minimum. It doesnt matter if you are getting some
 * extra items if it costs less.
 * 
 * 
 * Sr.No Price | Items/Combo_Items 1. 5 | Burger 2. 4 | French_Frice 3. 8 |
 * Coldrink 4. 12 | Burger, French_Frice, Coldrink 5. 14 | Burger, Coldrink
 * 
 * 
 * Input Items to Buy: Coldrink
 * 
 * Output(Sr.No) 3
 * 
 * Input Items to Buy: Burger Coldrink
 * 
 * Output(Sr.No) 4
 * 
 * Input Items to Buy: Burger French_Frice
 * 
 * Output(Sr.No) 1,2
 */
public class comboItems {
    public class Bundle {
        private int num;
        private double price;

        public Bundle(int num, double price, Set<String> itemNames) {
            this.num = num;
            this.price = price;
        }

        public String toString() {
            return "Bundle: [num=" + num + ", price =" + price + "]";
        }
    }

    private HashMap<String, List<Bundle>> bundles;

    public void addBundle(String item, Bundle b) {
        if (bundles.get(item) == null) {
            List<Bundle> itemBundle = new LinkedList<Bundle>();
            itemBundle.add(b);
            bundles.put(item, itemBundle);
        } else {
            bundles.get(item).add(b);
        }
    }

    public List<Bundle> bestBundleCombo(List<String> itemsToBuy,
            List<Bundle> bundlesBought) {
        if (itemsToBuy.isEmpty()) {
            return bundlesBought;
        }

        String item = itemsToBuy.get(0);
        List<Bundle> bundlesWithItem = getBundlesWithItem(item);
        double minPrice = Double.MAX_VALUE;
        List<Bundle> bestBundles = null;
        for (Bundle b : bundlesWithItem) {
        }
        return bestBundles;

    }

    public List<Bundle> getBundlesWithItem(String item) {
        return bundles.get(item);
    }

    public static void main(String[] args) {

    }

}
