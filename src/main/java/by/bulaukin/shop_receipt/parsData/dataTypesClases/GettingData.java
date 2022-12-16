package by.bulaukin.shop_receipt.parsData.dataTypesClases;

import by.bulaukin.shop_receipt.parsData.DataFromRequest;

public interface GettingData {

   <T> DataFromRequest parsData(T data);
}
