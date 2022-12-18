package by.bulaukin.shop_receipt.parsData.gettingData;

import by.bulaukin.shop_receipt.parsData.DataFromRequest;

public interface GettingData {

   <T> DataFromRequest parsData(T data);
}
