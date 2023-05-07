package ooploverz.tubes2_oop.Bill;

import lombok.Getter;
import ooploverz.tubes2_oop.DataStore.DataBill;
import ooploverz.tubes2_oop.inventory.Item;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReceiptList{
    @Getter
    private ArrayList<Receipt> billList;

    public ReceiptList(boolean bill){
        JSONArray billListData = DataBill.getData();
        this.billList = new ArrayList<Receipt>();
        try {
            if(bill){
                for (int i = 0; i < billListData.length(); i++) {
                    int total;
                    int buyerId;
                    Map<Item, Integer> itemMap = new HashMap<Item, Integer>();

                    JSONObject billData = billListData.getJSONObject(i);

                    total = billData.getInt("total");
                    buyerId = billData.getInt("buyerId");

                    // make map from json
                    JSONArray mapData = billData.getJSONArray("map");
                    for(int j = 0; j < mapData.length(); j++){
                        JSONObject itemContData = mapData.getJSONObject(j);

                        JSONObject itemData = itemContData.getJSONObject(String.valueOf(j));
                        Item newItem = Item.getItemObject(itemData);
                        int amount = itemData.getInt("amount");

                        // put on the map
                        itemMap.put(newItem, amount);

                    }
                    Bill newBill = new Bill(total, buyerId, itemMap);
                    billList.add(newBill);
                }
            }
            else {
                for (int i = 0; i < billListData.length(); i++) {
                    int total;
                    int buyerId;
                    boolean paid;
                    Map<Item, Integer> itemMap = new HashMap<Item, Integer>();

                    JSONObject billData = billListData.getJSONObject(i);

                    total = billData.getInt("total");
                    buyerId = billData.getInt("buyerId");
                    paid = billData.getBoolean("paid");

                    // make map from json
                    JSONArray mapData = billData.getJSONArray("map");
                    for(int j = 0; j < mapData.length(); j++){
                        JSONObject itemContData = mapData.getJSONObject(j);

                        JSONObject itemData = itemContData.getJSONObject(String.valueOf(j));
                        Item newItem = Item.getItemObject(itemData);
                        int amount = itemData.getInt("amount");

                        // put on the map
                        itemMap.put(newItem, amount);

                    }
                    Bill tempBill = new Bill(total,buyerId,itemMap);
                    FixedBill newBill = new FixedBill(tempBill,true);
                    billList.add(newBill);
                }

            }
        }
        catch (JSONException error){
            System.out.println("JSON Exception: " + error.getMessage());
        }


    }

    public void saveData(){
        JSONArray billListData = new JSONArray();
        try {
            for (Receipt oneBill : billList) {
                JSONObject billData = oneBill.toJson();
                billListData.put(billData);

            }
            DataBill.updateData(billListData);
        }
        catch (JSONException error){
            System.out.println("JSON Exception: " + error.getMessage());
        }
    }

    public void addBill(Bill addedBill){
        this.billList.add(addedBill);
    }

}
