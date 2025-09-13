package bg.sofia.uni.fmi.mjt.gameplatform.store;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter.ItemFilter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GameStore implements StoreAPI{
    public StoreItem[] availableItems;

    public GameStore(StoreItem[] availableItems)
    {
        this.availableItems=availableItems;
    }
    @Override
   public StoreItem[] findItemByFilters(ItemFilter[] itemFilters){
   List<StoreItem> matched=new ArrayList<>();
   for(StoreItem item:availableItems)
   {
    boolean matchesAll=true;
    for(ItemFilter filter:itemFilters)
    {
        if(!filter.matches(item))
        {
            matchesAll=false;
            break;
        }
    }
    if(matchesAll)
    {
        matched.add(item);
    }
   }
   return matched.toArray(new StoreItem[0]);

}
   @Override
    public   void applyDiscount(String promoCode){
        BigDecimal discount;
        switch(promoCode)
    {
        case "VAN40":
        discount=new BigDecimal("0.6");
        break;
        case "100YO":
        discount=BigDecimal.ZERO;
        break;
        default:return;
    }
    for(StoreItem i: availableItems)
    {
        BigDecimal newPrice=i.getPrice().multiply(discount).setScale(2,BigDecimal.ROUND_HALF_UP);
        i.setPrice(newPrice);
    }
    
    }
    @Override
     public boolean rateItem(StoreItem item, int rating)
      {
        if(rating <1 || rating >5)
        {
            return false;
        }
        for(StoreItem i:availableItems)
        {
            if(i.equals(item))
            {
                i.rate(rating);
                return true;
            }
        }
        return false;
      }
}
